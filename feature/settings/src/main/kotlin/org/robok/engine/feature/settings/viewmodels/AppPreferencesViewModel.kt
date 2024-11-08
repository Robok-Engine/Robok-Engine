package org.robok.engine.feature.settings.viewmodels

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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.robok.engine.feature.settings.repositories.PreferencesRepository

class PreferencesViewModel(private val repo: PreferencesRepository) : ViewModel() {
  val installedRDKVersion = repo.installedRDKVersion
  val appIsUseMonet = repo.appIsUseMonet
  val appIsUseAmoled = repo.appIsUseAmoled
  val editorTheme = repo.editorTheme
  val editorTypeface = repo.editorTypeface
  val editorIsUseWordWrap = repo.editorIsUseWordWrap

  fun changeInstalledRDK(value: String) {
    viewModelScope.launch { repo.changeInstalledRDK(value) }
  }

  fun enableMonet(value: Boolean) {
    viewModelScope.launch { repo.enableMonet(value) }
  }

  fun enableAmoled(value: Boolean) {
    viewModelScope.launch { repo.enableAmoled(value) }
  }

  fun changeEditorTheme(value: Int) {
    viewModelScope.launch { repo.changeEditorTheme(value) }
  }

  fun changeEditorTypeface(value: Int) {
    viewModelScope.launch { repo.changeEditorTypeface(value) }
  }

  fun enableEditorWordWrap(value: Boolean) {
    viewModelScope.launch { repo.enableEditorWordWrap(value) }
  }
}
