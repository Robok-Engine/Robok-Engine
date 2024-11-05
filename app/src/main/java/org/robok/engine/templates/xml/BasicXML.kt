package org.robok.engine.templates.xml

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

import org.robok.engine.templates.CodeTemplate

open class BasicXML : CodeTemplate() {

  override var name: String = "BasicXML"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".xml"
  override var code: String = generateCode()

  private val items = mutableListOf<String>()
  
  val sb = StringBuilder()
  
  var type: String = "item"
  
  private fun generateCode(): String {
    items.forEach { value -> sb.append(" <${type}>${value}</${type}>\n") }

    return """
      <resources>
        ${sb.toString()}
      </resources>
      """
      .trimIndent()
  }

  override fun regenerate() {
    code = generateCode()
  }

  fun add(value: String) {
    items.add(value)
  }
}