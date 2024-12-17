package org.robok.engine.ui.screens.setup

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
 *   along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.components.Screen
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.screens.setup.components.BottomButtons
import org.robok.engine.ui.screens.setup.viewmodel.SetupDevelopmentEnvironmentViewModel

@Composable
fun SetupDevelopmentEnvironmentScreen(onBack: () -> Unit, onNext: () -> Unit) {
  val viewModel = koinViewModel<SetupDevelopmentEnvironmentViewModel>()
  val preferencesViewModel = koinViewModel<PreferencesViewModel>()
  
  Screen(
    label = stringResource(id = Strings.text_environment),
    backArrowVisible = false,
    bottomBar = {
      BottomButtons(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        onNext = {
          // todo
        },
        onBack = onBack,
      )
    },
  ) {
    DynamicSelectTextField(
      modifier = modifier,
      selectedValue = version,
      options = viewModel.versions,
      label = stringResource(id = Strings.settings_configure_rdk_version),
      onValueChangedEvent = { selectedVersion -> version = selectedVersion },
    )
  }
}
