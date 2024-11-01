package org.robok.engine.feature.editor.languages.java.models;

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

import org.robok.engine.feature.editor.languages.java.object.ModifierAccess;

/*
 * Data class to store variable information.
 * because the identifier storage system did not store the types, access reasons and not.
 * @author ThDev-only
 */
public class Variable {

  private String createdIn;
  private String importPackage;
  private String type;
  private String name;
  private ModifierAccess acessModifier;
  private String value;

  public Variable(
      String createdIn,
      ModifierAccess acessModifier,
      String importPackage,
      String type,
      String name,
      String value) {
    this.createdIn = createdIn;
    this.acessModifier = acessModifier;
    this.importPackage = importPackage;
    this.type = type;
    this.name = name;
    this.value = value;
  }

  public String getCreatedIn() {
    return this.createdIn;
  }

  public void setCreatedIn(String name) {
    this.name = name;
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
