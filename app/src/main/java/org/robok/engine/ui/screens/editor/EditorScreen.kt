package org.robok.engine.ui.screens.editor

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.More
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Redo
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.Undo
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.io.File
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.noLocalProvidedFor
import org.robok.engine.Strings
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.activities.editor.drawer.filetree.FileTreeDrawer
import org.robok.engine.ui.screens.editor.appbar.EditorTopBar
import org.robok.engine.ui.screens.editor.appbar.EditorTopBarItem
import org.robok.engine.ui.screens.editor.appbar.rememberEditorTopBarState

val LocalEditorFilesDrawerState = compositionLocalOf<DrawerState> {
  noLocalProvidedFor("LocalEditorFilesDrawerState")
}

@Composable
fun EditorScreen(pPath: String) {
  val context = LocalContext.current
  val drawerState = LocalEditorFilesDrawerState.current
  val viewModel = koinViewModel<EditorViewModel>()
  val projectManager = ProjectManager(context).apply { this.projectPath = File(pPath) }
  viewModel.setProjectManager(projectManager)

  ModalNavigationDrawer(
    drawerState = drawerState,
    modifier = Modifier
      .fillMaxSize()
      .imePadding(),
    drawerContent = {
      ModalDrawerSheet(
        drawerState = drawerState,
        modifier = Modifier.fillMaxWidth(fraction = 0.85f),
        drawerContainerColor = MaterialTheme.colorScheme.background,
        drawerContentColor = contentColorFor(MaterialTheme.colorScheme.background)
      ) {
        EditorFilesDrawer(viewModel = viewModel)
      }
    },
  ) {
    EditorScreenContent(viewModel = viewModel)
  }
}

@Composable
private fun EditorFilesDrawer(viewModel: EditorViewModel) {
  FileTreeDrawer(path = viewModel.projectManager.projectPath.absolutePath, onClick = { node -> })
}

@Composable
private fun EditorScreenContent(viewModel: EditorViewModel) {
  val coroutineScope = rememberCoroutineScope()
  val drawerState = LocalEditorFilesDrawerState.current
  Scaffold(
    topBar = {
      EditorToolbar(
        uiState = viewModel.uiState,
        onNavigationIconClick = {
          coroutineScope.launch { drawerState.open() }
        }
      )
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      if (viewModel.uiState.hasFileOpen) {
        NoOpenedFilesContent()
      } else {
        EditorTabs(viewModel = viewModel)
      }
    }
  }
}

@Composable
private fun EditorsTabs(viewModel: EditorViewModel) {
  //todo: tabs
}

@Composable
private fun NoOpenedFilesContent() {
  val drawerState = LocalDrawerState.current
  val coroutineScope = rememberCoroutineScope()
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = stringResource(id = Strings.text_no_files_open),
      style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(5.dp))
    ElevatedButton(
      onClick = { coroutineScope.launch { drawerState.open() } }
    ) {
      Text(text = stringResource(id = Strings.text_click_here_to_open_files))
    }
  }
}

@Composable
private fun EditorToolbar(uiState: EditorUIState, onNavigationIconClick: () -> Unit = {}) {
  var topBarState = rememberEditorTopBarState()
  topBarState =
    topBarState.copy(
      title = uiState.title,
      onNavigationIconClick = onNavigationIconClick,
      actions =
        listOf(
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_undo),
            icon = Icons.Rounded.Undo,
            enabled = uiState.canUndo,
            visible = uiState.hasFileOpen,
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_redo),
            icon = Icons.Rounded.Redo,
            enabled = uiState.canRedo,
            visible = uiState.hasFileOpen,
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_run),
            icon = Icons.Rounded.PlayArrow,
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_save),
            icon = Icons.Rounded.Save,
            visible = uiState.hasFileOpen,
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_more),
            icon = Icons.AutoMirrored.Rounded.More,
            visible = uiState.hasFileOpen,
          ),
        ),
    )
  EditorTopBar(state = topBarState)
}
