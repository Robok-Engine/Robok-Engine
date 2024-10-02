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

import static org.robok.antlr.logic.Java8Parser.MethodModifierContext;

import org.robok.engine.feature.editor.languages.java.object.ModifierAccess;

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
