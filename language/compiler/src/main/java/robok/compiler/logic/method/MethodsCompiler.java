package robok.compiler.logic.method;

import android.content.*;
import android.widget.*;

import robok.terminal.*;
import robok.methods.*;
import robok.lang.messages.*;
import robok.lang.exceptions.*;
import robok.compiler.logic.*;

public class MethodsCompiler {
	
	private String[] parts;
	private Context context;
	
	private MethodCaller methodCaller;
	private LogicCompilerListener compileListener;
	private RobokTerminal terminal;
	
	public MethodsCompiler(Context context, LogicCompilerListener compileListener){
		this.context = context;
		this.compileListener = compileListener;
        methodCaller = new MethodCaller(context, compileListener);
	}
	
	public void compile(String codeToRun){
		var codeText = codeToRun;
		var parts = codeText.split(" ");
		
		if (isTheMethod(parts[0], "createButton")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
	    } else if (isTheMethod(parts[0], "createText")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else if (isTheMethod(parts[0], "showToast")) {
			methodCaller.callMethod(parts[0], parts[1]);
		} else if (isTheMethod(parts[0], "openTerminal")) {
			methodCaller.callMethod(parts[0]);
		} else if (isTheMethod(parts[0], "showDialog")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else {
			terminal.addErrorLog(Exceptions.NO_METHOD_FOUND, Messages.NO_METHOD_FOUND);
		}
	}
	
	public boolean isTheMethod(String receiveMethodName, String methodName){
		if (receiveMethodName.contains(methodName)) {
			return true;
	    } else {
			return false;
		}
	}	
}