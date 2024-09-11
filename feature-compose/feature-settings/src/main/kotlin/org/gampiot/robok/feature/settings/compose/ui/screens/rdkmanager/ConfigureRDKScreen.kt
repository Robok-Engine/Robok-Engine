package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

import org.koin.androidx.compose.getViewModel
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
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.component.compose.textfields.DynamicSelectTextField
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigureRDKScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: ConfigureRDKViewModel = getViewModel { parametersOf(context) }
    
    var rdkVersions = listOf("RDK-1")
    val rdkVersionsState = remember { mutableStateOf<List<String>>(rdkVersions) }
    LaunchedEffect(Unit) {
        scope.launch {
            rdkVersions = fetchVersions()
            rdkVersionsState.value = rdkVersions
        }
    }
    var version by remember { mutableStateOf("RDK-1") }
    
    val zipUrl = "https://github.com/robok-inc/Robok-SDK/raw/dev/versions/$version/$version.zip"
    
    val downloadState by viewModel.downloadState.collectAsState()

    PreferenceLayout(
        label = stringResource(id = Strings.settings_configure_rdk_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
            DynamicSelectTextField(
                modifier = Modifier
                   .padding(horizontal = 18.dp, vertical = 8.dp),
                selectedValue = version,
                options = rdkVersions,
                label = stringResource(id = Strings.settings_configure_rdk_version),
                onValueChangedEvent = { selectedVersion ->
                    version = selectedVersion
                }
            )
            Button(
                modifier = Modifier
                   .padding(horizontal = 18.dp, vertical = 8.dp)
                   .fillMaxWidth(),
                onClick = {
                    viewModel.startDownload(zipUrl, version)
                }
            ) {
                Text(text = stringResource(id = Strings.common_word_save))
            }
        }
        when (downloadState) {
            is DownloadState.NotStarted -> Text("Download não iniciado")
            is DownloadState.Loading -> CircularProgressIndicator()
            is DownloadState.Success -> Text((downloadState as DownloadState.Success).message)
            is DownloadState.Error -> Text((downloadState as DownloadState.Error).error)
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
