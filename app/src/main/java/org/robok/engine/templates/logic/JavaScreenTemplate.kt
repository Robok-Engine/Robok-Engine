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

open class JavaScreenTemplate : JavaClassTemplate() {

  override var name: String = "JavaScreen"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".java"

  override var code: String = generateCode()

  override fun regenerate() {
    code = generateCode()
  }

  private fun generateCode(): String {
    return """
            package $packageName;

            import androidx.annotation.NonNull;
            import org.robok.gl.GLContext;
            import org.robok.screen.GameScreen;
            import org.robok.unit.Size;
            
            public final class $name extends GameScreen {
              @Override
              protected void onStart(@NonNull final GLContext glContext) {
                // On Game start
              }

              @Override
              protected void onSizeChanged(@NonNull final GLContext glContext, @NonNull final Size newSize) {
                // On Game Surface Size Changed
              }

              @Override
              protected void onUpdate(@NonNull final GLContext glContext) {
                // On Frame Update
              }
            }
        """
      .trimIndent()
  }
}
