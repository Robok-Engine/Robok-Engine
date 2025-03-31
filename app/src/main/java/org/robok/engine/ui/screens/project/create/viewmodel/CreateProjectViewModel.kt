package org.robok.engine.ui.screens.project.create.viewmodel

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
import androidx.lifecycle.viewModelScope
import java.io.File
import kotlinx.coroutines.launch
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.templates.Language
import org.robok.engine.ui.screens.project.create.state.CreateProjectUIState

class CreateProjectViewModel(private val projectManager: ProjectManager) : ViewModel() {
  private var _uiState by mutableStateOf(CreateProjectUIState())
  val uiState: CreateProjectUIState
    get() = _uiState

  fun setProjectName(name: String) {
    _uiState = _uiState.copy(projectName = name)
  }

  fun setPackageName(name: String) {
    _uiState = _uiState.copy(packageName = name)
  }

  fun setErrorMessage(message: String?) {
    _uiState = _uiState.copy(errorMessage = message ?: "Null Message")
  }

  fun setProjectPath(file: File) {
    projectManager.projectPath = file
  }

  fun setLanguage(newLanguage: Language) {
    _uiState = _uiState.copy(language = newLanguage)
  }

  fun getProjectPath(): File = projectManager.projectPath

  fun createProject(template: ProjectTemplate, onSuccess: () -> Unit, onError: (String) -> Unit) {
    if (_uiState.projectName.isEmpty() || _uiState.packageName.isEmpty()) {
      _uiState = _uiState.copy(errorMessage = "Project name and package name cannot be empty.")
      return
    }

    viewModelScope.launch {
      _uiState = _uiState.copy(isLoading = true, errorMessage = null)
      projectManager.creationListener =
        object : ProjectManager.CreationListener {
          override fun onProjectCreate() {
            onSuccess()
            _uiState = _uiState.copy(isLoading = false)
          }

          override fun onProjectCreateError(error: String) {
            onError(error)
          }
        }
      projectManager.create(_uiState.projectName, _uiState.packageName, _uiState.language, template)
    }
  }
}
