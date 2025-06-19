package org.robok.engine.ui.core.components.dialog.sheet

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
 * Used for generic content for bottom sheet.
 * @author Aquiles Trindade (trindadedev)
 */

@Composable
fun BottomSheetContent(
  buttons: @Composable RowScope.() -> Unit,
  modifier: Modifier = Modifier,
  title: (@Composable () -> Unit)? = null,
  text: @Composable (() -> Unit)? = null,
  content: @Composable (() -> Unit)? = null,
) {
  val contentPadding = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)

  Column(modifier = modifier.fillMaxWidth().safeDrawingPadding()) {
    title?.let {
      Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        val textStyle = MaterialTheme.typography.titleLarge
        ProvideTextStyle(textStyle, title)
      }
    }
    text?.let {
      Box(modifier = contentPadding) {
        val textStyle = MaterialTheme.typography.bodyMedium
        ProvideTextStyle(textStyle, text)
      }
    }
    content?.let {
      Box(modifier = Modifier.padding(top = if (title != null || text != null) 16.dp else 0.dp)) {
        content()
      }
    }
    Row(
      horizontalArrangement = Arrangement.End,
      modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
      buttons()
    }
  }
}
