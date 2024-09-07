package org.gampiot.robok.feature.editor.languages.java.models;

import org.gampiot.robok.feature.editor.languages.java.object.ModifierAccess;

/*
 * Data class to store variable information.
 * because the identifier storage system did not store the types, access reasons and not.
 * @author ThDev-only
*/
public class Variable {

     private String importPackage;
     private String type;
     private String name;
     private ModifierAccess acessModifier;
     private String value;

     public Variable(ModifierAccess acessModifier, String importPackage, String type, String name, String value) {
          this.acessModifier = acessModifier;
          this.importPackage = importPackage;
          this.type = type;
          this.name = name;
          this.value = value;
     }
     
     public String getCode() {
          return this.name;
     }

     public void setCode(String name) {
          this.name = name;
     }

     public String getImportPackage() {
          return this.importPackage;
     }

     public void setImportPackage(String importPackage) {
          this.importPackage = importPackage;
     }
    
     public String getType() {
          return this.type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public ModifierAccess getAcessModifier() {
          return this.acessModifier;
     }

     public void setAcessModifier(ModifierAccess acessModifier) {
          this.acessModifier = acessModifier;
     }

     public String getValue() {
          return this.value;
     }

     public void setValue(String value) {
          this.value = value;
     }
}
