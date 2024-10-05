package org.robok.engine.ui.screens.settings

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.components.compose.preferences.base.PreferenceGroup
import org.robok.engine.core.components.compose.preferences.base.PreferenceLayout
import org.robok.engine.core.components.compose.preferences.normal.Preference
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.strings.Strings

@Composable
fun SettingsScreen(
    navController: NavController
) {
  koinViewModel<AppPreferencesViewModel>()
    
    PreferenceLayout(
        label = stringResource(id = Strings.common_word_settings),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_general_title)) {
             generalPrefs(navController)
        }
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_build_title)) {
             BuildPrefs(navController)
        }
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_about_title)) {
              AboutPrefs(navController)
        }
    }
}

@Composable
fun generalPrefs(
    navController: NavController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_app_title)) },
       secondaryText = { Text(text = stringResource(id = Strings.settings_app_description)) },
       onClick = {
           navController.navigate("settings/app")
       }
   )
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_code_editor_title)) },
       secondaryText = { Text(text = stringResource(id = Strings.settings_code_editor_description)) },
       onClick = {
           navController.navigate("settings/codeeditor")
       }
   )
}

@Composable
fun BuildPrefs(
    navController: NavController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_configure_rdk_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_configure_rdk_description)) },
       onClick = {
           navController.navigate("settings/configure_rdk")
       }
   )
}

@Composable
fun AboutPrefs(
    navController: NavController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_libraries_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_libraries_description)) },
       onClick = {
           navController.navigate("settings/libraries")
       }
   )
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_about_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_about_description)) },
       onClick = {
           navController.navigate("settings/about")
       }
   )
}