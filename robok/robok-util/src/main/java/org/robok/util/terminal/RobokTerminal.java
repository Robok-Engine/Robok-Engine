package org.robok.util.terminal;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.view.View;
import android.widget.LinearLayout;

import java.util.List;
import java.util.ArrayList;

public class RobokTerminal {

    private LinearLayout terminal;
    private View bottomSheetView;
    public static List<String> logs;
    
    public static final String WHITE = "#FFFFFF";
    public static final String BLACK = "#000000";
    
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
        String tag_temp = WARNING_PATTERN + TAG;
        tag_temp = tag_temp.replace("[NUM]","" + (logs.size() + 1));
		
        addLog(tag_temp + " : " + LOG);
    }

    public void addErrorLog(String TAG, String LOG) {
        String tag_temp = ERROR_PATTERN + TAG;
        tag_temp = tag_temp.replace("[NUM]","" + (logs.size() + 1));
		
        addLog(tag_temp + " : " + LOG);
    }
}