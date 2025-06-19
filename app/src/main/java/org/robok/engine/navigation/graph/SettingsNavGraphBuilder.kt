package org.robok.engine.navigation.graph

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

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.robok.engine.navigation.routes.AboutLibrariesRoute
import org.robok.engine.navigation.routes.AboutRoute
import org.robok.engine.navigation.routes.SettingsAppRoute
import org.robok.engine.navigation.routes.SettingsAppThemeColorsRoute
import org.robok.engine.navigation.routes.SettingsCodeEditorRoute
import org.robok.engine.navigation.routes.SettingsDebugLoggingRoute
import org.robok.engine.navigation.routes.SettingsDebugRoute
import org.robok.engine.navigation.routes.SettingsRoute
import org.robok.engine.ui.screens.settings.SettingsScreen
import org.robok.engine.ui.screens.settings.about.AboutScreen
import org.robok.engine.ui.screens.settings.app.SettingsAppScreen
import org.robok.engine.ui.screens.settings.app.theme.SettingsAppThemeColorsScreen
import org.robok.engine.ui.screens.settings.debug.SettingsDebugScreen
import org.robok.engine.ui.screens.settings.debug.logging.SettingsDebugLoggingScreen
import org.robok.engine.ui.screens.settings.editor.SettingsCodeEditorScreen
import org.robok.engine.ui.screens.settings.libraries.LibrariesScreen

fun NavGraphBuilder.SettingsNavGraphBuilder(navController: NavHostController) {
  composable<SettingsRoute> { SettingsScreen() }

  composable<SettingsAppRoute> {
    SettingsAppScreen(onNavigate = { route -> navController.navigate(route) })
  }

  composable<SettingsAppThemeColorsRoute> { SettingsAppThemeColorsScreen() }

  composable<SettingsCodeEditorRoute> { SettingsCodeEditorScreen() }

  composable<SettingsDebugRoute> {
    SettingsDebugScreen(onNavigate = { route -> navController.navigate(route) })
  }

  composable<SettingsDebugLoggingRoute> { SettingsDebugLoggingScreen() }

  composable<AboutLibrariesRoute> { LibrariesScreen() }

  composable<AboutRoute> { AboutScreen() }
}
