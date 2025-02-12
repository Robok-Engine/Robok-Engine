package org.robok.engine.ui.screens.editor.components.appbar

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
import org.robok.engine.core.components.animation.ExpandAndShrink
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorTopBar(editorViewModel: EditorViewModel, state: EditorTopBarState) {
  TopAppBar(
    title = {
      Text(
        text = state.title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    },
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
