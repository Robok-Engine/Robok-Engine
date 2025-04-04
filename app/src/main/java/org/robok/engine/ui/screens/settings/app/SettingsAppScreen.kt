package org.robok.engine.ui.screens.settings.app

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

import android.os.Build
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.navigation.routes.Route
import org.robok.engine.navigation.routes.SettingsAppThemeColorsRoute
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.normal.Preference
import org.robok.engine.ui.core.components.preferences.switch.PreferenceSwitch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsAppScreen(onNavigate: (Route) -> Unit) {
  val preferencesViewModel: PreferencesViewModel = koinViewModel()
  Screen(label = stringResource(id = Strings.settings_app_title)) {
    PreferenceGroup(heading = stringResource(id = Strings.settings_appearance_title)) {
      AppearancePreference(preferencesViewModel = preferencesViewModel, onNavigate = onNavigate)
    }
  }
}

@Composable
private fun AppearancePreference(
  preferencesViewModel: PreferencesViewModel,
  onNavigate: (Route) -> Unit,
) {
  val appIsUseMonet by
    preferencesViewModel.appIsUseMonet.collectAsState(initial = DefaultValues.IS_USE_MONET)
  val appIsUseAmoled by
    preferencesViewModel.appIsUseAmoled.collectAsState(initial = DefaultValues.IS_USE_AMOLED)

  Preference(
    title = { Text(text = stringResource(id = Strings.settings_app_theme_colors_title)) },
    description = {
      Text(text = stringResource(id = Strings.settings_app_theme_colors_description))
    },
    onClick = { onNavigate(SettingsAppThemeColorsRoute) },
  )

  PreferenceSwitch(
    checked = appIsUseMonet,
    onCheckedChange = { newValue ->
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
    },
    title = stringResource(id = Strings.settings_app_use_amoled_title),
    description = stringResource(id = Strings.settings_app_use_amoled_description),
  )
}
