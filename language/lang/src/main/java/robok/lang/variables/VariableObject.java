package robok.lang.variables;

/*
  Essa classe é responsável por obter :
    model: Model da variável (Classe ou primitiva)
    type: Tipo da variável.
    name: Nome da variável.
    value: Valor da variável.
    
 This class is responsible for obtaining:
    model: Model of the variable (Class or primitive)
    type: Type of the variable.
    name: Name of the variable.
    value: Value of the variable.
 */    
public class VariableObject {
    
    private String model, modify_access = "default", type, name, value;
    private boolean is_static, is_native, is_final, is_synchronized, is_volatile, is_transient, is_abstract, is_strictfp;

    public VariableObject(){}

    public VariableObject(String model, String type, String name, String value){
        this.model = model;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public VariableObject(String model, String modify_access, String type, String name, String value){
        this.model = model;
        this.modify_access = modify_access;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /*
     definir modificadores de uma vez só
     set modifiers at once
     */ 
    public void setModifiers(boolean is_static, boolean is_final, boolean is_native, boolean is_synchronized, boolean is_volatile, boolean is_transient, boolean is_abstract, boolean is_strictfp) {
        this.is_static = is_static;
        this.is_final = is_final;
        this.is_native = is_native;
        this.is_synchronized = is_synchronized;
        this.is_volatile = is_volatile;
        this.is_transient = is_transient;
        this.is_abstract = is_abstract;
        this.is_strictfp = is_strictfp;
    }
    
    /*Definir tipo de variavel pelo valor (Usado caso tipo for var)
      Set variable type by value (used if type var)
    */
    public static String setVariableTypeFromValue(String value) {
        // Checks if it is an integer number
        try {
            Integer.parseInt(value);
            return "int";
        } catch (NumberFormatException e) {
            // Not an integer number
        }

        // Checks if it is a long number
        try {
            Long.parseLong(value);
            return "long";
        } catch (NumberFormatException e) {
            // Not a long number
        }
        
        
        // Checks if it is a float number (must end with 'f' or 'F')
        if (value.endsWith("f") || value.endsWith("F")) {
            try {
                Float.parseFloat(value);
                return "float";
            } catch (NumberFormatException e) {
                // Not a float number
            }
        }
        
        // Checks if it is a double number
        try {
            Double.parseDouble(value);
            return "double";
        } catch (NumberFormatException e) {
            // Not a double number
        }

        // Checks if it is a boolean
        String lowerCaseValue = value.toLowerCase();
        if ("true".equals(lowerCaseValue) || "false".equals(lowerCaseValue)) {
            return "boolean";
        }

        // Checks if it is a single character
       /* if (value.length() == 1) {
            return "char";
        }/*
        
      /*thdev: failure to identify find, the value ends up arriving 
        with variable signs ' ' or " "
         
        I'll fix that part soon
     */

        // Otherwise, consider it as a String
        return "String";
    }

    /* 
     Métodos getters para verificar os valores dos modificadores
     Getter methods to check modifier values
     */
    public boolean isStatic() { return is_static; }
    public boolean isNative() { return is_native; }
    public boolean isFinal() { return is_final; }
    public boolean isSynchronized() { return is_synchronized; }
    public boolean isVolatile() { return is_volatile; }
    public boolean isTransient() { return is_transient; }
    public boolean isAbstract() { return is_abstract; }
    public boolean isStrictfp() { return is_strictfp; }
}
