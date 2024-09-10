package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import soup.compose.material.motion.animation.materialSharedAxisXIn
import soup.compose.material.motion.animation.materialSharedAxisXOut

import org.gampiot.robok.BuildConfig
import org.gampiot.robok.ui.theme.RobokTheme
import org.gampiot.robok.feature.settings.compose.screens.ui.SettingsScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.editor.SettingsCodeEditorScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.libraries.LibrariesScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.about.AboutScreen
import org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager.ConfigureRDKScreen

class SettingsActivity : ComponentActivity() {

    companion object {
         const val MSAX_SLIDE_DISTANCE: Int = 100
         const val MSAX_DURATION: Int = 500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RobokTheme() {
                 val navController = rememberNavController()
                 NavHost(
                     navController = navController,
                     startDestination = "settings",
                     enterTransition = { 
                          materialSharedAxisXIn(
                              forward = true, 
                              slideDistance = MSAX_SLIDE_DISTANCE,
                              durationMillis = MSAX_DURATION
                          ) 
                     },
                     exitTransition = { 
                          materialSharedAxisXOut(
                              forward = true, 
                              slideDistance = MSAX_SLIDE_DISTANCE,
                              durationMillis = MSAX_DURATION
                          ) 
                     },
                     popEnterTransition = { 
                          materialSharedAxisXIn(
                              forward = false, 
                              slideDistance = MSAX_SLIDE_DISTANCE,
                              durationMillis = MSAX_DURATION
                          ) 
                     },
                     popExitTransition = { 
                          materialSharedAxisXOut(
                              forward = false,
                              slideDistance = MSAX_SLIDE_DISTANCE,
                              durationMillis = MSAX_DURATION
                          ) 
                     }
                 ) {
                      composable("settings") {
                           SettingsScreen(navController)
                      }
                      
                      composable("settings/codeeditor") {
                           SettingsCodeEditorScreen(navController)
                      }
                      
                      composable("settings/libraries") {
                           LibrariesScreen(navController)
                      }
                      
                      composable("settings/configure_rdk") {
                           ConfigureRDKScreen(navController)
                      }
                      
                      composable("settings/about") {
                           AboutScreen(
                               navController = navController,
                               version = BuildConfig.VERSION_NAME
                           )
                      }
                 }
            }
        }
    }
}
