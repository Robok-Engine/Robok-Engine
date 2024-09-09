package org.gampiot.robok.feature.settings.compose.screens.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.compose.ApplicationScreen
import org.gampiot.robok.feature.component.compose.appbars.TopBar
import org.gampiot.robok.feature.component.compose.Title
import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    ApplicationScreen(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        topBar = {
            TopBar(
                barTitle = stringResource(id = Strings.common_word_settings),
                scrollBehavior = it
            )
        },
        content = {
            Column(modifier = Modifier) {
                Title(title = stringResource(id = Strings.settings_general_title))
                Preference(
                    title = stringResource(id = Strings.settings_code_editor_title),
                    description = stringResource(id = Strings.settings_code_editor_description),
                    onClick = {
                        navController.navigate("settings/codeeditor")
                    }
                )
                Title(title = stringResource(id = Strings.settings_about_title))
                Preference(
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
