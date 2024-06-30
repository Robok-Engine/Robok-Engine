package robok.trindade.interpreter;

import android.content.*;
import android.widget.*;

import robok.trindade.methods.*;

public class RobokCompiler {
	
	String[] parts;
	MethodCaller methodCaller;
	Context context;
	
	
	public RobokCompiler(Context context){
		this.context = context;
        methodCaller = new MethodCaller(context);
	}
	
	public void compile(String codeToRun){
		var codeText = codeToRun;
		var parts = codeText.split(" ");
		if (methodTyped(parts[0], "createButton")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
	    } else if (methodTyped(parts[0], "createText")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else if (methodTyped(parts[0], "showToast")) {
			methodCaller.callMethod(parts[0], parts[1]);
		} else if (methodTyped(parts[0], "openTerminal")) {
			methodCaller.callMethod(parts[0]);
		} else if (methodTyped(parts[0], "showDialog")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else {
			Toast.makeText(context, "Nenhum método encontrado", 4000).show();
		}
	}
	
	public boolean methodTyped(String parts, String methodName){
		boolean returnVal;
		if (parts.contains(methodName)) {
			returnVal = true;
	    } else {
			returnVal = false;
		}
		return  returnVal;
	}	
}