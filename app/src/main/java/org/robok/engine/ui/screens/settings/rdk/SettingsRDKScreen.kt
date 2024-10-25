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
import org.robok.engine.core.components.textfields.DynamicSelectTextField
import org.robok.engine.feature.settings.DefaultValues
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.settings.rdk.viewmodel.SettingsRDKViewModel
import org.robok.engine.ui.screens.settings.rdk.viewmodel.SettingsRDKViewModel.DownloadState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsRDKScreen() {
    val context = LocalContext.current
    val viewModel: SettingsRDKViewModel = koinViewModel { parametersOf(context) }
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    val installedRDKVersion by
        appPrefsViewModel.installedRDKVersion.collectAsState(
            initial = DefaultValues.INSTALLED_RDK_VERSION
        )

    var rdkVersions = listOf("RDK-1")
    val rdkVersionsState = remember { mutableStateOf<List<String>>(rdkVersions) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            rdkVersions = fetchVersions()
            rdkVersionsState.value = rdkVersions
        }
    }
    var version by remember { mutableStateOf(installedRDKVersion) }

    val zipUrl = "https://github.com/robok-engine/Robok-SDK/raw/dev/versions/$version/$version.zip"

    val downloadState by viewModel.downloadState.collectAsState()
    val modifir = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
    Screen(label = stringResource(id = Strings.settings_configure_rdk_title)) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
            DynamicSelectTextField(
                modifier = modifir,
                selectedValue = version,
                options = rdkVersions,
                label = stringResource(id = Strings.settings_configure_rdk_version),
                onValueChangedEvent = { selectedVersion -> version = selectedVersion },
            )
            Button(
                modifier = modifir.fillMaxWidth(),
                onClick = {
                    appPrefsViewModel.changeInstalledRDK(version)
                    viewModel.startDownload(zipUrl, version)
                },
            ) {
                Text(text = stringResource(id = Strings.common_word_save))
            }
            when (downloadState) {
                is DownloadState.NotStarted ->
                    Text(modifier = modifir, text = "Download não iniciado")
                is DownloadState.Loading -> CircularProgressIndicator(modifier = modifir)
                is DownloadState.Success ->
                    Text(
                        modifier = modifir,
                        text = (downloadState as DownloadState.Success).message,
                    )
                is DownloadState.Error ->
                    Text(modifier = modifir, text = (downloadState as DownloadState.Error).error)
            }
        }
    }
}

@Serializable data class VersionInfo(val version: String)

val client = OkHttpClient()

suspend fun fetchVersions(): List<String> {
    val request =
        Request.Builder()
            .url("https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/versions.json")
            .build()

    return withContext(Dispatchers.IO) {
        try {
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val jsonString = response.body?.string()
                    jsonString?.let {
                        val versions = Json.decodeFromString<List<VersionInfo>>(it)
                        versions.map { versionInfo -> versionInfo.version }
                    } ?: emptyList()
                } else {
                    emptyList()
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
