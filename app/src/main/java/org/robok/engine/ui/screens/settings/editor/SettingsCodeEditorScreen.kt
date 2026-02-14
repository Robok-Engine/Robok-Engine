package org.robok.engine.ui.screens.settings.editor

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

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.choice.PreferenceChoice
import org.robok.engine.ui.core.components.preferences.switch.PreferenceSwitch
import org.robok.engine.ui.draw.enableBlur

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCodeEditorScreen() {
  val preferencesViewModel = koinViewModel<PreferencesViewModel>()

  Screen(label = stringResource(id = Strings.settings_code_editor_title)) {
    PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
      EditorThemePreference(preferencesViewModel)
      EditorTypefacePreference(preferencesViewModel)
    }
    PreferenceGroup(heading = stringResource(id = Strings.settings_formatting_title)) {
      EditorWordWrapPreference(preferencesViewModel)
    }
  }
}

@Composable
private fun EditorThemePreference(preferencesViewModel: PreferencesViewModel) {
  val context = LocalContext.current
  val editorThemes = listOf(0, 1, 2, 3, 4, 5, 6) // ints/positions
  val editorThemeLabels =
    listOf(
      "Robok",
      "Robok TH",
      "GitHub",
      "Eclipse",
      "Darcula",
      "Visual Studio Code 19",
      "Notepad XX",
    ) // strings/labels

  val editorTheme by
    preferencesViewModel.editorTheme.collectAsState(initial = DefaultValues.EDITOR_THEME)

  PreferenceChoice(
    title = stringResource(id = Strings.settings_code_editor_theme_title),
    description = stringResource(id = Strings.settings_code_editor_theme_description),
    pref = editorTheme,
    options = editorThemes,
    titleFactory = { index -> editorThemeLabels.getOrElse(index) { "Unknown" } },
    onPrefChange = { newTheme -> preferencesViewModel.setEditorTheme(newTheme) },
    onSheetOpenClose = { context.enableBlur(it) },
  )
}

@Composable
private fun EditorTypefacePreference(preferencesViewModel: PreferencesViewModel) {
  val context = LocalContext.current

  val editorTypefaces = listOf(0, 1, 2, 3, 4) // ints/positions
  val editorTypefacesLabels =
    listOf(
      context.getString(Strings.common_word_normal),
      context.getString(Strings.text_bold),
      context.getString(Strings.text_monospace),
      context.getString(Strings.text_sans_serif),
      context.getString(Strings.text_serif),
    )
  val editorTypeface by
    preferencesViewModel.editorTypeface.collectAsState(initial = DefaultValues.EDITOR_TYPEFACE)

  PreferenceChoice(
    title = stringResource(id = Strings.settings_code_editor_typeface_title),
    description = stringResource(id = Strings.settings_code_editor_typeface_description),
    pref = editorTypeface,
    options = editorTypefaces,
    titleFactory = { index -> editorTypefacesLabels.getOrElse(index) { "Unknown" } },
    onPrefChange = { newTypeface -> preferencesViewModel.setEditorTypeface(newTypeface) },
    onSheetOpenClose = { context.enableBlur(it) },
  )
}

@Composable
private fun EditorWordWrapPreference(preferencesViewModel: PreferencesViewModel) {
  val editorIsUseWordWrap by
    preferencesViewModel.editorIsUseWordWrap.collectAsState(
      initial = DefaultValues.EDITOR_IS_USE_WORD_WRAP
    )
  PreferenceSwitch(
    checked = editorIsUseWordWrap,
    onCheckedChange = { newValue -> preferencesViewModel.setEditorWordWrapEnable(newValue) },
    title = stringResource(id = Strings.settings_code_editor_word_wrap_title),
    description = stringResource(id = Strings.settings_code_editor_word_wrap_description),
  )
}
