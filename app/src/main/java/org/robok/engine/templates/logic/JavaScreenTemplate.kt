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
