package robok.lang.modifiers;
import java.util.HashMap;

public class ModifyAccess {
    
    private static final String[] modifyAcess = new String[]{
		"public",
		"protected",
		"private",
		"default"
	};

	public ModifyAccess(){

	}

	public ModifyAcessObject codeIsModifyAcess(String code){
		
		boolean isModifyAcess = false;
		String modifyAcessType = "";

		for(int i = 0; i < modifyAcess.length; i++){
			if(code.equals(modifyAcess[i])){
				isModifyAcess = true;
				modifyAcessType = code;
				break;
			}
		}

		return new ModifyAcessObject(isModifyAcess, modifyAcessType);
	}
	
	public static class ModifyAcessObject{
		
		private boolean isModifyAcess;
		private String modifyAcessType;
		
		public ModifyAcessObject(boolean isModifyAcess, String modifyAcessType){
			this.isModifyAcess = isModifyAcess;
			this.modifyAcessType = modifyAcessType;
		}
		
		public boolean getCodeIsModifyAcess(){
			return this.isModifyAcess;
		}
			
		public String getModifyAcessType(){
			return this.modifyAcessType;
		}	
		
	}
    
}
