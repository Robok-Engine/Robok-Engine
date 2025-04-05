package org.robok.engine.ui.screens.settings.app.theme

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

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.screens.settings.app.theme.components.ColorChooser

@Composable
fun SettingsAppThemeColorsScreen() {
  val preferencesViewModel = koinViewModel<PreferencesViewModel>()
  Screen(label = stringResource(id = Strings.settings_app_theme_colors_title)) {
    ColorChooser(
      onChangeThemeSeedColor = { seed, paletteStyleIndex ->
        preferencesViewModel.setAppThemeSeedColor(seed)
        preferencesViewModel.setAppThemePaletteStyleIndex(paletteStyleIndex)
      },
      onChangeDynamicColors = { preferencesViewModel.setMonetEnable(it) },
    )
  }
}
