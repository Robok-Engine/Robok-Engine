package org.gampiot.robok.feature.settings.compose.viewmodels

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
