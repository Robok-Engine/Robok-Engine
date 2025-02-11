package org.robok.engine.ui.screens.editor.components.modal

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

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings

@Composable
fun EditorModal(initialHeight: Float = 50f, maxHeight: Float = 800f) {
  var modalHeight by remember { mutableStateOf(initialHeight) }
  val animatedHeight by
    animateFloatAsState(targetValue = modalHeight, label = "Editor Modal Height")
  Box {
    Column(
      modifier =
        Modifier.align(Alignment.BottomCenter)
          .fillMaxWidth()
          .height(animatedHeight.dp)
          .pointerInput(Unit) {
            detectVerticalDragGestures { _, dragAmount ->
              modalHeight = (modalHeight - dragAmount).coerceIn(initialHeight, maxHeight)
            }
          }
    ) {
      HorizontalDivider()
      Box(modifier = Modifier.fillMaxWidth().height(50.dp), contentAlignment = Alignment.Center) {
        Text(
          text = stringResource(Strings.title_project_initialized),
          fontSize = 16.sp
        )
        Text(
          text = stringResource(Strings.text_swipe_up_down_build_info),
          fontSize = 12.sp
        )
      }
      HorizontalDivider()
      Column {
        Text(text = "Here will be displayed the Build logs")
      }
    }
  }
}
