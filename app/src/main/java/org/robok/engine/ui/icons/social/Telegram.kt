package org.robok.engine.ui.icons.social

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
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

val RobokIcons.Social.Telegram: ImageVector
  get() {
    if (_Telegram != null) {
      return _Telegram!!
    }
    _Telegram =
      ImageVector.Builder(
          name = "Telegram",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
          autoMirror = true,
        )
        .apply {
          path(fill = SolidColor(Color(0xFF000000))) {
            moveTo(9.78f, 18.65f)
            lineTo(10.06f, 14.42f)
            lineTo(17.74f, 7.5f)
            curveTo(18.08f, 7.19f, 17.67f, 7.04f, 17.22f, 7.31f)
            lineTo(7.74f, 13.3f)
            lineTo(3.64f, 12f)
            curveTo(2.76f, 11.75f, 2.75f, 11.14f, 3.84f, 10.7f)
            lineTo(19.81f, 4.54f)
            curveTo(20.54f, 4.21f, 21.24f, 4.72f, 20.96f, 5.84f)
            lineTo(18.24f, 18.65f)
            curveTo(18.05f, 19.56f, 17.5f, 19.78f, 16.74f, 19.36f)
            lineTo(12.6f, 16.3f)
            lineTo(10.61f, 18.23f)
            curveTo(10.38f, 18.46f, 10.19f, 18.65f, 9.78f, 18.65f)
            close()
          }
        }
        .build()

    return _Telegram!!
  }

@Suppress("ObjectPropertyName") private var _Telegram: ImageVector? = null
