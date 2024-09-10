package org.gampiot.robok.feature.settings.compose.viewmodels

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import org.gampiot.robok.feature.settings.compose.utils.ZipDownloader

class ConfigureRDKViewModel(private val context: Context) : ViewModel() {

    private val zipDownloader = ZipDownloader(context)

private val _downloadState = MutableStateFlow<DownloadState>(DownloadState.NotStarted)
    val downloadState: StateFlow<DownloadState> = _downloadState

    fun startDownload(zipUrl: String, outputDirName: String) {
        _downloadState.value = DownloadState.Loading 
        
        viewModelScope.launch {
            val result = zipDownloader.downloadAndExtractZip(zipUrl, outputDirName)

            if (result) {
                _downloadState.value = DownloadState.Success("Download e extração concluídos com sucesso!")
            } else {
                _downloadState.value = DownloadState.Error("Erro durante o download ou extração do arquivo.")
            }
        }
    }
}
