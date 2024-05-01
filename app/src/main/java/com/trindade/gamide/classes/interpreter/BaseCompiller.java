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
		String codeText = codeToRun;
		parts = codeText.split(" ");
		if (methodTyped("createButton")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
			} else if (methodTyped("createText")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
			} else if (methodTyped("showToast")) {
			methodCaller.callMethod(parts[0], parts[1]);
			} else if (methodTyped("openTerminal")) {
			methodCaller.callMethod(parts[0]);
			} else if (methodTyped("clear"))  {
			methodCaller.callMethod(parts[0]);
			} else if (methodTyped("showDialog")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
			} else {
			Toast.makeText(mCtx, "Nenhum método encontrado", 4000).show();
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