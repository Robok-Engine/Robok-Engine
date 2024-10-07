package org.robok.engine.routes

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

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import org.robok.engine.BuildConfig
import org.robok.engine.ui.screens.settings.SettingsScreen
import org.robok.engine.ui.screens.settings.app.SettingsAppScreen
import org.robok.engine.ui.screens.settings.editor.SettingsCodeEditorScreen
import org.robok.engine.ui.screens.settings.libraries.LibrariesScreen
import org.robok.engine.ui.screens.settings.about.AboutScreen
import org.robok.engine.ui.screens.settings.rdk.SettingsRDKScreen

@Composable
fun SettingsNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SettingsRoutes.Settings.route,
        enterTransition = AnimationTransitions.enterTransition,
        exitTransition = AnimationTransitions.exitTransition,
        popEnterTransition = AnimationTransitions.popEnterTransition,
        popExitTransition = AnimationTransitions.popExitTransition
    ) {
        composable(SettingsRoutes.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(SettingsRoutes.SettingsApp.route) {
            SettingsAppScreen(navController = navController)
        }
        composable(SettingsRoutes.SettingsCodeEditor.route) {
            SettingsCodeEditorScreen(navController = navController)
        }
        composable(SettingsRoutes.AboutLibraries.route) {
            LibrariesScreen(navController = navController)
        }
        composable(SettingsRoutes.SettingsRDK.route) {
            SettingsRDKScreen(navController = navController)
        }
        composable(SettingsRoutes.About.route) { 
            AboutScreen(
               navController = navController, 
               version = BuildConfig.VERSION_NAME
            ) 
        }
    }
}