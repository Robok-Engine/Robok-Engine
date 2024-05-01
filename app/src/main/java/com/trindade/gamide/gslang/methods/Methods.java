package com.trindade.gamide.gslang.methods;

//Android
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; 
import android.widget.LinearLayout;
import android.widget.Toast;

//AndroidX
import androidx.appcompat.app.AppCompatActivity;

//GamIDE
import com.trindade.gamide.ui.fragments.EditorFragment;
import com.trindade.gamide.R;

//Java
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.lang.ref.WeakReference;

//Google
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Methods {
    private Context mCtx;
    private WeakReference<EditorFragment> weak;
    private LinearLayout terminal;
    private BottomSheetDialog terminalSheet;
	private View bottomSheetView;
    
    public Methods(Context context, EditorFragment mainActivity) {
        this.mCtx = context;
        this.weak = new WeakReference<>(mainActivity);
		clear();
        terminalSheet.setCancelable(true);
        terminal = bottomSheetView.findViewById(R.id.terminal);
    }
	
	public void clear(){
		bottomSheetView = LayoutInflater.from(mCtx).inflate(R.layout.terminal, null);
		terminalSheet = new BottomSheetDialog(mCtx);
		terminalSheet.setContentView(bottomSheetView);
	}
    
    public void openTerminal(){
        terminalSheet.show();
    }

    public void createButton(String text, String bgColor) {
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Button button = new Button(mCtx);
        button.setLayoutParams(buttonParams);
        button.setText(text);
       // button.setBackgroundColor(Color.parseColor(bgColor));
        terminal.addView(button);
        openTerminal();
    }

    public void showToast(String s) {
        Toast.makeText(mCtx, s, Toast.LENGTH_SHORT).show();
    }

    public void createText(String textVal, String txtColor) {
        LinearLayout.LayoutParams txtParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView text = new TextView(mCtx);
        text.setLayoutParams(txtParams);
        text.setText(textVal);
        text.setTextColor(Color.parseColor(txtColor));
        terminal.addView(text);
        openTerminal();
    }
	
	public void showDialog (String title, String message){
		MaterialAlertDialogBuilder d = new MaterialAlertDialogBuilder(mCtx);
		d.setTitle(title);
	    d.setMessage(message);
		d.setPositiveButton("OK", (dd, w) ->{
					
		});
		d.show();
	}
}