package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import okhttp3.OkHttpClient
import okhttp3.Request

import org.gampiot.robok.feature.settings.compose.viewmodels.ConfigureRDKViewModel
import org.gampiot.robok.feature.settings.compose.viewmodels.DownloadState
import org.gampiot.robok.core.components.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.core.components.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.core.components.compose.textfields.DynamicSelectTextField
import org.gampiot.robok.core.components.compose.text.RobokText
import org.gampiot.robok.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigureRDKScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: ConfigureRDKViewModel = koinViewModel { parametersOf(context) }
    
    var rdkVersions = listOf("RDK-1")
    val rdkVersionsState = remember { mutableStateOf<List<String>>(rdkVersions) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            rdkVersions = fetchVersions()
            rdkVersionsState.value = rdkVersions
        }
    }
    var version by remember { mutableStateOf("RDK-1") }
    
    val zipUrl = "https://github.com/robok-inc/Robok-SDK/raw/dev/versions/$version/$version.zip"
    
    val downloadState by viewModel.downloadState.collectAsState()
    val modifir = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
    PreferenceLayout(
        label = stringResource(id = Strings.settings_configure_rdk_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
            DynamicSelectTextField(
                modifier = modifir,
                selectedValue = version,
                options = rdkVersions,
                label = stringResource(id = Strings.settings_configure_rdk_version),
                onValueChangedEvent = { selectedVersion ->
                    version = selectedVersion
                }
            )
            Button(
                modifier = modifir
                   .fillMaxWidth(),
                onClick = {
                    viewModel.startDownload(zipUrl, version)
                }
            ) {
                RobokText(text = stringResource(id = Strings.common_word_save))
            }
            when (downloadState) {
                 is DownloadState.NotStarted -> RobokText(modifier = modifir, text = "Download não iniciado")
                 is DownloadState.Loading -> CircularProgressIndicator(modifier = modifir)
                 is DownloadState.Success -> RobokText(modifier = modifir, text = (downloadState as DownloadState.Success).message)
                 is DownloadState.Error -> RobokText(modifier = modifir, text = (downloadState as DownloadState.Error).error)
            }
        }
    }
}

@Serializable
data class VersionInfo(val version: String)

val client = OkHttpClient()

suspend fun fetchVersions(): List<String> {
    val request = Request.Builder()
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
