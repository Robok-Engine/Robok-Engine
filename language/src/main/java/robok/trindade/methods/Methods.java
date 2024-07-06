package robok.trindade.methods;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.util.*;
import robok.trindade.terminal.*;
import robok.trindade.compiler.*;

import com.google.android.material.dialog.*;

public class Methods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    private RobokTerminal robokTerminal;
    private TextUtil textUtil;
    
    private RobokCompiler.CompilerListener compileListener;
    	
    public Methods (Context context, RobokCompiler.CompilerListener compileListener) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
        textUtil = new TextUtil(context);
    }
    
    
    public void showToast (String val) {
        String value = textUtil.formatSpaces(val);
        Toast.makeText(robokContext, textUtil.formatWordWrap(value), 4000).show();
    }
    
    public void createButton (String text, String bgColor) {
        String txt = textUtil.formatSpaces(text);
        
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        Button robokButton = new Button(robokContext);
        robokButton.setLayoutParams(buttonParams);
        robokButton.setText(textUtil.formatWordWrap(txt));
        robokButton.setBackgroundColor(Color.parseColor(bgColor));
        
        robokTerminal.addToTerminal(robokButton); 
        compileListener.onCompiled(robokTerminal.getLogs());
    }

    public void createText (String text, String txtColor) {
        String txt = textUtil.formatSpaces(text);
        
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        TextView robokText = new TextView(robokContext);
        robokText.setLayoutParams(textParams);
        robokText.setText(textUtil.formatWordWrap(txt));
        robokText.setTextColor(Color.parseColor(txtColor));
        
        robokTerminal.addToTerminal(robokText);
        compileListener.onCompiled(robokTerminal.getLogs());
    }
    
    public void showDialog (String title, String message){
	    String t = textUtil.formatSpaces(title);
	    String m = textUtil.formatSpaces(message);
	    
		MaterialAlertDialogBuilder robokDialog = new MaterialAlertDialogBuilder(robokContext);
		robokDialog.setTitle(textUtil.formatWordWrap(t));
	    robokDialog.setMessage(textUtil.formatWordWrap(m));
		robokDialog.setPositiveButton("OK", null);
		robokDialog.show();
		
		onExecute(0);
	}
    
}