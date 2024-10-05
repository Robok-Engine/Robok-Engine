package org.robok.engine.ui.screens.settings.app

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

import android.os.Build
import android.content.Context

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import org.koin.androidx.compose.koinViewModel

import org.robok.engine.core.components.compose.preferences.switch.PreferenceSwitch
import org.robok.engine.core.components.compose.preferences.base.PreferenceLayout
import org.robok.engine.core.components.compose.preferences.base.PreferenceGroup
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsAppScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    PreferenceLayout(
        label = stringResource(id = Strings.settings_app_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
            appearancePrefs(appPrefsViewModel)
        }
    }
}

@Composable
fun appearancePrefs(
    appPrefsViewModel: AppPreferencesViewModel
) {
     val appIsUseMonet by appPrefsViewModel.appIsUseMonet.collectAsState(initial = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) true else false)
     PreferenceSwitch(
          checked = appIsUseMonet,
          onCheckedChange = { newValue ->
              appPrefsViewModel.enableMonet(newValue)
          },
          label = stringResource(id = Strings.settings_app_use_monet_title),
          description = stringResource(id = Strings.settings_app_use_monet_description),
          enabled = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) true else false
     )
}