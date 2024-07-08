package robok.dev.util;

import android.content.*;
import android.view.*;
import android.widget.*;

import robok.dev.R;

public class TextUtil {

	private Context robokContext;
	
    public TextUtil (Context context) {
        robokContext = context;
    }
    
    public String formatSpaces(String param) {
        return param.replaceAll("&{space}", " ");
    }
    
    public String formatWordWrap(String param) {
        return param.replaceAll("&{ww}", "\n");
    }
}