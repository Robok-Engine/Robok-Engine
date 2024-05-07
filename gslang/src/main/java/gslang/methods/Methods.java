package gslang.methods;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; 
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gslang.R; 

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Methods {

    private static int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
    private static Context mCtx;    
    private static LinearLayout terminal;
    private static BottomSheetDialog terminalSheet;
	private static View bottomSheetView;
	
    
    public Methods(Context context) {
        this.mCtx = context;
		initializeBottomSheet();
        terminalSheet.setCancelable(true);
        terminal = bottomSheetView.findViewById(R.id.terminal);
    }
    
    public void initializeBottomSheet() {
        bottomSheetView = LayoutInflater.from(mCtx).inflate(R.layout.terminal, null);
		terminalSheet = new BottomSheetDialog(mCtx);
		terminalSheet.setContentView(bottomSheetView);
    }
    
    public void onExecute(int typeCode) {
       if (typeCode == 1) {
          openTerminal();
       }
    }
    
    public void addView(View view){
        terminal.addView(view);
    }
    
    public void openTerminal(){
        terminalSheet.show();
    }

    public void createButton(String text, Color bgColor) {
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        Button button = new Button(mCtx);
        button.setLayoutParams(buttonParams);
        button.setText(text);
        button.setBackgroundColor(bgColor);  
        onExecute(1);
    }

    public void showToast(String s, int lenght) {
        Toast.makeText(mCtx, s, lenght).show();
    }

    public void createText(String textVal, Color txtColor) {
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        TextView text = new TextView(mCtx);
        text.setLayoutParams(textParams);
        text.setText(textVal);
        text.setTextColor(txtColor);
        terminal.addView(text);
        onExecute(1);
    }
	
	public void showDialog (String title, String message){
		MaterialAlertDialogBuilder d = new MaterialAlertDialogBuilder(mCtx);
		d.setTitle(title);
	    d.setMessage(message);
		d.setPositiveButton("OK", (dd, w) ->{
					
		});
		d.show();
		onExecute(0);
	}
}