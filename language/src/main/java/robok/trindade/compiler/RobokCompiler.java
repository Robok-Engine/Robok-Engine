package robok.trindade.interpreter;

import android.content.*;
import android.widget.*;

import robok.trindade.terminal.*;
import robok.trindade.methods.*;
import robok.trindade.message.*;
import robok.trindade.exception.*;

public class RobokCompiler {
	
	private String[] parts;
	private Context context;
	
	private MethodCaller methodCaller;
	private RobokCompiler.CompilerListener compileListener;
	private RobokTerminal terminal;
	
	public RobokCompiler(Context context, CompilerListener compileListener){
		this.context = context;
		this.compileListener = compileListener;
        methodCaller = new MethodCaller(context, compileListener);
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
			terminal.addErrorLog(Exceptions.NO_METHOD_FOUND, Messages.NO_METHOD_FOUND);
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
	
	public interface CompilerListener {
	    public void onCompiled(String logs);
	}
}