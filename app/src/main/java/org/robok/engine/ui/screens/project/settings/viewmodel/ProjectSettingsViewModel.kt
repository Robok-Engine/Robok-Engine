package org.robok.engine.ui.screens.project.settings.viewmodel

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
import org.robok.engine.ui.screens.project.settings.state.ProjectSettingsUIState

class ProjectSettingsViewModel : ViewModel() {
  private var _uiState by mutableStateOf(ProjectSettingsUIState())

  val uiState: ProjectSettingsUIState
    get() = _uiState

  fun setGameName(gameName: String) {
    _uiState = _uiState.copy(gameName = gameName)
  }

  fun setGameIconPath(gameIconPath: String) {
    _uiState = _uiState.copy(gameIconPath = gameIconPath)
  }

  fun setMainScreenName(mainScreenName: String) {
    _uiState = _uiState.copy(mainScreenName = mainScreenName)
  }
}
