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
