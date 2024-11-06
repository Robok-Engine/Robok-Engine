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

  private var items: MutableList<Pair<String, String>>? = null
  var type: String = "item"
  var key: String = "name"
  val sb = StringBuilder()

  override var name: String = "BasicXML"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".xml"
  override var code: String = generateCode()

  private fun generateCode(): String {
    sb.clear()
    items?.forEach { (keya, value) -> 
      sb.append(" <$type $key=\"$keya\">$value</$type>\n") 
    }

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

  fun add(keyValue: String, value: String) {
    if (items == null) {
      items = mutableListOf()
    }
    items?.add(Pair(keyValue, value))
  }
}