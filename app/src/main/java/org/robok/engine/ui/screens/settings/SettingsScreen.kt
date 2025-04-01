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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.BuildCircle
import androidx.compose.material.icons.rounded.DeveloperMode
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import org.robok.engine.Strings
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.routes.AboutLibrariesRoute
import org.robok.engine.navigation.routes.AboutRoute
import org.robok.engine.navigation.routes.SettingsAppRoute
import org.robok.engine.navigation.routes.SettingsCodeEditorRoute
import org.robok.engine.navigation.routes.SettingsDebugRoute
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.category.PreferenceCategory
import org.robok.engine.ui.platform.LocalMainNavController

@Composable
fun SettingsScreen() {
  val navController = LocalMainNavController.current
  Screen(label = stringResource(id = Strings.common_word_settings)) {
    GeneralCategories(navController)
    BuildCategories(navController)
    AboutCategories(navController)
    DebugOnlyCategories(navController)
  }
}

@Composable
fun GeneralCategories(navController: NavHostController) {
  PreferenceCategory(
    title = stringResource(id = Strings.settings_app_title),
    description = stringResource(id = Strings.settings_app_description),
    icon = Icons.Rounded.Android,
    onClick = { navController.navigateSingleTop(route = SettingsAppRoute) },
  )
  PreferenceCategory(
    title = stringResource(id = Strings.settings_code_editor_title),
    description = stringResource(id = Strings.settings_code_editor_description),
    icon = Icons.Rounded.Edit,
    onClick = { navController.navigateSingleTop(route = SettingsCodeEditorRoute) },
  )
}

@Composable
fun AboutCategories(navController: NavHostController) {
  PreferenceCategory(
    title = stringResource(id = Strings.settings_libraries_title),
    description = stringResource(id = Strings.settings_libraries_description),
    icon = Icons.Rounded.Book,
    onClick = { navController.navigateSingleTop(route = AboutLibrariesRoute) },
  )
  PreferenceCategory(
    title = stringResource(id = Strings.settings_about_title),
    description = stringResource(id = Strings.settings_about_description),
    icon = Icons.Rounded.Info,
    onClick = { navController.navigateSingleTop(route = AboutRoute) },
  )
}

@Composable
fun DebugOnlyCategories(navController: NavHostController) {
  PreferenceCategory(
    title = stringResource(id = Strings.settings_debug_title),
    description = stringResource(id = Strings.settings_debug_description),
    icon = Icons.Rounded.BuildCircle,
    onClick = { navController.navigateSingleTop(route = SettingsDebugRoute) },
  )
}
