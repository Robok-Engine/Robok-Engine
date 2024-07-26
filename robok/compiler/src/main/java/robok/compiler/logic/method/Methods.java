package robok.compiler.logic.method;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import android.app.*

import robok.method.R; 
import robok.util.*;
import robok.util.terminal.*;
import robok.compiler.logic.*;


public class Methods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    private RobokTerminal robokTerminal;
    private TextUtil textUtil;
    
    private LogicCompilerListener compileListener;
    
    public Methods (Context context, LogicCompilerListener compileListener) {
        robokContext = context;
        robokTerminal = new RobokTerminal();
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
        
        compileListener.onCompiled(robokTerminal.getLogs());
    }

    public void createText (String text, String txtColor) {
        String txt = textUtil.formatSpaces(text);
        
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        TextView robokText = new TextView(robokContext);
        robokText.setLayoutParams(textParams);
        robokText.setText(textUtil.formatWordWrap(txt));
        robokText.setTextColor(Color.parseColor(txtColor));
        
        compileListener.onCompiled(robokTerminal.getLogs());
    }
    
    public void showDialog (String title, String message){
	    String t = textUtil.formatSpaces(title);
	    String m = textUtil.formatSpaces(message);
	    
		AlertDialog robokDialog = new AlertDialog.Builder(robokContext);
		robokDialog.setTitle(textUtil.formatWordWrap(t));
	    robokDialog.setMessage(textUtil.formatWordWrap(m));
		robokDialog.setPositiveButton("OK", null);
		robokDialog.show();
	}
}