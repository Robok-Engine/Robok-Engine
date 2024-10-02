package org.robok.engine.feature.editor.languages.java.store;

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
          classes.put("Log", "android.util.Log"); // Log class to Store Logs in LogCat 
          return classes;
     }
}