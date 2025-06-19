package org.robok.engine.ui.screens.settings

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.BuildCircle
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
