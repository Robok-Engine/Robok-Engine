package org.gampiot.robok.feature.settings.screens

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
import org.gampiot.robok.feature.component.preferences.bunny.PreferenceItemChoice
import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    val editorTheme by appPrefsViewModel.editorTheme.collectAsState(initial = 0) // Assume 0 as the initial value

    // Define the list of options
    val editorThemes = listOf(
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
                barTitle = stringResource(id = Strings.common_word_settings),
                onClickBackButton = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            Column(modifier = Modifier.padding(16.dp)) {
                Title(title = stringResource(id = Strings.settings_appearance_title))
                
                PreferenceItemChoice(
                    label = stringResource(id = Strings.settings_editor_title),
                    title = stringResource(id = Strings.settings_editor_title),
                    pref = editorTheme,
                    options = editorThemes, // Pass options here
                    excludedOptions = emptyList(),
                    labelFactory = { index ->
                        editorThemes.getOrElse(index) { "Robok" }
                    },
                    onPrefChange = { newTheme ->
                        appPrefsViewModel.changeEditorTheme(newTheme)
                    }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Title(title = stringResource(id = Strings.settings_about_title))
                
                PreferenceItem(
                    title = stringResource(id = Strings.settings_libraries_title),
                    description = stringResource(id = Strings.settings_libraries_description),
                    onClick = {
                        navController.navigate("settings/libraries")
                    }
                )
            }
        }
    )
}
