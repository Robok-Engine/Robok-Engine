package com.gam.engine;

import android.view.View;
import android.widget.LinearLayout;
import java.util.List;
import com.gam.engine.R;
import java.util.ArrayList;

public class RobokTerminal {

    private LinearLayout terminal;
    private View bottomSheetView;
    public static List<String> logs;
    
    public static final String WHITE = "#FFFFFF";
    public static final String BLACK = "#000000";
    public static final String ERROR_COLOR = "#FF0000";
    public static final String WARNING_COLOR = "#FFC400";
    public static final String SUCCESS_COLOR = "#198754";
    
    public static final String ERROR_PATTERN = "----------[NUM]. ERROR)";
    public static final String WARNING_PATTERN = "----------[NUM]. WARNING)";
    
	public RobokTerminal(){
		logs = new ArrayList<>();
		
	}
	
    public void addLog(String log) {
        logs.add("\n" + log);
    }
    
    public String getLogs () {
        return logs.toString();
    }
    
    public void addLog(String TAG, String LOG) {
		String tag = TAG.replace("[NUM]","" + (logs.size() + 1));
		
        addLog(tag + " : " + LOG);
    }

    public void addWarningLog(String TAG, String LOG) {
        String tag_temp = ERROR_PATTERN + TAG;
        tag_temp = tag_temp.replace("[NUM]","" + (logs.size() + 1));
		
        addLog(tag_temp + " : " + LOG);
    }

    public void addErrorLog(String TAG, String LOG, int num) {
        String tag_temp = ERROR_PATTERN + TAG;
        tag_temp = tag_temp.replace("[NUM]","" + (logs.size() + 1));
		
        addLog(tag_temp + " : " + LOG);
    }
}