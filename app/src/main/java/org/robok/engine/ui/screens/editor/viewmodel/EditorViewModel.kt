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
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.screens.editor.state.EditorUIState

class EditorViewModel : ViewModel() {
  private var _uiState by mutableStateOf(EditorUIState())
  val uiState: EditorUIState
    get() = _uiState

  private var _projectManager by mutableStateOf<ProjectManager?>(null)
  val projectManager: ProjectManager
    get() = _projectManager!!

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
}
