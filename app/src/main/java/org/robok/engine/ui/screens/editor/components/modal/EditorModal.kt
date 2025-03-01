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

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.robok.engine.Strings

@Composable
fun EditorModal(
  editorModalState: EditorModalState = rememberEditorModalState(),
  content: @Composable ColumnScope.() -> Unit,
) {
  val coroutineScope = rememberCoroutineScope()
  Box {
    Column(
      modifier =
        Modifier.align(Alignment.BottomCenter)
          .fillMaxWidth()
          .height(editorModalState.currentHeight.dp)
          .pointerInput(Unit) {
            detectVerticalDragGestures { _, dragAmount ->
              coroutineScope.launch { editorModalState.updateHeight(-dragAmount) }
            }
          }
    ) {
      HorizontalDivider()
      Column(
        modifier =
          Modifier.fillMaxWidth().height(50.dp).clickable {
            coroutineScope.launch { editorModalState.toggle() }
          },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
      ) {
        Text(text = stringResource(Strings.title_project_initialized), fontSize = 16.sp)
        Text(text = stringResource(Strings.text_swipe_up_down_build_info), fontSize = 12.sp)
      }
      HorizontalDivider()
      Column(content = content)
    }
  }
}

@Composable
fun rememberEditorModalState(): EditorModalState {
  val maxHeight by rememberEditorModalMaxHeight()
  return remember { EditorModalState(maxHeight = maxHeight) }
}

@Composable
fun rememberEditorModalMaxHeight(): Float {
  val configuration = LocalConfiguration.current
  return configuration.screenHeightDp.toFloat()
}

enum class EditorModalValue {
  Closed,
  Expanded,
}

@Stable
class EditorModalState(
  val initialHeight: Float = EditorModalDefaults.minHeight,
  val maxHeight: Float = EditorModalDefaults.maxHeight,
  initialValue: EditorModalValue = EditorModalValue.Closed,
) {

  private val animatableHeight = Animatable(initialValue = initialHeight)
  val currentHeight: Float
    get() = animatableHeight.value

  var currentValue by mutableStateOf(initialValue)
    private set

  val isClosed: Boolean
    get() = currentValue == EditorModalValue.Closed

  val isExpanded: Boolean
    get() = currentValue == EditorModalValue.Expanded

  private fun calculateValue() {
    currentValue =
      if (currentHeight > initialHeight) EditorModalValue.Expanded else EditorModalValue.Closed
  }

  suspend fun open() {
    animatableHeight.animateTo(maxHeight, animationSpec = tween(durationMillis = 500))
    calculateValue()
  }

  suspend fun close() {
    animatableHeight.animateTo(initialHeight, animationSpec = tween(durationMillis = 500))
    calculateValue()
  }

  suspend fun toggle() {
    if (isExpanded) close() else open()
  }

  suspend fun updateHeight(dragAmount: Float) {
    val newHeight = (currentHeight + dragAmount).coerceIn(initialHeight, maxHeight)
    animatableHeight.snapTo(newHeight)
    calculateValue()
  }
}

@Immutable
object EditorModalDefaults {
  const val minHeight = 55f
  const val maxHeight = 775f
}
