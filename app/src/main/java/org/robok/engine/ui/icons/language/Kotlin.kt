package org.robok.engine.ui.icons.language

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

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.robok.engine.ui.icons.RobokIcons

val RobokIcons.Language.Kotlin: ImageVector
  get() {
    if (_LanguageKotlin != null) {
      return _LanguageKotlin!!
    }
    _LanguageKotlin =
      ImageVector.Builder(
          name = "LanguageKotlin",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(fill = SolidColor(Color(0xFF000000))) {
            moveTo(2f, 2f)
            horizontalLineTo(22f)
            lineTo(12f, 12f)
            lineTo(22f, 22f)
            horizontalLineTo(2f)
            close()
          }
        }
        .build()
    return _LanguageKotlin!!
  }

@Suppress("ObjectPropertyName") private var _LanguageKotlin: ImageVector? = null
