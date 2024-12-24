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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.More
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Redo
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.Undo
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.io.File
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.screens.editor.appbar.EditorTopBar
import org.robok.engine.ui.screens.editor.appbar.EditorTopBarItem
import org.robok.engine.ui.screens.editor.appbar.rememberEditorTopBarState
import org.robok.engine.ui.screens.editor.drawer.EditorDrawer
import org.robok.engine.ui.screens.editor.event.EditorEvent
import org.robok.engine.ui.screens.editor.state.EditorUIState
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorScreen(pPath: String) {
  val context = LocalContext.current
  val editorViewModel = koinViewModel<EditorViewModel>()
  val projectManager = ProjectManager(context).apply { this.projectPath = File(pPath) }
  editorViewModel.setProjectManager(projectManager)

  EditorDrawer(editorViewModel = editorViewModel) {
    EditorScreenContent(editorViewModel = editorViewModel)
  }
}

@Composable
private fun EditorScreenContent(editorViewModel: EditorViewModel) {
  val coroutineScope = rememberCoroutineScope()
  val drawerState = LocalEditorFilesDrawerState.current
  Scaffold(
    topBar = {
      EditorToolbar(
        editorViewModel = editorViewModel,
        onNavigationIconClick = { coroutineScope.launch { drawerState.open() } },
      )
    }
  ) { innerPadding ->
    LaunchedEffect(editorViewModel.editorEvent) {
      when (editorViewModel.editorEvent) {
        is EditorEvent.OpenFile -> TODO("OPEN FILE NOT IMPLEMENTED")
        is EditorEvent.CloseFile -> TODO("CLOSE FILE NOT IMPLEMENTED")
        is EditorEvent.CloseOthers -> TODO("CLOSE OTHERS NOT IMPLEMENTED")
        is EditorEvent.CloseAll -> TODO("CLOSE ALL NOT IMPLEMENTED")
        is EditorEvent.SaveFile -> TODO("SAVE NOT IMPLEMENTED")
        is EditorEvent.SaveAllFiles -> TODO("SAVE ALL NOT IMPLEMENTED")
        is EditorEvent.Undo -> TODO("UNDO NOT IMPLEMENTED")
        is EditorEvent.Redo -> TODO("REDO NOT IMPLEMENTED")
        is EditorEvent.More -> TODO("MORE NOT IMPLEMENTED")
      }
    }
    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
      if (editorViewModel.uiState.hasFileOpen) {
        EditorTabs(editorViewModel = editorViewModel)
      } else {
        NoOpenedFilesContent()
      }
    }
  }
}

@Composable
private fun EditorTabs(editorViewModel: EditorViewModel) {
  // todo: tabs
}

@Composable
private fun NoOpenedFilesContent() {
  val drawerState = LocalEditorFilesDrawerState.current
  val coroutineScope = rememberCoroutineScope()
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Text(
      text = stringResource(id = Strings.text_no_files_open),
      style = MaterialTheme.typography.titleLarge,
    )
    Spacer(modifier = Modifier.height(5.dp))
    ElevatedButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
      Text(text = stringResource(id = Strings.text_click_here_to_open_files))
    }
  }
}

@Composable
private fun EditorToolbar(editorViewModel: EditorViewModel, onNavigationIconClick: () -> Unit = {}) {
  var topBarState = rememberEditorTopBarState()
  val uiState = editorViewModel.uiState
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
            onClick = { editorViewModel.undo() }
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_redo),
            icon = Icons.Rounded.Redo,
            enabled = uiState.canRedo,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.redo() }
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_run),
            icon = Icons.Rounded.PlayArrow,
            onClick = { editorViewModel.run() }
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_save),
            icon = Icons.Rounded.Save,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.saveFile() }
          ),
          EditorTopBarItem(
            name = stringResource(id = Strings.common_word_more),
            icon = Icons.AutoMirrored.Rounded.More,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.more() }
          ),
        ),
    )
  EditorTopBar(state = topBarState)
}
