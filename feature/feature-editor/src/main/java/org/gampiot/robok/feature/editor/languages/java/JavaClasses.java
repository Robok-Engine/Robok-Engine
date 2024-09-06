/* 
 * Created By ThDev-Only
 * JavaClasses
 * This class was created to store the Java classes
 * that Robok needs, since most of them are unnecessary. 
 */

package org.gampiot.robok.feature.editor.languages.java;

public class JavaClasses {
    
    public HashMap<String, String> classes;

    public JavaClasses() {
        classes = new HashMap<>();
        
        // String class for handling strings
        classes.put("String", "java.lang.String");
        
        // Integer class for handling integers
        classes.put("Integer", "java.lang.Integer");
        
        // Float class for handling floating point numbers
        classes.put("Float", "java.lang.Float");
        
        // Double class for handling double precision floating point numbers
        classes.put("Double", "java.lang.Double");
        
        // Boolean class for handling boolean values
        classes.put("Boolean", "java.lang.Boolean");
        
        // Character class for handling single characters
        classes.put("Character", "java.lang.Character");
        
        // Long class for handling long integers
        classes.put("Long", "java.lang.Long");
        
        // Byte class for handling byte values
        classes.put("Byte", "java.lang.Byte");
        
        // Short class for handling short integers
        classes.put("Short", "java.lang.Short");

        // Math class for mathematical operations
        classes.put("Math", "java.lang.Math");
        
        // Random class for generating random numbers
        classes.put("Random", "java.util.Random");
        
        // ArrayList class for dynamic arrays
        classes.put("ArrayList", "java.util.ArrayList");
        
        // HashMap class for key-value pairs mapping
        classes.put("HashMap", "java.util.HashMap");
        
        // LinkedList class for linked list implementation
        classes.put("LinkedList", "java.util.LinkedList");
        
        // HashSet class for a set of unique elements
        classes.put("HashSet", "java.util.HashSet");
        
        // TreeMap class for sorted map key-value pairs
        classes.put("TreeMap", "java.util.TreeMap");
        
        // LinkedHashMap class for maintaining insertion order in a map
        classes.put("LinkedHashMap", "java.util.LinkedHashMap");
        
        // Arrays class for utility methods for working with arrays
        classes.put("Arrays", "java.util.Arrays");
        
        // Date class for working with dates (legacy class, use java.time package for new code)
        classes.put("Date", "java.util.Date");
        
        // Calendar class for working with date and time
        classes.put("Calendar", "java.util.Calendar");
        
        // Toast class for displaying temporary messages in Android
        classes.put("Toast", "android.widget.Toast");
        
        // Bundle class for passing data between Android components
        classes.put("Bundle", "android.os.Bundle");
        
        // Context class for Android application context access
        classes.put("Context", "android.content.Context");
        
        // View class for Android UI elements
        classes.put("View", "android.view.View");
      
    }
    
    
    
    public HashMap<String, String> getJavaClasses(){
        
        return classes;
                
    }
}