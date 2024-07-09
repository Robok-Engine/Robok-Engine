/* 
   LogicCompiler: Compilador da area de ações, usado apenas para criãção de ações em tempo de execução.
   Não ultilizado para criações de layout
 */

package robok.dev.compiler.logic;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import robok.lang.modifiers.ModifyAccess;
import robok.lang.primitives.Primitives;
import robok.dev.terminal.RobokTerminal;
import robok.lang.modifiers.ModifyNonAccess;
import robok.lang.variables.VariableObject;

public class LogicCompiler {

    private Context context;
    private List<String> logs;
    private List<VariableObject> variables;
    private Map<String, String> methods; // Armazena o corpo dos métodos
    private Stack<String> blockStack; // Pilha para gerenciar blocos
    private RobokTerminal robokTerminal;
    private LogicCompilerListener compilerListener;
	Primitives primitives;
	
    private boolean methodOpen = false;
    private String currentMethodName = null;
    private StringBuilder currentMethodBody = new StringBuilder();

    private int currentLineIndex; // Índice atual da linha
    private String[] codeLines; // Array de linhas de código
	
	
	boolean chavesDentroDoMetodo = false;

    public LogicCompiler(Context context, LogicCompilerListener compilerListener) {
        this.context = context;
        this.compilerListener = compilerListener;
        this.variables = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.methods = new HashMap<>();
        this.blockStack = new Stack<>();
        this.robokTerminal = new RobokTerminal();
    }

    public void addLog(String tag, String line) {
        robokTerminal.addLog(tag, line);
    }

    public String getLogs() {
        return robokTerminal.getLogs();
    }

    public String getVariables() {
        StringBuilder log = new StringBuilder("\n\nTipos de Variaveis ultilizadas:\n");
        StringBuilder types = new StringBuilder();

        for (VariableObject vObject : variables) {
            types.append(vObject.getType()).append(",");
        }
        log.append(types);

        return log.toString();
    }

    public void compile(String code) {
        
        code = removeAllComments(code);
        code = code.replaceAll(";\\s*", ";\n");
        codeLines = code.split("\n");
        currentLineIndex = 0;

        boolean packageDeclared = false;
        boolean classDeclared = false;
        StringBuilder imports = new StringBuilder();
        StringBuilder clazz = new StringBuilder();
		
		
        for (String line : codeLines) {
            
           // if(line.indexOf("//") != -1) line = removeComments(line);
            
            if (!packageDeclared && line.trim().startsWith("package ")) {
                packageDeclared = true;
            } else if (!classDeclared && line.trim().startsWith("import ")) {
                imports.append(line).append("\n");
            } else if (!classDeclared) {
                classDeclared = extractClass(line);
            } else {
                if (!line.isEmpty()) {
                    readCode(line);
                }
            }
            currentLineIndex++;
        }

        robokTerminal.addWarningLog("Imports: ", imports.toString());
        robokTerminal.addWarningLog("Classes: ", clazz.toString());

        // Iterar sobre os métodos armazenados no mapa
        for (String methodName : methods.keySet()) {
            String methodBody = methods.get(methodName);

            // Aqui você pode fazer o que precisar com o nome do método e o corpo do método
            addLog("Methods", "Nome do método: " + methodName);
            addLog("Methods", "Corpo do método:\n" + methodBody);

            // Ou qualquer outra operação que deseje realizar com os métodos
        }

        onExecute(robokTerminal.getLogs());
    }
    
    
    public static String removeAllComments(String input) {
        // Remove comentários de linha única
        input = input.replaceAll("//.*", "");
        // Remove comentários de bloco
        input = input.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");
        return input.trim();
    }
    
   /* public static String removeComments(String input) {
        int commentIndex = input.indexOf("//");
        if (commentIndex != -1) {
            return input.substring(0, commentIndex).trim();
        }
        return input;
    }*/

    private boolean extractClass(String line) {
        Pattern pattern = Pattern.compile("(\\b(?:public|protected|private|static|final|abstract|synchronized)\\b\\s+)*(class)\\s+(\\w+)\\s*(\\{)?");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String modifiers = matcher.group(1) != null ? matcher.group(1).trim() : "";
            String className = matcher.group(3);

            addLog("Class", "Modifiers: " + modifiers);
            addLog("Class", "Class Name: " + className);

            if (matcher.group(4) != null) {
                blockStack.push("{");
            }
            return true;
        }
        return false;
    }

    private void readCode(String line) {
		addLog("teste", line);

		if (methodOpen) {
			if (!line.trim().equals("{")) {
				if(line.trim().equals("}") && chavesDentroDoMetodo){
					currentMethodBody.append(line).append("\n");
				}else if(!line.trim().equals("}")){
					currentMethodBody.append(line).append("\n");
				}
				
			}
			if (line.contains("{")) {
				addLog("readCode",  "linha: " + line + " possui {");
				chavesDentroDoMetodo = true;
				blockStack.push("{");
			} else if (line.contains("}") && chavesDentroDoMetodo == false) {
				addLog("readCode", "fechou o metodo");
				blockStack.pop();
				//blockStack.pop();
				if (!blockStack.isEmpty()) {
					methods.put(currentMethodName, currentMethodBody.toString());
					methodOpen = false;
					currentMethodName = null;
					currentMethodBody.setLength(0); // Limpa o StringBuilder
				}
			}else if(line.contains("}") && chavesDentroDoMetodo == true){
				chavesDentroDoMetodo = false;
				//blockStack.pop();

			}
		} else {
			if (line.contains("{") && !line.contains("(") && !line.contains(")")) {
				blockStack.push("{");
			} else if (line.contains("}")) {
				if (!blockStack.isEmpty()) {
					blockStack.pop();
				}
			} else {
				if (!blockStack.isEmpty()) {
					if (line.contains("(") && line.contains(")")) {
						extractMethod(line);
					} else {
						if (blockStack.size() > 1) {
							// Estamos dentro de um método
						} else {
							//Verificando codigos na linha, entendendo o que significa e prosseguindo.
							//analizeCodeFromLine(line);
							
							//indo forma direta
							extractDataVariable("class", line);
							
							//no momento, não está indentificando se é tipo primitivo ou classe
							//indo tudo como class
						}
					}
				}
			}
		}
	}
	
	/*Mantida guardada, será usado em breve*/
	private void analizeCodeFromLine(String line){
		String[] parts = line.split(" ");

		for (int j = 0; j < parts.length; j++) {
			String part = parts[j];

			//criando boolean que armazena se é variavel

			//verificando se trata do primeiro codigo da linha
			//caso verdadeiro, irá verificar se é classe ou variavel
			if (j == 0) {
				//Verdadeiro, verificando se foi referido classe ou variavel

				char firstChar = part.charAt(0);

				//Verificar se o primeiro codigo é uma classe ou uma variavel
				String supertype = verifyIfClass(firstChar, part);

				//addLog("caiu no 137");

				if (codeIsVariable(line)) {
					//addLog("caiu dnv 140");
					extractDataVariable(supertype, line);
				}

			} else {
				//Falso, o codigo não é o primeiro

			}
	}
	}

    private void extractMethod(String line) {
		Pattern pattern = Pattern.compile("(\\b(?:public|protected|private|static|final|abstract|synchronized)\\b\\s+)*(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*\\(([^)]*)\\)\\s*(\\{)?");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			String methodName = matcher.group(3);
			currentMethodName = methodName;
			currentMethodBody = new StringBuilder();

			// Não adicionar a linha que contém a assinatura do método
			if (matcher.group(5) != null || line.trim().endsWith("{")) {
				blockStack.push("{");
			}

			methodOpen = true;

			addLog("Method", "Method Name: " + methodName);
		}else{
			//Excecão (CodeReadingException) //exiba linha do codigo
			/*Ex: CodeReadingException: is this code really correct? (code)*/
		}
	}
	
	private String verifyIfClass(char firstChar, String code) {

		String retorno = "";

		if (Character.isUpperCase(firstChar)) {
			/*
			 Primeiro caractere está em caixa alta, o codigo
			 deve está se referindo a uma classe, encaminhar busca de classe 
			 */
			robokTerminal.addWarningLog("void verifyIfClass:", "caiu aqui");

			retorno = "class";
		} else {
			/*
			 Primeiro caractere não está em caixa alta, o codigo
			 deve está se referindo a uma variavel já criada, encaminhar busca de variavel 
			 */

			/*Antes verificar se trata de uma variavel, e necessario verificar se trata-se
			 de um tipo primitivo*/

			if (codeIsPrimitive(code)) {
				//É primitivo
				robokTerminal.addWarningLog("PrimitiveType", "tipo primitivo encontrado: " + code);
				return "primitive";
			} else {
				addLog("VerifyClassOrVariable","O codigo não é um tipo primitivo\nCodigo {" + code + "}");
				addLog("VerifyClassOrVariable", "verificando se já se trata de uma variavel criada");

			}

			//retorno = verifyAcessModifiersOrPrimitive(code);
		}

		return retorno;
	}	
	
	private boolean codeIsPrimitive(String code) {
		if (primitives == null) {
			primitives = new Primitives();
		}

		return primitives.getPrimitiveType(code);

	}	

    private boolean codeIsVariable(String line) {
        Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    private void extractDataVariable(String supertype, String line) {
        Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String modify_access = matcher.group(1) != null ? matcher.group(1).trim() : "default";
            String type = matcher.group(2);
            String name = matcher.group(3);
            String value = matcher.group(4);

            VariableObject variable = new VariableObject(supertype, modify_access, type, name, value);

            ModifyNonAccess modifyNonAccess = new ModifyNonAccess();
            modifyNonAccess.verifyModifiersNonAccessFromVariable(variable, modify_access);

            variables.add(variable);

            addLog("Variable", "Variavel Encontrada: " + variable.getType());
            addLog("Variable", "Modificador de acesso: " + modify_access);
            addLog("Variable", "Type: " + type);
            addLog("Variable", "Name: " + name);
            addLog("Variable", "Valor: " + value);

            addLog("Variable", "IsStatic " + variable.isStatic());
            addLog("Variable", "IsFinal " + variable.isFinal());
            addLog("Variable", "IsNative " + variable.isNative());
            addLog("Variable", "IsSynchronized " + variable.isSynchronized());
            addLog("Variable", "IsVolatile " + variable.isVolatile());
            addLog("Variable", "IsTransient " + variable.isTransient());
            addLog("Variable", "IsAbstract " + variable.isAbstract());
            addLog("Variable", "IsStrictfp " + variable.isStrictfp());
        }
    }

    private void onExecute(String logs) {
        compilerListener.onCompiled(logs);
    }

    private String getNextLine() {
        if (currentLineIndex < codeLines.length) {
            return codeLines[currentLineIndex++];
        }
        return null;
    }
}