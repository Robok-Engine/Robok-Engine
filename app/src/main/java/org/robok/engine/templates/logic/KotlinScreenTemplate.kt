package org.robok.engine.templates.logic

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

open class KotlinScreenTemplate : JavaClassTemplate() {

  override var name: String = "KotlinScreen"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".kt"

  override var code: String = generateCode()

  override fun regenerate() {
    code = generateCode()
  }

  private fun generateCode(): String {
    return """
            package $packageName

            import org.robok.gl.GLContext
            import org.robok.screen.GameScreen
            import org.robok.unit.Size
            
            class $name: GameScreen() {
              @Override
              override fun GLContext.onStart() {
                // On Game start
              }

              @Override
              override fun GLContext.onSizeChanged(newSize: Size) {
                // On Game Surface Size Changed
              }

              @Override
              override fun GLContext.onUpdate() {
                // On Frame Update
              }
            }
        """
      .trimIndent()
  }
}
