package robok.lang.primitives;

public class Primitives
{
	private static final String[] primitives = new String[]{
		"byte",
		"short",
		"int",
		"long",
		"float",
		"double",
		"char",
		"boolean"
	};
	
	public Primitives(){
		
	}
	
	public boolean getPrimitiveType(String code){
		boolean isPrimitive = false;
		
		for(int i = 0; i < primitives.length; i++){
			if(code.equals(primitives[i])){
				isPrimitive = true;
				break;
			}
		}
		
		return isPrimitive;
	}
}
