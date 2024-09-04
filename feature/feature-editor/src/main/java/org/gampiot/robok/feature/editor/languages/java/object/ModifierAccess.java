package org.gampiot.robok.feature.editor.languages.java.object;

public enum ModifierAccess {
     DEFAULT("default"),
     PUBLIC("public"),
     PROTECTED("protected"),
     PRIVATE("private");
    
     private String s;
     
     ModifierAccess(String s){
          this.s = s;
     }
    
     public String toString(){
        return this.s;
     }
}