package org.robok.engine.ui.screens.editor.components.modal

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
          Modifier.fillMaxWidth().height(55.dp).clickable {
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
  val maxHeight = rememberEditorModalMaxHeight()
  return remember { EditorModalState(maxHeight = maxHeight - EditorModalDefaults.minHeight) }
}

@Composable
fun rememberEditorModalMaxHeight(): Float {
  val configuration = LocalConfiguration.current
  return remember { configuration.screenHeightDp.toFloat() }
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
    animatableHeight.animateTo(
      maxHeight,
      animationSpec = tween(durationMillis = EditorModalDefaults.animationDuration),
    )
    calculateValue()
  }

  suspend fun close() {
    animatableHeight.animateTo(
      initialHeight,
      animationSpec = tween(durationMillis = EditorModalDefaults.animationDuration),
    )
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
  const val animationDuration = 500
}
