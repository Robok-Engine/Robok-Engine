package org.robok.lang.variable

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

/*
  This class is responsible for obtaining:
    model: Model of the variable (Class or primitive)
    type: Type of the variable.
    name: Name of the variable.
    value: Value of the variable.
 */

class VariableObject(
    var model: String = "",
    var modifyAccess: String = "default",
    var type: String = "",
    var name: String = "",
    var value: String = ""
) {

    var isStatic: Boolean = false
    var isNative: Boolean = false
    var isFinal: Boolean = false
    var isSynchronized: Boolean = false
    var isVolatile: Boolean = false
    var isTransient: Boolean = false
    var isAbstract: Boolean = false
    var isStrictfp: Boolean = false

    // Secondary constructor
    constructor(model: String, type: String, name: String, value: String) : this(model, "default", type, name, value)

    // Set modifiers at once
    fun setModifiers(
        isStatic: Boolean,
        isFinal: Boolean,
        isNative: Boolean,
        isSynchronized: Boolean,
        isVolatile: Boolean,
        isTransient: Boolean,
        isAbstract: Boolean,
        isStrictfp: Boolean
    ) {
        this.isStatic = isStatic
        this.isFinal = isFinal
        this.isNative = isNative
        this.isSynchronized = isSynchronized
        this.isVolatile = isVolatile
        this.isTransient = isTransient
        this.isAbstract = isAbstract
        this.isStrictfp = isStrictfp
    }

    // Set variable type by value (used if type is var)
    companion object {
        fun setVariableTypeFromValue(value: String): String {
            // Checks if it is an integer number
            try {
                value.toInt()
                return "int"
            } catch (e: NumberFormatException) {
                // Not an integer number
            }

            // Checks if it is a long number
            try {
                value.toLong()
                return "long"
            } catch (e: NumberFormatException) {
                // Not a long number
            }

            // Checks if it is a float number (must end with 'f' or 'F')
            if (value.endsWith("f", true)) {
                try {
                    value.toFloat()
                    return "float"
                } catch (e: NumberFormatException) {
                    // Not a float number
                }
            }

            // Checks if it is a double number
            try {
                value.toDouble()
                return "double"
            } catch (e: NumberFormatException) {
                // Not a double number
            }

            // Checks if it is a boolean
            val lowerCaseValue = value.lowercase()
            if (lowerCaseValue == "true" || lowerCaseValue == "false") {
                return "boolean"
            }

            // Future fix for handling char detection
            // For now, consider it as a String
            return "String"
        }
    }
}