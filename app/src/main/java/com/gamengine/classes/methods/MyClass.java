package com.gamengine.classes.methods;

import com.gamengine.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; 
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.gamengine.MainActivity;
import java.lang.ref.WeakReference;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MyClass {
    private Context mCtx;
    private WeakReference<MainActivity> weak;
    private LinearLayout terminal;
    private BottomSheetDialog terminalSheet;
    
    public MyClass(Context context, MainActivity mainActivity) {
        this.mCtx = context;
        this.weak = new WeakReference<>(mainActivity);
        View bottomSheetView = LayoutInflater.from(mCtx).inflate(R.layout.terminal, null);
        terminalSheet = new BottomSheetDialog(mCtx);
        terminalSheet.setContentView(bottomSheetView);
        //terminalSheet.getWindow().findViewById(R.id.).setBackgroundResource(android.R.color.transparent);
        terminalSheet.setCancelable(true);
        terminal = bottomSheetView.findViewById(R.id.terminal);
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
}