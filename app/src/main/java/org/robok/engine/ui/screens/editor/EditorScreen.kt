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

import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Redo
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material.icons.rounded.Undo
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.components.animation.ExpandAndShrink
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.feature.editor.RobokCodeEditor
import org.robok.engine.io.File
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.state.KeyboardState
import org.robok.engine.state.keyboardAsState
import org.robok.engine.ui.screens.editor.components.appbar.EditorTopBar
import org.robok.engine.ui.screens.editor.components.appbar.EditorTopBarAction
import org.robok.engine.ui.screens.editor.components.appbar.rememberEditorTopBarState
import org.robok.engine.ui.screens.editor.components.drawer.EditorDrawer
import org.robok.engine.ui.screens.editor.components.modal.EditorModal
import org.robok.engine.ui.screens.editor.components.tab.EditorFileTabLayout
import org.robok.engine.ui.screens.editor.event.EditorEvent
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorScreen(projectPath: String, editorNavigateActions: EditorNavigateActions) {
  val context = LocalContext.current
  val editorViewModel = koinViewModel<EditorViewModel>().apply { this.context = context }
  val projectManager = ProjectManager(context).apply { this.projectPath = File(projectPath) }
  val coroutineScope = rememberCoroutineScope()
  val toastHostState = LocalToastHostState.current

  editorViewModel.setProjectManager(projectManager)
  editorViewModel.setEditorNavigateActions(editorNavigateActions)

  BackHandler { editorViewModel.setIsBackClicked(true) }

  if (editorViewModel.uiState.isBackClicked) {
    AlertDialog(
      title = { Text(text = stringResource(Strings.warning_exit_project_title)) },
      text = { Text(text = stringResource(Strings.warning_exit_project_message)) },
      onDismissRequest = { editorViewModel.setIsBackClicked(false) },
      confirmButton = {
        Button(
          onClick = {
            editorViewModel.saveAllFiles()
            editorViewModel.uiState.editorNavigateActions!!.popBackStack()
          }
        ) {
          Text(text = stringResource(Strings.text_exit_with_save))
        }
      },
      dismissButton = {
        OutlinedButton(
          onClick = { editorViewModel.uiState.editorNavigateActions!!.popBackStack() }
        ) {
          Text(text = stringResource(Strings.text_exit_without_save))
        }
      },
    )
  }

  if (editorViewModel.uiState.isRunClicked) {
    val currentFile =
      editorViewModel.uiState.openedFiles.get(editorViewModel.uiState.selectedFileIndex)
    if (currentFile.name.substringAfterLast(".").equals("amix")) {
      compileAmixAndOpenXmlViewer(editorViewModel, currentFile)
    }
    editorViewModel.setIsRunClicked(false)
  }

  LaunchedEffect(editorViewModel.editorEvent) {
    editorViewModel.editorEvent?.let { event ->
      when (event) {
        is EditorEvent.SelectFile -> editorViewModel.setCurrentFileIndex(event.index)
        is EditorEvent.OpenFile -> {
          handleFile(editorViewModel, event.file)
          editorViewModel.clearEvent()
        }
        is EditorEvent.CloseFile -> editorViewModel.removeFile(event.index)
        is EditorEvent.CloseOthers -> editorViewModel.removeOthersFiles()
        is EditorEvent.CloseAll -> editorViewModel.removeAllFiles()
        is EditorEvent.SaveFile -> {
          editorViewModel.writeFile(
            editorViewModel.uiState.openedFiles.get(editorViewModel.uiState.selectedFileIndex)
          )
          coroutineScope.launch {
            toastHostState.showToast(
              message = context.getString(Strings.text_saved),
              icon = Icons.Rounded.Check,
            )
          }
        }
        is EditorEvent.SaveAllFiles -> {
          editorViewModel.writeAllFiles()
          coroutineScope.launch {
            toastHostState.showToast(
              message = context.getString(Strings.text_saved_all),
              icon = Icons.Rounded.Check,
            )
          }
        }
        is EditorEvent.Undo -> {
          editorViewModel.getSelectedEditor()?.let { editor ->
            editor.undo()
            editorViewModel.updateUndoRedo(editor)
          }
          editorViewModel.clearEvent()
        }
        is EditorEvent.Redo -> {
          editorViewModel.getSelectedEditor()?.let { editor ->
            editor.redo()
            editorViewModel.updateUndoRedo(editor)
          }
          editorViewModel.clearEvent()
        }
        is EditorEvent.More -> {
          editorViewModel.setMoreOptionOpen(!editorViewModel.uiState.moreOptionOpen)
          editorViewModel.clearEvent()
        }
        is EditorEvent.Run -> {
          editorViewModel.setIsRunClicked(!editorViewModel.uiState.isRunClicked)
          editorViewModel.clearEvent()
        }
      }
    }
  }

  EditorDrawer(editorViewModel = editorViewModel) {
    EditorScreenContent(modifier = Modifier.systemBarsPadding(), editorViewModel = editorViewModel)
  }
}

@Composable
private fun EditorScreenContent(modifier: Modifier = Modifier, editorViewModel: EditorViewModel) {
  val context = LocalContext.current
  val coroutineScope = rememberCoroutineScope()
  val drawerState = LocalEditorFilesDrawerState.current
  val keyboardState by keyboardAsState()

  Scaffold(
    modifier = modifier,
    topBar = {
      EditorToolbar(
        editorViewModel = editorViewModel,
        onNavigationIconClick = { coroutineScope.launch { drawerState.open() } },
      )
    },
  ) { innerPadding ->
    Column {
      Column(modifier = Modifier.weight(1f).padding(innerPadding)) {
        if (editorViewModel.uiState.hasFileOpen) {
          EditorFileTabLayout(editorViewModel = editorViewModel)
          Editor(editorViewModel = editorViewModel)
        } else {
          NoOpenedFilesContent()
        }
      }
      ExpandAndShrink(keyboardState == KeyboardState.Closed) { EditorModal() }
    }
  }
}

@Composable
private fun Editor(modifier: Modifier = Modifier, editorViewModel: EditorViewModel) {
  val uiState = editorViewModel.uiState
  val openedFiles = uiState.openedFiles
  val selectedFileIndex = uiState.selectedFileIndex
  val openedFile = openedFiles.getOrNull(selectedFileIndex)

  val selectedEditor = editorViewModel.getSelectedEditor()

  openedFile?.let { file ->
    selectedEditor?.let { editorView ->
      LaunchedEffect(editorView) { editorViewModel.updateUndoRedo(editorView) }
      key(file.path) { EditorView(modifier, editorView) }
    }
  }
}

@Composable
private fun EditorView(modifier: Modifier = Modifier, view: RobokCodeEditor) {
  AndroidView(
    factory = {
      view.apply {
        layoutParams =
          ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
          )
      }
    },
    modifier = modifier,
  )
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
private fun EditorToolbar(
  editorViewModel: EditorViewModel,
  onNavigationIconClick: () -> Unit = {},
) {
  var topBarState = rememberEditorTopBarState()
  val uiState = editorViewModel.uiState
  val coroutineScope = rememberCoroutineScope()
  val toastHostState = LocalToastHostState.current
  topBarState =
    topBarState.copy(
      title = uiState.title,
      onNavigationIconClick = onNavigationIconClick,
      actions =
        listOf(
          EditorTopBarAction(
            name = stringResource(id = Strings.common_word_undo),
            icon = Icons.Rounded.Undo,
            enabled = uiState.canUndo,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.undo() },
          ),
          EditorTopBarAction(
            name = stringResource(id = Strings.common_word_redo),
            icon = Icons.Rounded.Redo,
            enabled = uiState.canRedo,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.redo() },
          ),
          EditorTopBarAction(
            name = stringResource(id = Strings.common_word_run),
            icon = Icons.Rounded.PlayArrow,
            onClick = { editorViewModel.run() },
          ),
          EditorTopBarAction(
            name = stringResource(id = Strings.common_word_save),
            icon = Icons.Rounded.Save,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.saveFile() },
          ),
          EditorTopBarAction(
            name = stringResource(id = Strings.common_word_more),
            icon = Icons.Rounded.MoreVert,
            visible = uiState.hasFileOpen,
            onClick = { editorViewModel.more() },
          ),
        ),
    )
  EditorTopBar(state = topBarState, editorViewModel = editorViewModel)
}

private fun handleFile(editorViewModel: EditorViewModel, file: File) {
  val name = file.name
  when (name) {
    "config.json" -> {
      editorViewModel.uiState.editorNavigateActions!!.onNavigateToProjectSettings(
        editorViewModel.projectManager.projectPath.path
      )
    }
    else -> handleFileExtension(editorViewModel, file)
  }
}

private fun handleFileExtension(editorViewModel: EditorViewModel, file: File) {
  editorViewModel.addFile(file)
}

private fun compileAmixAndOpenXmlViewer(editorViewModel: EditorViewModel, file: File) {
  val amixCode = FileUtil.readFile(file.absolutePath)
  var xmlCode = "Failed to generate source code."
  editorViewModel.projectManager.generateXmlFromAmix(
    amixCode = amixCode,
    onGenerateCode = { generatedCode, config ->
      xmlCode = generatedCode
      editorViewModel.uiState.editorNavigateActions!!.onNavigateToXMLViewer(xmlCode)
    }
  )
}

@Immutable
data class EditorNavigateActions(
  val popBackStack: () -> Unit,
  val onNavigateToXMLViewer: (String) -> Unit,
  val onNavigateToProjectSettings: (String) -> Unit,
)
