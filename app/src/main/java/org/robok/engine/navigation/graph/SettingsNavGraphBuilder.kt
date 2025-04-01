package org.robok.engine.navigation.graph

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

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.robok.engine.navigation.routes.AboutLibrariesRoute
import org.robok.engine.navigation.routes.AboutRoute
import org.robok.engine.navigation.routes.SettingsAppRoute
import org.robok.engine.navigation.routes.SettingsCodeEditorRoute
import org.robok.engine.navigation.routes.SettingsDebugLoggingRoute
import org.robok.engine.navigation.routes.SettingsDebugRoute
import org.robok.engine.navigation.routes.SettingsRDKRoute
import org.robok.engine.navigation.routes.SettingsRoute
import org.robok.engine.ui.screens.settings.SettingsScreen
import org.robok.engine.ui.screens.settings.about.AboutScreen
import org.robok.engine.ui.screens.settings.app.SettingsAppScreen
import org.robok.engine.ui.screens.settings.debug.SettingsDebugScreen
import org.robok.engine.ui.screens.settings.debug.logging.SettingsDebugLoggingScreen
import org.robok.engine.ui.screens.settings.editor.SettingsCodeEditorScreen
import org.robok.engine.ui.screens.settings.libraries.LibrariesScreen

fun NavGraphBuilder.SettingsNavGraphBuilder(navController: NavHostController) {
  composable<SettingsRoute> { SettingsScreen() }

  composable<SettingsAppRoute> { SettingsAppScreen() }

  composable<SettingsCodeEditorRoute> { SettingsCodeEditorScreen() }

  composable<SettingsDebugRoute> {
    SettingsDebugScreen(onNavigate = { route -> navController.navigate(route) })
  }

  composable<SettingsDebugLoggingRoute> { SettingsDebugLoggingScreen() }

  composable<AboutLibrariesRoute> { LibrariesScreen() }

  composable<AboutRoute> { AboutScreen() }
}
