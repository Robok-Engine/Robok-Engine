package org.robok.engine.ui.screens.settings.rdk

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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.shape.ButtonShape
import org.robok.engine.core.components.textfields.DynamicSelectTextField
import org.robok.engine.feature.settings.DefaultValues
import org.robok.engine.feature.settings.viewmodels.PreferencesViewModel
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.settings.rdk.viewmodel.SettingsRDKViewModel
import org.robok.engine.ui.screens.settings.rdk.viewmodel.DownloadState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsRDKScreen() {
  val context = LocalContext.current
  val viewModel: SettingsRDKViewModel = koinViewModel { parametersOf(context) }
  val appPrefsViewModel = koinViewModel<PreferencesViewModel>()

  val installedRDKVersion by appPrefsViewModel.installedRDKVersion.collectAsState(
    initial = DefaultValues.INSTALLED_RDK_VERSION
  )

  var version by remember { mutableStateOf(installedRDKVersion) }

  val zipUrl = "https://github.com/robok-engine/Robok-SDK/raw/dev/versions/$version/$version.zip"
  val downloadState = viewModel.downloadState
  val modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)

  Screen(label = stringResource(id = Strings.settings_configure_rdk_title)) {
    PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
      DynamicSelectTextField(
        modifier = modifier,
        selectedValue = version,
        options = viewModel.versions,
        label = stringResource(id = Strings.settings_configure_rdk_version),
        onValueChangedEvent = { selectedVersion -> version = selectedVersion },
      )
      DownloadStateContent(
        modifier = modifier,
        downloadState = downloadState,
        onSaveClick = {
          appPrefsViewModel.changeInstalledRDK(version)
          viewModel.startDownload(zipUrl, version)
        }
      )
    }
  }
}

@Composable
private fun DownloadStateContent(
  modifier: Modifier,
  downloadState: DownloadState,
  onSaveClick: () -> Unit
) {
  when (downloadState) {
    is DownloadState.NotStarted -> {
      Button(
        modifier = modifier.fillMaxWidth(),
        shape = ButtonShape(),
        onClick = onSaveClick,
      ) {
        Text(text = stringResource(id = Strings.common_word_save))
      }
    }
    is DownloadState.Loading -> CircularProgressIndicator(modifier = modifier)
    is DownloadState.Success ->
      Text(modifier = modifier, text = (downloadState as DownloadState.Success).message)
    is DownloadState.Error ->
      Text(modifier = modifier, text = (downloadState as DownloadState.Error).error)
  }
}