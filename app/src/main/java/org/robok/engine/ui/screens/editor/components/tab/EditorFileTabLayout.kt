package org.robok.engine.ui.screens.editor.components.tab

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

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorFileTabLayout(modifier: Modifier = Modifier, editorViewModel: EditorViewModel) {
  val uiState = editorViewModel.uiState

  val selectedFileIndex = uiState.selectedFileIndex.coerceAtLeast(0)
  val openedFiles = uiState.openedFiles

  // Return early if no files are open
  if (openedFiles.isEmpty()) return

  var showTabMenu by remember { mutableStateOf(false) }
  var tabPosition by remember { mutableStateOf<TabPosition?>(null) }

  @Composable
  fun tabOffset(position: TabPosition?): State<Dp> {
    return animateDpAsState(targetValue = position?.left ?: 0.dp, label = "tabOffset")
  }

  ScrollableTabRow(
    selectedTabIndex = selectedFileIndex.coerceIn(0, openedFiles.size - 1),
    modifier = modifier.fillMaxWidth(),
    edgePadding = 0.dp,
    indicator = { tabPositions ->
      tabPosition = tabPositions.getOrNull(selectedFileIndex)

      if (tabPosition != null) {
        TabRowDefaults.SecondaryIndicator(Modifier.tabIndicatorOffset(tabPosition!!))
      }
    },
    divider = {
      val tabOffset by tabOffset(tabPosition)

      DropdownMenu(
        expanded = showTabMenu,
        offset =
          DpOffset(x = if (selectedFileIndex == 0) tabOffset + 2.dp else tabOffset, y = 2.dp),
        shape = MaterialTheme.shapes.medium,
        onDismissRequest = { showTabMenu = false },
      ) {
        EditorFileTabActions(editorViewModel = editorViewModel, index = selectedFileIndex) {
          showTabMenu = false
        }
      }
    },
  ) {
    openedFiles.forEachIndexed { index, openedFile ->
      Tab(
        selected = index == selectedFileIndex,
        onClick = {
          if (index == selectedFileIndex) {
            showTabMenu = true
          } else {
            editorViewModel.selectFile(index)
          }
        },
        text = {
          Text(text = if (openedFile.isModified()) "*${openedFile.name}" else openedFile.name)
        },
      )
    }
  }

  HorizontalDivider(thickness = 1.dp)
}
