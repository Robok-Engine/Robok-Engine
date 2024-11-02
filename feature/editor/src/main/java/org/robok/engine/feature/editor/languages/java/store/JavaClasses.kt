package org.robok.engine.feature.editor.languages.java.store

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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * JavaClasses
 * Object used to store Java classes
 * Only those necessary for development with Robok.
 * @author ThDev-Only, Aquiles Trindade (trindadedev).
 */

object JavaClasses {

    val classes: Map<String, String> by lazy {
        mapOf(
            "String", "java.lang.String", 
            "Integer", "java.lang.Integer", 
            "Float", "java.lang.Float",
            "Double", "java.lang.Double",
            "Boolean", "java.lang.Boolean", 
            "Character", "java.lang.Character", 
            "Long", "java.lang.Long", 
            "Byte", "java.lang.Byte", 
            "Short", "java.lang.Short", 
            "Math", "java.lang.Math",
            "Random", "java.util.Random", 
            "ArrayList", "java.util.ArrayList", 
            "HashMap", "java.util.HashMap", 
            "LinkedList", "java.util.LinkedList",
            "HashSet", "java.util.HashSet", 
            "TreeMap", "java.util.TreeMap", 
            "LinkedHashMap", "java.util.LinkedHashMap",
            "Arrays", "java.util.Arrays", 
            "Date", "java.util.Date", 
            "Calendar", "java.util.Calendar" 
        )
    }
}