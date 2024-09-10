package org.gampiot.robok.feature.settings.compose.screens.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    PreferenceLayout(
        label = stringResource(id = Strings.common_word_settings),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_general_title)) {
             generalPrefs(navController)
        }
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_about_title)) {
             aboutPrefs(navController)
        }
    }
}

@Composable
fun generalPrefs(
    navController: NavController
) {
   Preference(
       text = { Text(stringResource(id = Strings.settings_code_editor_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_code_editor_description)) },
       onClick = {
           navController.navigate("settings/codeeditor")
       }
   )
}

@Composable
fun aboutPrefs(
    navController: NavController
) {
   Preference(
       text = { Text(stringResource(id = Strings.settings_libraries_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_libraries_description)) },
       onClick = {
           navController.navigate("settings/libraries")
       }
   )
   Preference(
       text = { Text(stringResource(id = Strings.settings_about_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_about_description)) },
       onClick = {
           navController.navigate("settings/about")
       }
   )
}