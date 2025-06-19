package org.robok.engine.core.settings.viewmodels

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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.robok.engine.core.settings.repositories.PreferencesRepository

class PreferencesViewModel(private val repo: PreferencesRepository) : ViewModel() {
  val appIsUseMonet = repo.appIsUseMonet
  val appIsUseAmoled = repo.appIsUseAmoled
  val appThemeSeedColor = repo.appThemeSeedColor
  val appThemePaletteStyleIndex = repo.appThemePaletteStyleIndex
  val editorTheme = repo.editorTheme
  val editorTypeface = repo.editorTypeface
  val editorIsUseWordWrap = repo.editorIsUseWordWrap
  val editorFont = repo.editorFont

  var onAppThemePreferenceChange: () -> Unit = {}

  fun setMonetEnable(value: Boolean) {
    viewModelScope.launch { repo.setMonetEnable(value) }
  }

  fun setAmoledEnable(value: Boolean) {
    viewModelScope.launch { repo.setAmoledEnable(value) }
  }

  fun setAppThemeSeedColor(value: Int) {
    viewModelScope.launch { repo.setAppThemeSeedColor(value) }
  }

  fun setAppThemePaletteStyleIndex(value: Int) {
    viewModelScope.launch { repo.setAppThemePaletteStyleIndex(value) }
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
