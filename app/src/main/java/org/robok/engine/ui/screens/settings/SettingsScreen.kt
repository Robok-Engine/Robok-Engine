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
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import org.robok.engine.BuildConfig
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.category.PreferenceCategory
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.routes.AboutLibrariesRoute
import org.robok.engine.routes.AboutRoute
import org.robok.engine.routes.SettingsAppRoute
import org.robok.engine.routes.SettingsCodeEditorRoute
import org.robok.engine.routes.SettingsRDKRoute
import org.robok.engine.routes.SettingsDebugRoute
import org.robok.engine.strings.Strings

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
    label = stringResource(id = Strings.settings_app_title),
    description = stringResource(id = Strings.settings_app_description),
    icon = Icons.Rounded.Android,
    onClick = { navController.navigateSingleTop(route = SettingsAppRoute) },
  )
  PreferenceCategory(
    label = stringResource(id = Strings.settings_code_editor_title),
    description = stringResource(id = Strings.settings_code_editor_description),
    icon = Icons.Rounded.Edit,
    onClick = { navController.navigateSingleTop(route = SettingsCodeEditorRoute) },
  )
}

@Composable
fun BuildCategories(navController: NavHostController) {
  PreferenceCategory(
    label = stringResource(id = Strings.settings_configure_rdk_title),
    description = stringResource(id = Strings.settings_configure_rdk_description),
    icon = Icons.Rounded.DeveloperMode,
    onClick = { navController.navigateSingleTop(route = SettingsRDKRoute) },
  )
}

@Composable
fun AboutCategories(navController: NavHostController) {
  PreferenceCategory(
    label = stringResource(id = Strings.settings_libraries_title),
    description = stringResource(id = Strings.settings_libraries_description),
    icon = Icons.Rounded.Book,
    onClick = { navController.navigateSingleTop(route = AboutLibrariesRoute) },
  )
  PreferenceCategory(
    label = stringResource(id = Strings.settings_about_title),
    description = stringResource(id = Strings.settings_about_description),
    icon = Icons.Rounded.Info,
    onClick = { navController.navigateSingleTop(route = AboutRoute) },
  )
}


@Composable
fun DebugOnlyCategories(navController: NavHostController) {
  if (BuildConfig.DEBUG) {
    PreferenceCategory(
      label = stringResource(id = Strings.settings_debug_title),
      description = stringResource(id = Strings.settings_debug_description),
      icon = Icons.Rounded.BuildCircle,
      onClick = { navController.navigateSingleTop(route = SettingsDebugRoute) },
    )
  }
}