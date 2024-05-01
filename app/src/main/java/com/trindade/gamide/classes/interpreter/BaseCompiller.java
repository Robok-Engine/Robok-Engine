package com.trindade.gamide.classes.interpreter;

//Android
import android.content.Context;
import android.widget.Toast;

//GamIDE
import com.trindade.gamide.gslang.methods.MethodCaller;
import com.trindade.gamide.ui.fragments.EditorFragment;

public class BaseCompiller {
	
	String[] parts;
	MethodCaller methodCaller;
	Context mCtx;
	
	
	public BaseCompiller(Context ctx){
		this.mCtx = ctx;
        methodCaller = new MethodCaller(mCtx, new EditorFragment());
	}
	
	public void compile(String codeToRun){
    String[] lines = codeToRun.split("\\r?\\n"); // Divide o código em linhas
    
    for (String line : lines) {
        String[] parts = line.split("\\s+"); 
        
        if (parts.length == 0) {
            continue; 
        }
        
        if (methodTyped(parts[0])) {
            switch (parts[0]) {
                case "createButton":
                case "createText":
                    methodCaller.callMethod(parts[0], parts[1], parts[2]);
                    break;
                case "showToast":
                    methodCaller.callMethod(parts[0], parts[1]);
                    break;
                case "openTerminal":
                case "clear":
                    methodCaller.callMethod(parts[0]);
                    break;
                case "showDialog":
                    methodCaller.callMethod(parts[0], parts[1], parts[2]);
                    break;
            }
        } else {
            Toast.makeText(mCtx, "Nenhum método encontrado", 4000).show();
        }
    }
}
	
	public boolean methodTyped(String methodName){
		boolean returnVal;
		if (parts[0].contains(methodName)) {
			returnVal = true;
			} else {
			returnVal = false;
		}
		return  returnVal;
	}
	
}