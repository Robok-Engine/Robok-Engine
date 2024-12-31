package org.robok.engine.ui.screens.editor.components.drawer.info.viewmodel

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
import org.robok.engine.ui.screens.editor.components.drawer.info.ProjectInfoDrawerIndexs

class ProjectInfoDrawerViewModel : ViewModel() {
  private var _currentTabIndex by mutableStateOf(ProjectInfoDrawerIndexs.LOGS)
  val currentTabIndex: Int
    get() = _currentTabIndex

  fun setCurrentTabIndex(value: Int) {
    _currentTabIndex = value
  }
}
