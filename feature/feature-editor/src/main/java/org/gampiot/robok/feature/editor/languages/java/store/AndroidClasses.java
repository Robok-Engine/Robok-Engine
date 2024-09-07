package org.gampiot.robok.feature.editor.languages.java.store;

/*
* AndroidClasses
* Class used to store android classes
* Only the necessary Android classes.
* @author Aquiles Trindade 
*/

import java.util.HashMap;

public final class AndroidClasses {
        
     public static final HashMap<String, String> getClasses(){
          HashMap<String, String> classes = new HashMap<>();
          classes.put("Context", "android.content.Context"); // Context class for Android application context access
          classes.put("View", "android.view.View"); // View class for Android UI elements
          classes.put("Log", "android.util.Log");
          return classes;
     }
}