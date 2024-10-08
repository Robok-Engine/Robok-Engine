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
import androidx.navigation.NavHostController

import org.robok.engine.routes.SettingsAppRoute
import org.robok.engine.routes.SettingsCodeEditorRoute
import org.robok.engine.routes.SettingsRDKRoute
import org.robok.engine.routes.AboutRoute
import org.robok.engine.routes.AboutLibrariesRoute
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.core.components.compose.preferences.base.PreferenceGroup
import org.robok.engine.core.components.compose.preferences.base.PreferenceLayout
import org.robok.engine.core.components.compose.preferences.normal.Preference
import org.robok.engine.strings.Strings

@Composable
fun SettingsScreen(
    navController: NavHostController
) {
    PreferenceLayout(
        label = stringResource(id = Strings.common_word_settings),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_general_title)) {
             GeneralPreferences(navController)
        }
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_build_title)) {
             BuildPreferences(navController)
        }
        
        PreferenceGroup(heading = stringResource(id = Strings.settings_about_title)) {
              AboutPreferences(navController)
        }
    }
}

@Composable
fun GeneralPreferences(
    navController: NavHostController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_app_title)) },
       secondaryText = { Text(text = stringResource(id = Strings.settings_app_description)) },
       onClick = {
           navController.navigateSingleTop(route = SettingsAppRoute)
       }
   )
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_code_editor_title)) },
       secondaryText = { Text(text = stringResource(id = Strings.settings_code_editor_description)) },
       onClick = {
           navController.navigateSingleTop(route = SettingsCodeEditorRoute)
       }
   )
}

@Composable
fun BuildPreferences(
    navController: NavHostController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_configure_rdk_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_configure_rdk_description)) },
       onClick = {
           navController.navigateSingleTop(route = SettingsRDKRoute)
       }
   )
}

@Composable
fun AboutPreferences(
    navController: NavHostController
) {
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_libraries_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_libraries_description)) },
       onClick = {
           navController.navigateSingleTop(route = AboutLibrariesRoute)
       }
   )
   Preference(
       text = { Text(fontWeight = FontWeight.Bold, text = stringResource(id = Strings.settings_about_title)) },
       secondaryText = { Text(stringResource(id = Strings.settings_about_description)) },
       onClick = {
           navController.navigateSingleTop(route = AboutRoute)
       }
   )
}