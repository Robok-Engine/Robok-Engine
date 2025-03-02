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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.base.reloadTheme
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.switch.PreferenceSwitch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsAppScreen() {
  val preferencesViewModel: PreferencesViewModel = koinViewModel()
  Screen(label = stringResource(id = Strings.settings_app_title)) {
    PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
      AppearancePrefs(preferencesViewModel)
    }
  }
}

@Composable
fun AppearancePrefs(preferencesViewModel: PreferencesViewModel) {
  val context = LocalContext.current
  val appIsUseMonet by
    preferencesViewModel.appIsUseMonet.collectAsState(initial = DefaultValues.IS_USE_MONET)
  val appIsUseAmoled by
    preferencesViewModel.appIsUseAmoled.collectAsState(initial = DefaultValues.IS_USE_AMOLED)

  PreferenceSwitch(
    checked = appIsUseMonet,
    onCheckedChange = { newValue ->
      context.reloadTheme()
      preferencesViewModel.setMonetEnable(newValue)
    },
    title = stringResource(id = Strings.settings_app_use_monet_title),
    description = stringResource(id = Strings.settings_app_use_monet_description),
    enabled = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S,
  )
  PreferenceSwitch(
    checked = appIsUseAmoled,
    onCheckedChange = { newValue ->
      preferencesViewModel.setAmoledEnable(newValue)
      context.reloadTheme()
    },
    title = stringResource(id = Strings.settings_app_use_amoled_title),
    description = stringResource(id = Strings.settings_app_use_amoled_description),
  )
}
