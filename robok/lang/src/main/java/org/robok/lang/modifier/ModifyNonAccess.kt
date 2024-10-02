package org.robok.lang.modifier

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

import org.robok.lang.variable.VariableObject

class ModifyNonAccess {

    private val modifyNonAccess = arrayOf(
        "static", "final", "native", "volatile", "synchronized", "transient", "abstract", "strictfp"
    )

    fun verifyModifiersNonAccessFromVariable(variableObject: VariableObject, modifiers: String) {
        val isStatic = containsModifier(modifiers, "static")
        val isFinal = containsModifier(modifiers, "final")
        val isNative = containsModifier(modifiers, "native")
        val isSynchronized = containsModifier(modifiers, "synchronized")
        val isVolatile = containsModifier(modifiers, "volatile")
        val isTransient = containsModifier(modifiers, "transient")
        val isAbstract = containsModifier(modifiers, "abstract")
        val isStrictfp = containsModifier(modifiers, "strictfp")

        variableObject.setModifiers(isStatic, isFinal, isNative, isSynchronized, isVolatile, isTransient, isAbstract, isStrictfp)
    }

    private fun containsModifier(modifiers: String, modifier: String): Boolean {
        return modifiers.contains(modifier)
    }
}