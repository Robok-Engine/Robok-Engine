package org.gampiot.robok.ui.activities

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

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import soup.compose.material.motion.animation.materialSharedAxisXIn
import soup.compose.material.motion.animation.materialSharedAxisXOut

import org.gampiot.robok.BuildConfig
import org.gampiot.robok.Drawables
import org.gampiot.robok.ui.theme.RobokTheme
import org.gampiot.robok.models.project.ProjectTemplate
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.ui.screens.home.HomeScreen
import org.gampiot.robok.ui.screens.project.create.CreateProjectScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.SettingsScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.app.SettingsAppScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.editor.SettingsCodeEditorScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.libraries.LibrariesScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.about.AboutScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager.ConfigureRDKScreen

class MainActivity : ComponentActivity() {

    companion object {
        const val MSAX_SLIDE_DISTANCE: Int = 100
        const val MSAX_DURATION: Int = 700
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val defaultTemplate = ProjectTemplate(
               name = getString(Strings.template_name_empty_game),
               packageName = "com.robok.empty",
               zipFileName = "empty_game.zip",
               javaSupport = true,
               kotlinSupport = false,
               imageResId = Drawables.ic_empty_game
        )
        setContent {
            RobokTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    enterTransition = { materialSharedAxisXIn(forward = true, slideDistance = MSAX_SLIDE_DISTANCE, durationMillis = MSAX_DURATION) },
                    exitTransition = { materialSharedAxisXOut(forward = true, slideDistance = MSAX_SLIDE_DISTANCE, durationMillis = MSAX_DURATION) },
                    popEnterTransition = { materialSharedAxisXIn(forward = false, slideDistance = MSAX_SLIDE_DISTANCE, durationMillis = MSAX_DURATION) },
                    popExitTransition = { materialSharedAxisXOut(forward = false, slideDistance = MSAX_SLIDE_DISTANCE, durationMillis = MSAX_DURATION)  }
                ) {
                    composable("home") { HomeScreen(navController = navController, actContext = this@MainActivity) }
                    composable("settings") { SettingsScreen(navController = navController) }
                    composable("settings/app") { SettingsAppScreen(navController = navController) }
                    composable("settings/codeeditor") { SettingsCodeEditorScreen(navController = navController) }
                    composable("settings/libraries") { LibrariesScreen(navController = navController) }
                    composable("settings/configure_rdk") { ConfigureRDKScreen(navController = navController) }
                    composable("settings/about") { AboutScreen(navController = navController, version = BuildConfig.VERSION_NAME) }
                    composable("project/create") { CreateProjectScreen(navController = navController, projectTemplate = defaultTemplate) }
                }
            }
        }
    }
}