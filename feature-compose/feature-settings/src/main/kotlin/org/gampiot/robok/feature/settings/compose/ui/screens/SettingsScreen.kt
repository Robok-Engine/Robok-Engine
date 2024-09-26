package org.gampiot.robok.feature.settings.compose.screens.ui

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.text.font.FontWeight

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.component.compose.text.RobokText
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
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_build_title)) {
             buildPrefs(navController)
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
       text = { RobokText(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_app_title)) },
       secondaryText = { RobokText(text = stringResource(id = Strings.settings_app_description)) },
       onClick = {
           navController.navigate("settings/app")
       }
   )
   Preference(
       text = { RobokText(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_code_editor_title)) },
       secondaryText = { RobokText(text = stringResource(id = Strings.settings_code_editor_description)) },
       onClick = {
           navController.navigate("settings/codeeditor")
       }
   )
}

@Composable
fun buildPrefs(
    navController: NavController
) {
   Preference(
       text = { RobokText(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_configure_rdk_title)) },
       secondaryText = { RobokText(stringResource(id = Strings.settings_configure_rdk_description)) },
       onClick = {
           navController.navigate("settings/configure_rdk")
       }
   )
}

@Composable
fun aboutPrefs(
    navController: NavController
) {
   Preference(
       text = { RobokText(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_libraries_title)) },
       secondaryText = { RobokText(stringResource(id = Strings.settings_libraries_description)) },
       onClick = {
           navController.navigate("settings/libraries")
       }
   )
   Preference(
       text = { RobokText(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_about_title)) },
       secondaryText = { RobokText(stringResource(id = Strings.settings_about_description)) },
       onClick = {
           navController.navigate("settings/about")
       }
   )
}