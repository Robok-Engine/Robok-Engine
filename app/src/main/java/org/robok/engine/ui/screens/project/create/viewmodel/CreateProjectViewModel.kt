package org.robok.engine.ui.screens.project.create.viewmodel

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

  fun setProjectPath(file: File) {
    projectManager.projectPath = file
  }

  fun setIsLoading(newIsLoading: Boolean) {
    _uiState = _uiState.copy(isLoading = newIsLoading)
  }

  fun setLanguage(newLanguage: Language) {
    _uiState = _uiState.copy(language = newLanguage)
  }

  fun getProjectPath(): File = projectManager.projectPath

  fun create(template: ProjectTemplate, onSuccess: () -> Unit, onError: (String) -> Unit) {
    setIsLoading(true)
    viewModelScope.launch {
      createProject(template = template, onSuccess = onSuccess, onError = onError)
    }
  }

  private suspend fun createProject(
    template: ProjectTemplate,
    onSuccess: () -> Unit,
    onError: (String) -> Unit,
  ) {
    if (_uiState.projectName.isEmpty() || _uiState.packageName.isEmpty()) {
      setIsLoading(false)
      onError("Project name and package name cannot be empty.")
      return
    }

    projectManager.creationListener =
      object : ProjectManager.CreationListener {
        override fun onProjectCreate() {
          setIsLoading(false)
          onSuccess()
        }

        override fun onProjectCreateError(error: String) {
          setIsLoading(false)
          onError(error)
        }
      }
    projectManager.create(_uiState.projectName, _uiState.packageName, _uiState.language, template)
  }
}
