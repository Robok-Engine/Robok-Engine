package org.gampiot.robok.feature.editor.languages.java;

import org.gampiot.robok.feature.editor.languages.java.object.ModifiersAcess;

/**
 * Class Variable Created By ThDev-only This class stores identifiers The process was modified
 * because the identifier storage system did not store the types, reasons for access, and did not
 * identify very well.
 */
public class Variable {

  private String type;
  private String name;
  private ModifiersAcess acessModifier;
  private String value;

  public Variable(ModifiersAcess acessModifier, String type, String name, String value) {
    this.acessModifier = acessModifier;
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

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ModifiersAcess getAcessModifier() {
    return this.acessModifier;
  }

  public void setAcessModifier(ModifiersAcess acessModifier) {
    this.acessModifier = acessModifier;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
