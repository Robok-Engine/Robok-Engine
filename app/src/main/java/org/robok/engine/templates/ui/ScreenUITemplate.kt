package org.robok.engine.templates.ui

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

open class ScreenUITemplate : CodeTemplate() {

  override var name: String = "ScreenUII"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".gui"

  override var code: String = generateCode()

  override fun regenerate() {
    code = generateCode()
  }

  private fun generateCode(): String {
    return """
            config(
              orientation = "horizontal"
            )
            Column(
              width = "match_parent",
              height = "match_parent"
            ) {
              Button(
                id = "shoot_button",
                text = "Shoot",
                width = "wrap_content",
                height = "wrap_content"
              )
            }
        """
      .trimIndent()
  }
}
