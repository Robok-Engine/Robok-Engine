/* EngineCompiler: Compilador da area de ações, usado apenas para criãção de ações em tempo de execução.
   Não ultilizado para criações de layout */

package robok.trindade.compiler;
import android.content.Context;
import robok.lang.modifiers.ModifyNonAccess;
import robok.lang.variables.VariableObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import robok.lang.modifiers.ModifyAccess;
import robok.lang.primitives.Primitives;
import robok.trindade.terminal.RobokTerminal;

public class EngineCompiler {

	Context context;
	//LinearLayout linearLayout;
	//String logs = "";
	List<String> logs;
	//char[] characters;
	List<VariableObject> variables;
	
	public final static String i = "oi";

	Primitives primitives;
	ModifyAccess modifyAcess;

	RobokTerminal robokTerminal;

	public EngineCompiler(Context context) {
		this.context = context;
		variables = new ArrayList<>();
		logs = new ArrayList<>();

		robokTerminal = new RobokTerminal();
		//logs.add("teste");
		//linearLayout = new LinearLayout(context);


	}

	public void addLog(String tag, String line) {
		robokTerminal.addWarningLog("test", line);
		//logs.add("\n" + (logs.size() + 1) + "| " + line);
	}

	public String getLogs() {
		return robokTerminal.getLogs();
		//logs.toString();
	}

	public String getVariabbles() {
		String log = "\n\nTipos de Variaveis ultilizadas:\n";
		String types = "";

		for (VariableObject vObject : variables) {
			types = types + vObject.getType() + ",";
		}
		log = log + types;

		return log;
	}

	public void execute(String code) {
		// Dividir o código em linhas
		code = code.replaceAll(";\\s*", ";\n");
		String[] lines = code.split("\n");

		boolean packageDeclared = false;
		boolean classDeclared = false;
		String imports = "";
		String clazz = "";
		//List<String> variaveis = new ArrayList<>();
		//List<String> metodos = new ArrayList<>();

		// Loop pelas linhas do código
		for (String line : lines) {
			if (!packageDeclared && line.trim().startsWith("package ")) {
				// Pacote declarado
				packageDeclared = true;
			} else if (!classDeclared && line.trim().startsWith("public class ")) {
				// Classe declarada
				classDeclared = true;
				clazz += line + "\n";
			} else if (packageDeclared && line.trim().startsWith("import ")) {
				// Importes antes do pacote
				imports += line + "\n";
			} else if (classDeclared) {
				if (!line.isEmpty()) {
					readCode(0, line);
				}
			}
		}

		robokTerminal.addWarningLog("Imports: " , imports);
		robokTerminal.addWarningLog("Classes: " , clazz);
	}

	//Não ultilizado, apenas está aqui para aproveitamento de partes do codigo
	public void executeAntigo(String code) {

		//code = code.replaceAll(";([^\\n])", ";\n$1");
		code = code.replaceAll(";\\s*", ";\n");
		String[] linhas = code.split("\n");

		logs.add("caiu aquu");
		logs.add("linhas total: " + linhas.length);


        for (int i = 0; i < linhas.length; i++) {
			//logs.add("linhas " + i);
			String linha = linhas[i];
			/*  if (codeIsVariable(linha)) {
			 logs.add("\nLinha \"" + linha + "\"é variavel");

			 extractDataVariable(linha);
			 }else logs.add("\nLinha \"" + linha + "\"não é variavel");*/
			//logs.add("Linha: " + i);

			//if(!linha.isEmpty()){
			readCode(i, linha);
			//}


        }
	}

	private void readCode(int numLinha, String linha) {
		String[] parts = linha.split(" ");

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
				
				if (codeIsVariable(linha)) {
					//addLog("caiu dnv 140");
					extractDataVariable(supertype, linha);
				}

			} else {
				//Falso, o codigo não é o primeiro

			}

		}
	}


	//Não ultilizado, por favor não remover (ainda em testes)
	private String verifyAcessModifiersOrPrimitive(String code) {
//parou aqui
		if (codeIsModifyAcess(code).getCodeIsModifyAcess()) {
			addLog("ModifiersAcces", "modificador de acesso encontrado: " + code);
			return "modify_acess";
			
		} else if (codeIsPrimitive(code)) {
			//É primitivo
			robokTerminal.addWarningLog("PrimitivesType" , "tipo primitivo encontrado: " + code);
			return "primitive";
		} else {
			robokTerminal.addWarningLog("ClassOrVariableNotFound", "void verifyClassOrVariable: O codigo não é um modificador de acesso nem um tipo primitivo\nCodigo {" + code + "}");
			robokTerminal.addWarningLog("verifyClassOrVariable", "verificando se já se trata de uma variavel criada");

		}
		return "undefined";
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
				robokTerminal.addWarningLog("VerifyClassOrVariable","O codigo não é um tipo primitivo\nCodigo {" + code + "}");
				robokTerminal.addWarningLog("VerifyClassOrVariable", "verificando se já se trata de uma variavel criada");

			}
			 
			//retorno = verifyAcessModifiersOrPrimitive(code);
		}

		return retorno;
	}	

	private ModifyAccess.ModifyAcessObject codeIsModifyAcess(String code) {
		if (modifyAcess == null) {
			modifyAcess = new ModifyAccess();
		}

		return modifyAcess.codeIsModifyAcess(code);

	}

	private boolean codeIsPrimitive(String code) {
		if (primitives == null) {
			primitives = new Primitives();
		}

		return primitives.getPrimitiveType(code);

	}	

	private static boolean codeIsVariable(String linha) {
		Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
		
		//pega modificadores de acesso, tipos, nomes, valores, porem regex e exibido os nomes dos modificadores de acesso
		//"(?:public|protected|private)?\\s*(\\w+)\\s+(\\w+)\\s*=\\s*\"?(.*?)\"?;?"
		
		//pega o tipo, nome, valor (não pega modificadores de acesso
		/*"(\\w+)\\s+(\\w+)\\s*=\\s*\"?(.*?)\"?;\\s*"*/
		Matcher matcher = pattern.matcher(linha);
		return matcher.matches();
	}

	private void extractDataVariable(String supertype, String linha) {
		Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
		Matcher matcher = pattern.matcher(linha);

		if (matcher.find()) {
			String modify_access = matcher.group(1);
			if (modify_access == null) {
				modify_access = "default";
			} else {
				modify_access = modify_access.trim(); // Remover espaços extras
			}

			String type = matcher.group(2);
			String name = matcher.group(3);
			String value = matcher.group(4);

			VariableObject variable = new VariableObject(supertype, modify_access, type, name, value);

			ModifyNonAccess modifyNonAccess = new ModifyNonAccess();
			
			modifyNonAccess.verifyModifiersNonAccessFromVariable(variable, modify_access);
			
			variables.add(variable);

			robokTerminal.addWarningLog("Variable", "Variavel Encontrada: " + variable.getType());
			robokTerminal.addWarningLog("Variable", "Modificador de acesso: " + modify_access);
			robokTerminal.addWarningLog("Variable", "Type: " + type);
			robokTerminal.addWarningLog("Variable", "Name: " + name);
			robokTerminal.addWarningLog("Variable", "Valor: " + value);
			
			robokTerminal.addWarningLog("Variable", "IsStatic " + variable.isStatic());
			robokTerminal.addWarningLog("Variable", "IsFinal " + variable.isFinal());
			robokTerminal.addWarningLog("Variable", "IsNative " + variable.isNative());
			robokTerminal.addWarningLog("Variable", "IsSynchronized " + variable.isSynchronized());
			robokTerminal.addWarningLog("Variable", "IsVolatile " + variable.isVolatile());
			robokTerminal.addWarningLog("Variable", "IsTransient " + variable.isTransient());
			robokTerminal.addWarningLog("Variable", "IsAbstract " + variable.isAbstract());
			robokTerminal.addWarningLog("Variable", "IsStrictfp " + variable.isStrictfp());
			
			System.out.println("Tipo: " + type);
			System.out.println("Nome: " + name);
			System.out.println("Valor: " + value);

			// Para obter o tipo da variável
			Class<?> classType = null;
			try {
				classType = Class.forName(type);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Classe do tipo: " + classType);
		}
	}
	
   /* private void extractDataVariable(String supertype, String linha) {
		Pattern pattern = Pattern.compile("(\\b(?:public|protected|private|static|final)\\b\\s+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
		Matcher matcher = pattern.matcher(linha);

		if (matcher.find()) {
			String modify_access = matcher.group(1);
			if (modify_access == null) {
				modify_access = "default";
			} else {
				modify_access = modify_access.trim(); // Remover espaços extras
			}

			String type = matcher.group(2);
			String name = matcher.group(3);
			String value = matcher.group(4);

			VariableObject variable = new VariableObject(supertype, modify_access, type, name, value);

			variables.add(variable);

			addLog("Variavel Encontrada: " + variable.getType());
			addLog("Modificador de acesso: " + modify_access);
			addLog("Type: " + type);
			addLog("Name: " + name);
			addLog("Valor: " + value);

			System.out.println("Tipo: " + type);
			System.out.println("Nome: " + name);
			System.out.println("Valor: " + value);

			// Para obter o tipo da variável
			Class<?> classType = null;
			try {
				classType = Class.forName(type);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Classe do tipo: " + classType);
		}
	}*/
}
