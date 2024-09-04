package org.gampiot.robok.feature.editor.languages.java;

import robok.diagnostic.logic.Java8Parser;

import org.gampiot.robok.feature.editor.languages.java.object.ModifiersAcess;

import java.util.List;

/**
 * Class Variable Created By ThDev-only This class stores identifiers The process was modified
 * because the identifier storage system did not store the types, reasons for access, and did not
 * identify very well.
 */
public class Method {

  private List<Java8Parser.MethodModifierContext> modifiers;
  private String returnType;
  private String name;
  private List<String> parameters;

  public Method(
      List<Java8Parser.MethodModifierContext> modifiers, String returnType, String name, List<String> parameters) {
    this.modifiers = modifiers;
    this.returnType = returnType;
    this.name = name;
    this.parameters = parameters;
  }

  public List<Java8Parser.MethodModifierContext> getModifiers() {
    return this.modifiers;
  }

  public void setModifiers(List<Java8Parser.MethodModifierContext> modifiers) {
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
