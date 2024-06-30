package robok.trindade.terminal;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.*;
import androidx.core.text.*;

import com.google.android.material.bottomsheet.*;

import robok.trindade.R;

public class RobokTerminal extends BottomSheetDialog {

    private LinearLayout terminal;
    private View bottomSheetView;
    
    public static final String WHITE = "#FFFFFF";
    public static final String BLACK = "#000000";
    public static final String ERROR_COLOR = "#FF0000";
    public static final String WARNING_COLOR = "#FFC400";
    public static final String SUCCESS_COLOR = "#198754";
        
    public RobokTerminal(Context context) {
        super(context);

        bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_terminal, null);
        setContentView(bottomSheetView);

        setCancelable(true);
        terminal = bottomSheetView.findViewById(R.id.background_terminal);
    }

    public void addToTerminal(View view) {
        terminal.addView(view);
    }
    
    public void addLog(String TAG, String LOG) {
        String LOG_COLOR = WHITE;
        if (isDarkMode()) { 
           LOG_COLOR = BLACK;
        }
        TextView logText = new TextView(getContext());
        logText.setTextIsSelectable(true);
        logText.setText(HtmlCompat.fromHtml("<font color=\"" + LOG_COLOR + "\">"+ TAG + "</font>", HtmlCompat.FROM_HTML_MODE_LEGACY) + LOG);
        addToTerminal(logText);
    }

    public void addWarningLog(String TAG, String LOG) {
        TextView logText = new TextView(getContext());
        logText.setTextIsSelectable(true);
        logText.setText(HtmlCompat.fromHtml("<font color=\"" + ERROR_COLOR + "\">"+ TAG + "</font>", HtmlCompat.FROM_HTML_MODE_LEGACY) + LOG);
        addToTerminal(logText);
    }

    public void addErrorLog(String TAG, String LOG) {
        TextView logText = new TextView(getContext());
        logText.setTextIsSelectable(true);
        logText.setText(HtmlCompat.fromHtml("<font color=\"" + ERROR_COLOR + "\">"+ TAG + "</font>", HtmlCompat.FROM_HTML_MODE_LEGACY) + LOG);
        addToTerminal(logText);
    }
    
    private boolean isDarkMode() {
        int currentNightMode = AppCompatDelegate.getDefaultNightMode();
        switch (currentNightMode) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                 return false;
            case AppCompatDelegate.MODE_NIGHT_YES:
                 return true;
        }
        return false;
    }
}