package org.robok.engine.ui.icons.language

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
