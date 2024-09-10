package org.gampiot.robok.feature.settings.compose.viewmodels

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import org.gampiot.robok.feature.settings.compose.utils.ZipDownloader

class ConfigureRDKViewModel(private val context: Context) : ViewModel() {

    private val zipDownloader = ZipDownloader(context)

    fun startDownload(zipUrl: String, outputDirName: String) {
        viewModelScope.launch {
            zipDownloader.downloadAndExtractZip(zipUrl, outputDirName)
        }
    }
}
