package org.robok.engine.templates.logic

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
