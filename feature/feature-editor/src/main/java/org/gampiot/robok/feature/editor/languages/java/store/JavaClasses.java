package org.gampiot.robok.feature.editor.languages.java.store;

/*
* JavaClasses
* Class used to store java classes
* Only those necessary for development with Robok.
* @author ThDev-Only
*/

import java.util.HashMap;

public final class JavaClasses {
        
     public static final HashMap<String, String> getClasses(){
          var classes = new HashMap<>();
          classes.put("String", "java.lang.String"); // String class for handling strings
          classes.put("Integer", "java.lang.Integer"); // Integer class for handling integers
          classes.put("Float", "java.lang.Float"); // Float class for handling floating point numbers
          classes.put("Double", "java.lang.Double"); // Double class for handling double precision floating point numbers
          classes.put("Boolean", "java.lang.Boolean"); // Boolean class for handling boolean values
          classes.put("Character", "java.lang.Character"); // Character class for handling single characters
          classes.put("Long", "java.lang.Long"); // Long class for handling long integers
          classes.put("Byte", "java.lang.Byte"); // Byte class for handling byte values
          classes.put("Short", "java.lang.Short"); // Short class for handling short integers
          classes.put("Math", "java.lang.Math"); // Math class for mathematical operations
          classes.put("Random", "java.util.Random"); // Random class for generating random numbers
          classes.put("ArrayList", "java.util.ArrayList"); // ArrayList class for dynamic arrays
          classes.put("HashMap", "java.util.HashMap"); // HashMap class for key-value pairs mapping
          classes.put("LinkedList", "java.util.LinkedList"); // LinkedList class for linked list implementation
          classes.put("HashSet", "java.util.HashSet"); // HashSet class for a set of unique elements
          classes.put("TreeMap", "java.util.TreeMap"); // TreeMap class for sorted map key-value pairs
          classes.put("LinkedHashMap", "java.util.LinkedHashMap"); // LinkedHashMap class for maintaining insertion order in a map
          classes.put("Arrays", "java.util.Arrays"); // Arrays class for utility methods for working with arrays
          classes.put("Date", "java.util.Date"); // Date class for working with dates (legacy class, use java.time package for new code)
          classes.put("Calendar", "java.util.Calendar"); // Calendar class for working with date and time
          classes.put("Toast", "android.widget.Toast"); // Toast class for displaying temporary messages in Android
          classes.put("Bundle", "android.os.Bundle"); // Bundle class for passing data between Android components
          classes.put("Context", "android.content.Context"); // Context class for Android application context access
          classes.put("View", "android.view.View"); // View class for Android UI elements
          return classes;
     }
}