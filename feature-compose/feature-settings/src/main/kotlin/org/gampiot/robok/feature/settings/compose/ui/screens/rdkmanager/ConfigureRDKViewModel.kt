package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class ConfigureRDKViewModel(private val context: Context) : ViewModel() {

    private val zipDownloader = ZipDownloader(context)

    fun startDownload(zipUrl: String, outputDirName: String) {
        viewModelScope.launch {
            zipDownloader.downloadAndExtractZip(zipUrl, outputDirName)
        }
    }
}
