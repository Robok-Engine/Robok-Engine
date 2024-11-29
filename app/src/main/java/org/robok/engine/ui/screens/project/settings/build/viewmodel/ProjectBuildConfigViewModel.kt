package org.robok.engine.ui.screens.project.settings.build.viewmodel

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
import org.robok.engine.ui.screens.project.settings.build.state.ProjectBuildConfigUIState

class ProjectBuildConfigViewModel : ViewModel() {
  private var _uiState by mutableStateOf(ProjectBuildConfigUIState())

  val uiState: ProjectBuildConfigUIState
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
