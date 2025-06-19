package org.robok.engine.templates.xml

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
    items?.forEach { (keya, value) -> sb.append(" <$type $key=\"$keya\">$value</$type>\n") }

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
