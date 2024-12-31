package org.robok.engine.ui.screens.editor.components.drawer

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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.robok.engine.ui.screens.editor.LocalEditorFilesDrawerState
import org.robok.engine.ui.screens.editor.navigation.EditorDrawerNavHost
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorDrawer(editorViewModel: EditorViewModel, content: @Composable () -> Unit) {
  val drawerState = LocalEditorFilesDrawerState.current
  ModalNavigationDrawer(
    drawerState = drawerState,
    modifier = Modifier.fillMaxSize().imePadding(),
    gesturesEnabled = drawerState.isOpen,
    drawerContent = {
      ModalDrawerSheet(
        drawerState = drawerState,
        modifier = Modifier.fillMaxWidth(fraction = 0.85f),
        drawerContainerColor = MaterialTheme.colorScheme.background,
        drawerContentColor = contentColorFor(MaterialTheme.colorScheme.background),
      ) {
        EditorDrawerNavHost(editorViewModel = editorViewModel)
      }
    },
  ) {
    content()
  }
}
