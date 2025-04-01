package org.robok.engine.core.settings.viewmodels

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
import org.robok.engine.core.settings.repositories.PreferencesRepository

class PreferencesViewModel(private val repo: PreferencesRepository) : ViewModel() {
  val appIsUseMonet = repo.appIsUseMonet
  val appIsUseAmoled = repo.appIsUseAmoled
  val editorTheme = repo.editorTheme
  val editorTypeface = repo.editorTypeface
  val editorIsUseWordWrap = repo.editorIsUseWordWrap
  val editorFont = repo.editorFont

  var onAppThemePreferenceChange: () -> Unit = {}

  fun setMonetEnable(value: Boolean) {
    onAppThemePreferenceChange()
    viewModelScope.launch { repo.setMonetEnable(value) }
  }

  fun setAmoledEnable(value: Boolean) {
    onAppThemePreferenceChange()
    viewModelScope.launch { repo.setAmoledEnable(value) }
  }

  fun setEditorTheme(value: Int) {
    viewModelScope.launch { repo.setEditorTheme(value) }
  }

  fun setEditorTypeface(value: Int) {
    viewModelScope.launch { repo.setEditorTypeface(value) }
  }

  fun setEditorWordWrapEnable(value: Boolean) {
    viewModelScope.launch { repo.setEditorWordWrapEnable(value) }
  }

  fun setEditorFont(value: Int) {
    viewModelScope.launch { repo.setEditorFont(value) }
  }
}
