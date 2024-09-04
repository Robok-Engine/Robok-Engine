package org.gampiot.robok.feature.settings.screens.editor

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.ApplicationScreen
import org.gampiot.robok.feature.component.appbars.TopBar
import org.gampiot.robok.feature.component.Title
import org.gampiot.robok.feature.component.preferences.vegabobo.PreferenceItem
import org.gampiot.robok.feature.component.preferences.bunny.PreferenceItemChoice
import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCodeEditorScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    val editorTheme by appPrefsViewModel.editorTheme.collectAsState(initial = 0) // Assume 0 as the initial value

    val editorThemes = listOf(
        0, // Robok
        1, // Robok TH
        2, // GitHub
        3, // Eclipse
        4, // Darcula
        5, // Visual Studio Code 19
        6  // Notepad XX
    )

    val editorThemeLabels = listOf(
        "Robok",
        "Robok TH",
        "GitHub",
        "Eclipse",
        "Darcula",
        "Visual Studio Code 19",
        "Notepad XX"
    )

    ApplicationScreen(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        topBar = {
            TopBar(
                barTitle = stringResource(id = Strings.settings_code_editor_title),
                scrollBehavior = it,
                onClickBackButton = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            Column(modifier = Modifier) {
                Title(title = stringResource(id = Strings.settings_appearance_title))
                PreferenceItemChoice(
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
                Title(title = stringResource(id = Strings.settings_formatting_title))
                PreferenceItem (
                     title = stringResource(id = Strings.settings_code_editor_word_wrap_title),
                     description = stringResource(id = Strings.settings_code_editor_word_wrap_description),
                     showToggle = true,
                     isChecked = editorIsUseWordWrap,
                     onClick = {
                          appPrefsViewModel.enableEditorWordWrap(!it)
                     }
                )
            }
        }
    )
}
