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
  val appPreferences = AppPreferencesViewModel(repo.appPreferences)
  val editorPreferences = EditorPreferencesViewModel(repo.editorPreferences)

  class AppPreferencesViewModel(private val appRepo: PreferencesRepository.AppPreferences) {
    val isUseMonet = appRepo.isUseMonet
    val isUseAmoled = appRepo.isUseAmoled
    val isUseBlur = appRepo.isUseBlur

    fun setUseMonetEnable(value: Boolean) {
      viewModelScope.launch { appRepo.setMonetEnable(value) }
    }

    fun setUseAmoledEnable(value: Boolean) {
      viewModelScope.launch { appRepo.setAmoledEnable(value) }
    }

    fun setUseBlurEnable(value: Boolean) {
      viewModelScope.launch { appRepo.setUseBlurEnable(value) }
    }
  }

  class EditorPreferencesViewModel(private val editorRepo: PreferencesRepository.EditorPreferences) {
    val theme = editorRepo.theme
    val typeface = editorRepo.typeface
    val isUseWordWrap = editorRepo.isUseWordWrap
    val font = editorRepo.font

    fun setEditorTheme(value: Int) {
      viewModelScope.launch { editorRepo.setEditorTheme(value) }
    }

    fun setEditorTypeface(value: Int) {
      viewModelScope.launch { editorRepo.setEditorTypeface(value) }
    }

    fun setEditorWordWrapEnable(value: Boolean) {
      viewModelScope.launch { editorRepo.setEditorWordWrapEnable(value) }
    }

    fun setEditorFont(value: Int) {
      viewModelScope.launch { editorRepo.setEditorFont(value) }
    }
  }
}