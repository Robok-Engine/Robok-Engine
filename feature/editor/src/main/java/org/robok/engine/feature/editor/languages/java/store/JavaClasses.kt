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

    @JvmStatic
    val classes: HashMap<String, String> by lazy {
        hashMapOf(
            "String" to "java.lang.String", 
            "Integer" to "java.lang.Integer", 
            "Float" to "java.lang.Float",
            "Double" to "java.lang.Double",
            "Boolean" to "java.lang.Boolean", 
            "Character" to "java.lang.Character", 
            "Long" to "java.lang.Long", 
            "Byte" to "java.lang.Byte", 
            "Short" to "java.lang.Short", 
            "Math" to "java.lang.Math",
            "Random" to "java.util.Random", 
            "ArrayList" to "java.util.ArrayList", 
            "HashMap" to "java.util.HashMap", 
            "LinkedList" to "java.util.LinkedList",
            "HashSet" to "java.util.HashSet", 
            "TreeMap" to "java.util.TreeMap", 
            "LinkedHashMap" to "java.util.LinkedHashMap",
            "Arrays" to "java.util.Arrays", 
            "Date" to "java.util.Date", 
            "Calendar" to "java.util.Calendar"
        )
    }
}