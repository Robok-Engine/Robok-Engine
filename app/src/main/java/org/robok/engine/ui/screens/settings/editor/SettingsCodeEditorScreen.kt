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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.choice.PreferenceChoice
import org.robok.engine.core.components.preferences.switch.PreferenceSwitch
import org.robok.engine.feature.settings.DefaultValues
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCodeEditorScreen() {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()

    Screen(label = stringResource(id = Strings.settings_code_editor_title)) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
            appearancePrefs(appPrefsViewModel)
        }
        PreferenceGroup(heading = stringResource(id = Strings.settings_formatting_title)) {
            formattingPrefs(appPrefsViewModel)
        }
    }
}

@Composable
fun appearancePrefs(appPrefsViewModel: AppPreferencesViewModel) {
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

    val editorTypefaces = listOf(0, 1, 2, 3, 4) // ints/positions
    val editorTypefacesLabels =
        listOf(
            context.getString(Strings.common_word_normal),
            context.getString(Strings.text_bold),
            context.getString(Strings.text_monospace),
            context.getString(Strings.text_sans_serif),
            context.getString(Strings.text_serif),
        ) // strings/labels
    val editorTheme by
        appPrefsViewModel.editorTheme.collectAsState(initial = DefaultValues.EDITOR_THEME)
    val editorTypeface by
        appPrefsViewModel.editorTypeface.collectAsState(initial = DefaultValues.EDITOR_TYPEFACE)

    PreferenceChoice(
        label = stringResource(id = Strings.settings_code_editor_theme_title),
        title = stringResource(id = Strings.settings_code_editor_theme_description),
        pref = editorTheme,
        options = editorThemes,
        excludedOptions = emptyList(),
        labelFactory = { index -> editorThemeLabels.getOrElse(index) { "Unknown" } },
        onPrefChange = { newTheme -> appPrefsViewModel.changeEditorTheme(newTheme) },
    )

    PreferenceChoice(
        label = stringResource(id = Strings.settings_code_editor_typeface_title),
        title = stringResource(id = Strings.settings_code_editor_typeface_description),
        pref = editorTypeface,
        options = editorTypefaces,
        excludedOptions = emptyList(),
        labelFactory = { index -> editorTypefacesLabels.getOrElse(index) { "Unknown" } },
        onPrefChange = { newTypeface -> appPrefsViewModel.changeEditorTypeface(newTypeface) },
    )
}

@Composable
fun formattingPrefs(appPrefsViewModel: AppPreferencesViewModel) {
    val editorIsUseWordWrap by
        appPrefsViewModel.editorIsUseWordWrap.collectAsState(
            initial = DefaultValues.EDITOR_IS_USE_WORD_WRAP
        )
    PreferenceSwitch(
        checked = editorIsUseWordWrap,
        onCheckedChange = { newValue -> appPrefsViewModel.enableEditorWordWrap(newValue) },
        label = stringResource(id = Strings.settings_code_editor_word_wrap_title),
        description = stringResource(id = Strings.settings_code_editor_word_wrap_description),
    )
}
