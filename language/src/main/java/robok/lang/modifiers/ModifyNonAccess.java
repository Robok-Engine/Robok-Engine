package robok.lang.modifiers;
import robok.lang.variables.VariableObject;

public class ModifyNonAccess {
    
    private static final String[] modifyNonAcess = new String[]{
        "static", "final", "native", "volatile", "synchronized", "transient", "abstract", "strictfp"
    };

	public ModifyNonAccess(){

	}
	
	public void verifyModifiersNonAccessFromVariable(VariableObject variableObject, String modifiers){

		boolean isStatic = containsModifier(modifiers, "static");
		boolean isFinal = containsModifier(modifiers, "final");
		boolean isNative = containsModifier(modifiers, "native");
		boolean isSynchronized = containsModifier(modifiers, "synchronized");
		boolean isVolatile = containsModifier(modifiers, "volatile");
		boolean isTransient = containsModifier(modifiers, "transient");
		boolean isAbstract = containsModifier(modifiers, "abstract");
		boolean isStrictfp = containsModifier(modifiers, "strictfp");
		
		variableObject.setModifiers(isStatic, isFinal, isNative, isSynchronized, isVolatile, isTransient, isAbstract,  isStrictfp);
		
	}
	
	
	private static boolean containsModifier(String modifiers, String modifier) {
        return modifiers.contains(modifier);
    }
    
}
