package org.robok.engine.ui.screens.editor.components.appbar

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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import org.robok.engine.Strings
import org.robok.engine.ui.core.components.animation.ExpandAndShrink
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorTopBar(editorViewModel: EditorViewModel, state: EditorTopBarState) {
  TopAppBar(
    title = { Text(text = state.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
    navigationIcon = {
      IconButton(onClick = state.onNavigationIconClick) {
        Icon(
          imageVector = Icons.Rounded.Menu,
          contentDescription = stringResource(id = Strings.common_word_files),
        )
      }
    },
    actions = { EditorTopBarActions(actions = state.actions) },
  )
  DropdownMenu(
    expanded = editorViewModel.uiState.moreOptionOpen,
    onDismissRequest = { editorViewModel.setMoreOptionOpen(false) },
  ) {
    state.menuItems.forEach { menuItem ->
      ExpandAndShrink(menuItem.visible) {
        DropdownMenuItem(
          text = { Text(text = menuItem.text) },
          enabled = menuItem.enabled,
          onClick = {
            menuItem.onClick()
            editorViewModel.setMoreOptionOpen(false)
          },
        )
      }
    }
  }
}

@Composable
private fun EditorTopBarActions(actions: List<EditorTopBarAction>) {
  actions.forEach { action ->
    ExpandAndShrink(visible = action.visible, vertically = false) {
      IconButton(onClick = action.onClick, enabled = action.enabled) {
        Icon(imageVector = action.icon, contentDescription = action.name)
      }
    }
  }
}
