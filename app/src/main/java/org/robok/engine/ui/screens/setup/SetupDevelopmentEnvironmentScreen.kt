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

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.io.File
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.toast.LocalToastHostState
import org.robok.engine.ui.screens.setup.components.BottomButtons

@Composable
fun SetupDevelopmentEnvironmentScreen(onBack: () -> Unit, onNext: () -> Unit) {
  val modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)

  BackHandler { onBack() }
  Screen(
    label = stringResource(id = Strings.setup_development_environment_title),
    backArrowVisible = false,
    modifier = Modifier.systemBarsPadding(),
    bottomBar = {
      BottomButtons(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        onNext = {
          // check if tools are downloaded with success before go next
          onNext()
        },
        onBack = onBack,
      )
    },
  ) {
    // Soon Robok SDK Configuration
    PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
      Text(modifier = modifier, text = "Robok SDK is Still Under Development.")
    }
  }
}