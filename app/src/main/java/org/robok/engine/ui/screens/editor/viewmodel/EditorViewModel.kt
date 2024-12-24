package org.robok.engine.ui.screens.editor.viewmodel

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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.io.File
import org.robok.engine.feature.compiler.android.CompilerTask
import org.robok.engine.feature.compiler.android.logger.Logger
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.screens.editor.event.EditorEvent
import org.robok.engine.ui.screens.editor.state.EditorUIState

class EditorViewModel : ViewModel(), CompilerTask.OnCompileResult {
  private var _uiState by mutableStateOf(EditorUIState())
  val uiState: EditorUIState
    get() = _uiState

  private var _projectManager by mutableStateOf<ProjectManager?>(null)
  val projectManager: ProjectManager
    get() = _projectManager!!

  private var _buildState by mutableStateOf<BuildState>(BuildState.NotStarted)
  val buildState: BuildState
    get() = _buildState

  private var _editorEvent by mutableStateOf<EditorEvent?>(null)
  val editorEvent: EditorEvent?
    get() = _editorEvent

  private var logger = Logger()

  fun setCanUndo(canUndo: Boolean) {
    _uiState = _uiState.copy(canUndo = canUndo)
  }

  fun setCanRedo(canRedo: Boolean) {
    _uiState = _uiState.copy(canRedo = canRedo)
  }

  fun setHasFileOpen(hasFileOpen: Boolean) {
    _uiState = _uiState.copy(hasFileOpen = hasFileOpen)
  }

  fun setProjectManager(projectManager: ProjectManager) {
    _projectManager = projectManager
  }

  fun run() {
    _projectManager?.build(logger, this)
  }

  fun undo() {
    _editorEvent = EditorEvent.Undo
  }

  fun redo() {
    _editorEvent = EditorEvent.Redo
  }

  fun more() {
    _editorEvent = EditorEvent.More
  }

  fun openFile(file: File) {
    _editorEvent = EditorEvent.OpenFile(file)
  }

  fun closeFile(index: Int) {
    _editorEvent = EditorEvent.CloseFile(index)
  }

  fun closeOthers(index: Int) {
    _editorEvent = EditorEvent.CloseOthers(index)
  }

  fun closeAll() {
    _editorEvent = EditorEvent.CloseAll
  }

  fun saveFile() {
    _editorEvent = EditorEvent.SaveFile
  }

  fun saveAllFiles() {
    _editorEvent = EditorEvent.SaveAllFiles
  }
  
  fun selectFile(index: Int) {
    _editorEvent = EditorEvent.SelectFile(index)
  }

  override fun onCompileSuccess(signedApk: File) {
    _buildState = BuildState.Success(signedApk)
  }

  override fun onCompileError(error: String) {
    _buildState = BuildState.Error(error)
  }
}
