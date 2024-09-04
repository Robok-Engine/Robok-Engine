package org.gampiot.robok.feature.editor.languages.java.models;

import static robok.diagnostic.logic.Java8Parser.MethodModifierContext;

import org.gampiot.robok.feature.editor.languages.java.object.ModifierAccess;

import java.util.List;

/*
 * Data class to store method information.
 * because the identifier storage system did not store the types, access reasons and not.
 * @author ThDev-only
*/
public class Method {

     private List<MethodModifierContext> modifiers;
     private String returnType;
     private String name;
     private List<String> parameters;

     public Method(List<MethodModifierContext> modifiers, String returnType, String name, List<String> parameters) {
          this.modifiers = modifiers;
          this.returnType = returnType;
          this.name = name;
          this.parameters = parameters;
     }

     public List<MethodModifierContext> getModifiers() {
          return this.modifiers;
     }

     public void setModifiers(List<MethodModifierContext> modifiers) {
          this.modifiers = modifiers;
     }

     public String getReturnType() {
          return this.returnType;
     }

    public void setReturnType(String returnType) {
         this.returnType = returnType;
    }

    public String getName() {
         return this.name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public List<String> getParameters() {
         return this.parameters;
    }

    public void setParameters(List<String> parameters) {
         this.parameters = parameters;
    }
}
