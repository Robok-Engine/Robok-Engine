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

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.Log
import org.robok.engine.feature.compiler.android.CompilerTask
import org.robok.engine.feature.compiler.android.logger.Logger
import org.robok.engine.feature.editor.RobokCodeEditor
import org.robok.engine.io.File
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

  var context: Context? = null

  /** the instance of logger of build */
  private var logger = Logger()

  /**
   * Defines if can undo
   *
   * canUndo new value of canUndo
   */
  fun setCanUndo(canUndo: Boolean) {
    _uiState = _uiState.copy(canUndo = canUndo)
  }

  /**
   * Defines if can redo
   *
   * canRedo new value of canRedo
   */
  fun setCanRedo(canRedo: Boolean) {
    _uiState = _uiState.copy(canRedo = canRedo)
  }

  fun setMoreOptionOpen(moreOptionOpen: Boolean) {
    _uiState = _uiState.copy(moreOptionOpen = moreOptionOpen)
  }

  /**
   * Defines the current project manager
   *
   * @param projectManager The instance of current projectManager
   */
  fun setProjectManager(projectManager: ProjectManager) {
    _projectManager = projectManager
    _uiState = _uiState.copy(title = projectManager.getProjectName())
  }

  /** init the compilation */
  fun run() {
    _projectManager?.build(logger, this)
  }

  /** triggered when request to redo an action */
  fun undo() {
    _editorEvent = EditorEvent.Undo
  }

  /** triggered when request to undo an action */
  fun redo() {
    _editorEvent = EditorEvent.Redo
  }

  /** triggered when request to show more option */
  fun more() {
    _editorEvent = EditorEvent.More
  }

  /**
   * triggered when request to open file
   *
   * @param file File to be opened
   */
  fun openFile(file: File) {
    _editorEvent = EditorEvent.OpenFile(file)
  }

  /**
   * triggered when request to close file
   *
   * @param index The index of file in List
   */
  fun closeFile(index: Int) {
    _editorEvent = EditorEvent.CloseFile(index)
  }

  /**
   * triggered when request to close others
   *
   * @param index The index of current file in List
   */
  fun closeOthersFiles(index: Int) {
    _editorEvent = EditorEvent.CloseOthers(index)
  }

  /** triggered when request to close all files */
  fun closeAllFiles() {
    _editorEvent = EditorEvent.CloseAll
  }

  /** triggered when request to save file */
  fun saveFile() {
    _editorEvent = EditorEvent.SaveFile
  }

  /** triggered when request to save all files */
  fun saveAllFiles() {
    _editorEvent = EditorEvent.SaveAllFiles
  }

  /**
   * triggered when request to select a file in tabs
   *
   * @param index Index of file in list
   */
  fun selectFile(index: Int) {
    _editorEvent = EditorEvent.SelectFile(index)
  }

  /**
   * defines the current file index in ui state
   *
   * @param index Index of file in list
   */
  fun setCurrentFileIndex(index: Int) {
    _uiState = _uiState.copy(selectedFileIndex = index)
    clearEvent()
  }

  /**
   * add file in list
   *
   * @param file The file to add
   */
  fun addFile(file: File) {
    val openedFiles = _uiState.openedFiles.toMutableList()

    if (!openedFiles.contains(file)) {
      openedFiles.add(file)

      val newEditor = RobokCodeEditor(context!!, file) // use !! because context never will be null

      val newEditors = _uiState.editors.toMutableList()
      newEditors.add(newEditor)
      _uiState = _uiState.copy(editors = newEditors)
    }
    _uiState = _uiState.copy(openedFiles = openedFiles, hasFileOpen = openedFiles.isNotEmpty())
    clearEvent()
  }

  /**
   * Remove the file and its corresponding editor from the list.
   *
   * @param index The index of the file to remove
   */
  fun removeFile(index: Int) {
    val openedFiles = _uiState.openedFiles.toMutableList()
    val editors = _uiState.editors.toMutableList()

    openedFiles.removeAt(index)
    editors.removeAt(index)

    val newSelectedFileIndex =
      if (openedFiles.isEmpty()) {
        0
      } else {
        index.coerceAtMost(openedFiles.size - 1)
      }

    _uiState =
      _uiState.copy(
        openedFiles = openedFiles,
        hasFileOpen = openedFiles.isNotEmpty(),
        selectedFileIndex = newSelectedFileIndex,
        editors = editors,
      )

    clearEvent()
  }

  /** remove all files from list */
  fun removeAllFiles() {
    _uiState.editors.forEach { it.release() }
    _uiState =
      _uiState.copy(
        openedFiles = emptyList(),
        hasFileOpen = false,
        editors = emptyList(),
        selectedFileIndex = 0,
      )
    clearEvent()
  }

  /** remove others files except current */
  fun removeOthersFiles() {
    if (_uiState.selectedFileIndex >= 0) {
      val file = _uiState.openedFiles.get(_uiState.selectedFileIndex)
      var index: Int = 0
      while (_uiState.openedFiles.size > 1) {
        val editor = getEditor(index) ?: continue

        if (file != editor.file) {
          removeFile(index)
        } else {
          index = 1
        }
      }
      setCurrentFileIndex(_uiState.openedFiles.indexOf(file))
    }
    clearEvent()
  }

  /** save file */
  fun writeFile(file: File) {
    getSelectedEditor()?.let { editor ->
      FileUtil.writeFile(editor.getFile().absolutePath, editor.getText().toString())
    }
    clearEvent()
  }

  /** save all files */
  fun writeAllFiles() {
    _uiState.openedFiles.forEach { file -> writeFile(file) }
    clearEvent()
  }

  /**
   * get editor based on index
   *
   * @param index of editor
   */
  fun getEditor(index: Int): RobokCodeEditor? {
    return _uiState.editors.getOrNull(index)
  }

  /** get selected editor */
  fun getSelectedEditor(): RobokCodeEditor? {
    return getEditor(_uiState.selectedFileIndex)
  }

  /**
   * defines if user can redo or undo based on editor status
   *
   * @param editor The instance of editor to be verified
   */
  fun updateUndoRedo(editor: RobokCodeEditor) {
    _uiState = _uiState.copy(canUndo = editor.isCanUndo(), canRedo = editor.isCanRedo())
  }

  /** clear event after action */
  fun clearEvent() {
    _editorEvent = null
  }

  /**
   * called when compilation is succesfully
   *
   * @param signedApk The File of apk ready to install
   */
  override fun onCompileSuccess(signedApk: java.io.File) {
    _buildState = BuildState.Success(signedApk as File)
  }

  /**
   * called when compilation is error (so sad lmfao 👽😭😭 )
   *
   * @param error The error of compilation. cry baby
   */
  override fun onCompileError(error: String) {
    _buildState = BuildState.Error(error)
  }

  /** helper to print list content */
  private inline fun List<*>.print(tag: String = "") {
    Log.d(tag = tag, message = toString())
  }
}
