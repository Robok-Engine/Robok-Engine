package org.gampiot.robok.feature.settings.compose.screens.ui.editor

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

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.choice.PreferenceChoice
import org.gampiot.robok.feature.component.compose.preferences.switch.PreferenceSwitch
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCodeEditorScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_code_editor_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
            appearancePrefs(appPrefsViewModel)
        }
        PreferenceGroup(heading = stringResource(id = Strings.settings_formatting_title)) {
            formattingPrefs(appPrefsViewModel)
        }
    }
}

@Composable
fun appearancePrefs(
    appPrefsViewModel: AppPreferencesViewModel
) {
     val context = LocalContext.current
     val editorThemes = listOf(0, 1, 2, 3, 4, 5, 6) //ints/positions
     val editorThemeLabels = listOf(
         "Robok",
         "Robok TH", 
         "GitHub", 
         "Eclipse", 
         "Darcula", 
         "Visual Studio Code 19", 
         "Notepad XX"
     ) // strings/labels
    
     val editorTypefaces = listOf(0, 1, 2, 3, 4) // ints/positions
     val editorTypefacesLabels = listOf(
        context.getString(Strings.common_word_normal),
        context.getString(Strings.text_bold),
        context.getString(Strings.text_monospace),
        context.getString(Strings.text_sans_serif),
        context.getString(Strings.text_serif)
     ) // strings/labels
     val editorTheme by appPrefsViewModel.editorTheme.collectAsState(initial = 0)
     val editorTypeface by appPrefsViewModel.editorTypeface.collectAsState(initial = 0)
     
     PreferenceChoice(
          label = stringResource(id = Strings.settings_code_editor_theme_title),
          title = stringResource(id = Strings.settings_code_editor_theme_description),
          pref = editorTheme,
          options = editorThemes,
          excludedOptions = emptyList(),
          labelFactory = { index ->
              editorThemeLabels.getOrElse(index) { "Unknown" }
          },
          onPrefChange = { newTheme ->
              appPrefsViewModel.changeEditorTheme(newTheme)
          }
     )
     
     PreferenceChoice(
          label = stringResource(id = Strings.settings_code_editor_typeface_title),
          title = stringResource(id = Strings.settings_code_editor_typeface_description),
          pref = editorTypeface,
          options = editorTypefaces,
          excludedOptions = emptyList(),
          labelFactory = { index ->
              editorTypefacesLabels.getOrElse(index) { "Unknown" }
          },
          onPrefChange = { newTypeface ->
              appPrefsViewModel.changeEditorTypeface(newTypeface)
          }
     )     
}

@Composable 
fun formattingPrefs(
    appPrefsViewModel: AppPreferencesViewModel
) {
     val editorIsUseWordWrap by appPrefsViewModel.editorIsUseWordWrap.collectAsState(initial = false)
     PreferenceSwitch(
          checked = editorIsUseWordWrap,
          onCheckedChange = { newValue ->
              appPrefsViewModel.enableEditorWordWrap(newValue)
          },
          label = stringResource(id = Strings.settings_code_editor_word_wrap_title),
          description = stringResource(id = Strings.settings_code_editor_word_wrap_description)
     )
}