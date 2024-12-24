package org.robok.engine.ui.screens.editor.components.tab

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
