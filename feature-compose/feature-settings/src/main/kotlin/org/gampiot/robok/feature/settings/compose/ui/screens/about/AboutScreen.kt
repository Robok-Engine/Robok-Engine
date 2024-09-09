package org.gampiot.robok.feature.settings.compose.screens.ui.about

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_about_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.text_contributors)) {
             
        }
    }
}