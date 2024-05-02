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
    String[] lines = codeToRun.split("\\r?\\n");
    
    for (String line : lines) {
        String[] parts = line.split("\\s+");
        
        if (parts.length == 0) {
            continue;
        }
        
        if (methodTyped(parts[0])) {
            switch (parts[0]) {
                case "createButton":
                case "createText":
                    if (parts.length >= 3) {
                        methodCaller.callMethod(parts[0], parts[1], parts[2]);
                    } else {
                        // Exibir mensagem de erro se não houver argumentos suficientes
                        Toast.makeText(mCtx, "Número insuficiente de argumentos para " + parts[0], 4000).show();
                    }
                    break;
                case "showToast":
                    if (parts.length >= 2) {
                        methodCaller.callMethod(parts[0], parts[1]);
                    } else {
                        Toast.makeText(mCtx, "Número insuficiente de argumentos para " + parts[0], 4000).show();
                    }
                    break;
                case "openTerminal":
                case "clear":
                    if (parts.length >= 1) {
                        methodCaller.callMethod(parts[0]);
                    } else {
                        Toast.makeText(mCtx, "Número insuficiente de argumentos para " + parts[0], 4000).show();
                    }
                    break;
                case "showDialog":
                    if (parts.length >= 3) {
                        methodCaller.callMethod(parts[0], parts[1], parts[2]);
                    } else {
                        Toast.makeText(mCtx, "Número insuficiente de argumentos para " + parts[0], 4000).show();
                    }
                    break;
            }
        } else {
            Toast.makeText(mCtx, "Nenhum método encontrado para " + parts[0], 4000).show();
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