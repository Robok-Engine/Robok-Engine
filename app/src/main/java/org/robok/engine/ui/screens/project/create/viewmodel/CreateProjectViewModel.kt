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
import org.robok.engine.ui.screens.project.create.state.CreateProjectState

class CreateProjectViewModel(private val projectManager: ProjectManager) : ViewModel() {
  var state by mutableStateOf(CreateProjectState())

  fun updateProjectName(name: String) {
    state = state.copy(projectName = name)
  }

  fun updatePackageName(name: String) {
    state = state.copy(packageName = name)
  }

  fun updateErrorMessage(message: String?) {
    state = state.copy(errorMessage = message ?: "Null Message")
  }

  fun setProjectPath(file: File) {
    projectManager.projectPath = file
  }

  fun getProjectPath(): File = projectManager.projectPath

  fun createProject(template: ProjectTemplate, onSuccess: () -> Unit, onError: (String) -> Unit) {
    if (state.projectName.isEmpty() || state.packageName.isEmpty()) {
      state = state.copy(errorMessage = "Project name and package name cannot be empty.")
      return
    }

    viewModelScope.launch {
      state = state.copy(isLoading = true, errorMessage = null)
      val projectCreationListener =
        object : ProjectManager.CreationListener {
          override fun onProjectCreate() {
            onSuccess()
            state = state.copy(isLoading = false)
          }

          override fun onProjectCreateError(error: String) {
            onError(error)
          }
        }
      projectManager.setCreationListener(projectCreationListener)
      projectManager.create(state.projectName, state.packageName, template)
    }
  }
}
