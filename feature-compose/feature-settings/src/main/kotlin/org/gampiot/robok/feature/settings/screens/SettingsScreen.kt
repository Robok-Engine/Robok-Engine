package org.gampiot.robok.feature.settings.screens

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Settings
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.component.ApplicationScreen
import org.gampiot.robok.feature.component.appbars.TopBar
import org.gampiot.robok.feature.component.Title
import org.gampiot.robok.feature.component.preferences.PreferenceItem
import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    val appPrefsViewModel = viewModel<AppPreferencesViewModel>()
    val editorTheme by appPrefsViewModel.editorTheme.collectAsState(initial = 0)
    
    val context = LocalContext.current
    
    val defaultModifier = Modifier.fillMaxWidth()
    
    ApplicationScreen(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        topBar = {
            TopBar(
                barTitle = stringResource(id = Strings.settings_label),
                scrollBehavior = it,
                onClickBackButton = {
                    navController.popBackStack()
                }
            )
        },
        content = {
                Title(title = stringResource(id = Strings.appearance_label))
                PreferenceItem (
                     title = stringResource(id = Strings.settings_editor_title),
                     description = stringResource(id = Strings.settings_editor_description),
                     showToggle = false,
                     onClick = {}
                )
                Title(title = stringResource(id = Strings.about_label))
                PreferenceItem (
                     title = stringResource(id = Strings.libraries_label),
                     description = stringResource(id = Strings.libraries_description),
                     onClick = {
                         navController.navigate("settings/libraries")
                     }
                )
        }
    )
}