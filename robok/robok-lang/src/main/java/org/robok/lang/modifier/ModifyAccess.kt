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

class ModifyAccess {

    private val modifyAccess = arrayOf(
        "public",
        "protected",
        "private",
        "default"
    )

    fun codeIsModifyAccess(code: String): ModifyAccessObject {
        var isModifyAccess = false
        var modifyAccessType = ""

        for (modifier in modifyAccess) {
            if (code == modifier) {
                isModifyAccess = true
                modifyAccessType = code
                break
            }
        }
        return ModifyAccessObject(isModifyAccess, modifyAccessType)
    }

    data class ModifyAccessObject(
        val isModifyAccess: Boolean, 
        val modifyAccessType: String
    )
}