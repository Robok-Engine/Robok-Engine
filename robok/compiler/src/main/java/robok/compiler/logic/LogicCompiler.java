/* 
   LogicCompiler: Action area compiler, used only for creating actions at runtime. 
   Not used for layout creations
 */

package robok.compiler.logic;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import robok.lang.modifier.ModifyAccess;
import robok.lang.primitive.Primitives;
import robok.lang.modifier.ModifyNonAccess;
import robok.lang.variable.VariableObject;
import robok.lang.method.Method;
import robok.util.terminal.RobokTerminal;

public class LogicCompiler {

    private Context context;
    private List<String> logs;
    private List<VariableObject> variables;
    private Map<String, Method> methods; // Stores method bodies
    private Stack<String> blockStack; // Stack to manage blocks
    private RobokTerminal robokTerminal;
    private LogicCompilerListener compilerListener;
    private Primitives primitives;

    private boolean methodOpen = false;
    private String currentMethodName = null;
    private StringBuilder currentMethodBody = new StringBuilder();
    private String currentMethodParameters = null;

    private int currentLineIndex; // Current line index
    private String[] codeLines; // Array of code lines

    private boolean bracesWithinMethod = false;
    
    public LogicCompiler(Context context, LogicCompilerListener compilerListener) {
        this.context = context;
        this.compilerListener = compilerListener;
        this.variables = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.methods = new HashMap<>();
        this.blockStack = new Stack<>();
        this.robokTerminal = new RobokTerminal();
    }

    public void addLog(String tag, String log) {
        robokTerminal.addLog(tag, log);
        compilerListener.onCompiling(log);
    }

    public String getLogs() {
        return robokTerminal.getLogs();
    }

    public String getVariables() {
        StringBuilder log = new StringBuilder("\n\nTypes of Variables used:\n");
        StringBuilder types = new StringBuilder();

        for (VariableObject vObject : variables) {
            types.append(vObject.getType()).append(",");
        }
        log.append(types);

        return log.toString();
    }

    public void compile(String code) {
        long startTime = System.nanoTime(); // Start time
        
        code = removeAllComments(code); // remove comments
        
        // organize lines
        code = code.replaceAll(";\\s*", ";\n");
        codeLines = code.split("\n");
        currentLineIndex = 0;
        
        boolean packageDeclared = false;
        boolean classDeclared = false;
        String packagee = null;
        
        StringBuilder imports = new StringBuilder();
        StringBuilder clazz = new StringBuilder();

        for (String line : codeLines) {
            if (!packageDeclared && line.trim().startsWith("package ")) {
                packageDeclared = true;
                packagee = line.replace("package ", "");
                robokTerminal.addLog("Package: ", packagee);
            } else if (!classDeclared && line.trim().startsWith("import ")) {
                imports.append(line).append("\n");
                robokTerminal.addLog("Imports: ", line);
            } else if (!classDeclared) {
                classDeclared = extractClass(line);
            } else {
                if (!line.isEmpty()) {
                    readCode(line);
                }
            }
            currentLineIndex++;
        }

        // Iterate over the methods stored in the map
        for (Method method : methods.values()) {
            String methodName = method.getName();
            String methodParameters = method.getParameters();
            String methodBody = method.getCode();

            //displaying method names and bodies
            addLog("Methods", "Method Name: " + methodName);
            addLog("Methods", "Method Parameters: " + methodParameters);
            addLog("Methods", "Method Body:\n" + methodBody);
        }

        long endTime = System.nanoTime(); // End time
        long durationNano = endTime - startTime; // Calculate duration
        double durationSeconds = durationNano / 1_000_000_000.0; // Convert to seconds
        
        //clear times for performance
        startTime = 0;
        endTime = 0;
        durationNano = 0;
        
        addLog("System","Compilation Sucess: " + durationSeconds + " seconds.");
        onExecute(getLogs());
    }

    //method used to remove all comments.
    public static String removeAllComments(String input) {
        //line
        input = input.replaceAll("//.*", "");
        //lines
        input = input.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");
        return input.trim();
    }

    private boolean extractClass(String line) {
        Pattern pattern = Pattern.compile("(\\b(?:public|protected|private|static|final|abstract|synchronized)\\b\\s+)*(class)\\s+(\\w+)\\s*(\\{)?");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String modifiers = matcher.group(1) != null ? matcher.group(1).trim() : "";
            String className = matcher.group(3);

            addLog("Class", "Class Type: " + matcher.group(2));
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
        addLog("test", line);

        if (methodOpen) {
            if (!line.trim().equals("{")) {
                if(line.trim().equals("}") && bracesWithinMethod){
                    currentMethodBody.append(line).append("\n");
                }else if(!line.trim().equals("}")){
                    currentMethodBody.append(line).append("\n");
                }

            }
            if (line.contains("{")) {
                addLog("readCode", "line: " + line + " contains {");
                bracesWithinMethod = true;
                blockStack.push("{");
            } else if (line.contains("}") && bracesWithinMethod == false) {
                addLog("readCode", "method closed");
                blockStack.pop();
                if (!blockStack.isEmpty()) {
                    // Save the method in object
                    Method method =
                            new Method(
                                    currentMethodName,
                                    currentMethodParameters,
                                    currentMethodBody.toString());
                    
                    methods.put(currentMethodName, method);
                    methodOpen = false;
                    currentMethodName = null;
                    currentMethodParameters = null;
                    currentMethodBody.setLength(0); // Clears the StringBuilder
                }
            } else if (line.contains("}") && bracesWithinMethod == true) {
                bracesWithinMethod = false;
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
                            // We are inside a method
                        } else {
                            // Verifying codes in the line, understanding what it means and proceeding.
                            // analyzeCodeFromLine(line);

                            // direct form
                            if (codeIsVariable(line)) {
                                extractDataVariable("class", line);
                            }

                            //at the moment, it is not identifying whether it is a primitive type or class
                            //everything going as class
                        }
                    }
                }
            }
        }
    }

    /* Kept stored, will be used soon */
    private void analyzeCodeFromLine(String line){
        String[] parts = line.split(" ");

        for (int j = 0; j < parts.length; j++) {
            String part = parts[j];

            //creating boolean that stores if it is a variable

            //checking if it is the first code of the line
            //if true, will check if it is class or variable
            if (j == 0) {
                //True, checking if class or variable was referred

                char firstChar = part.charAt(0);

                //Check if the first code is a class or a variable
                String supertype = verifyIfClass(firstChar, part);

                if (codeIsVariable(line)) {
                    extractDataVariable(supertype, line);
                }

            } else {
                //False, the code is not the first

            }
        }
    }

    private void extractMethod(String line) {
    Pattern pattern = Pattern.compile("(\\b(?:public|protected|private|static|final|abstract|synchronized)\\b\\s+)*(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*\\(([^)]*)\\)\\s*(\\{)?");
    Matcher matcher = pattern.matcher(line);

    if (matcher.find()) {
        String methodName = matcher.group(3);
        currentMethodName = methodName;
        currentMethodParameters = matcher.group(4); // Capture parameters
        currentMethodBody = new StringBuilder();

        // Do not add the line containing the method signature
        if (matcher.group(5) != null || line.trim().endsWith("{")) {
            blockStack.push("{");
        }

        methodOpen = true;

        addLog("Method", "Method Name: " + methodName);
        addLog("Method", "Parameters: " + currentMethodParameters);
    }
}

    private String verifyIfClass(char firstChar, String code) {

        String result = "";

        if (Character.isUpperCase(firstChar)) {
            /*
             First character is in upper case, the code
             must be referring to a class, forward class search.
             */
            robokTerminal.addWarningLog("void verifyIfClass:", "fell here");

            result = "class";
        } else {
            /*
             First character is not in upper case, the code
             must be referring to an already created variable, forward variable search.
             */

            /*Before checking whether it is a variable, it is necessary to check whether it is 
             of a primitive type.*/
            if (codeIsPrimitive(code)) {
                //Is primitive
                robokTerminal.addWarningLog("PrimitiveType", "primitive type found: " + code);
                return "primitive";
            } else {
                addLog("VerifyClassOrVariable","The code is not a primitive type\nCode {" + code + "}");
                addLog("VerifyClassOrVariable", "checking if it is already a created variable");

            }

            //result = verifyAccessModifiersOrPrimitive(code);
        }

        return result;
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
            
            // thdev: here if macth is equal to var, it calls the ObjectVariable method, passing the match, otherwise it just receives
            String type = matcher.group(2).equalsIgnoreCase("var") ? VariableObject.setVariableTypeFromValue(matcher.group(4)) : matcher.group(2);
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
        // trindadedev: for now only the log is returned to the IDE.
    }

    private String getNextLine() {
        if (currentLineIndex < codeLines.length) {
            return codeLines[currentLineIndex++];
        }
        return null;
    }
}