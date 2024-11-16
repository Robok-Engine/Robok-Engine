package org.robok.engine.ui.screens.settings.rdk.viewmodel

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import org.robok.engine.strings.Strings
import org.robok.engine.core.utils.ZipDownloader
import org.robok.engine.ui.screens.settings.rdk.repository.SettingsRDKRepository

class SettingsRDKViewModel(
  private val repository: SettingsRDKRepository
) : ViewModel() {

  private var _downloadState by mutableStateOf<DownloadState>(DownloadState.NotStarted)
  val downloadState: DownloadState
    get() = _downloadState
    
  private var _versions by mutableStateOf<List<String>>(emptyList())
  val versions: List<String>
    get() = versions
  
  init {
    viewModelScope.launch {
      getVersions()
    }
  }
  
  fun startDownload(context: Context, zipUrl: String, outputDirName: String) {
    val zipDownloader = ZipDownloader(context)
    _downloadState = DownloadState.Loading

    viewModelScope.launch {
      val result = zipDownloader.downloadAndExtractZip(zipUrl, outputDirName)

      _downloadState = if (result) {
        DownloadState.Success(context.getString(Strings.settings_configure_rdk_version_success))
      } else {
        DownloadState.Error(context.getString(Strings.settings_configure_rdk_version_error))
      }
    }
  }
  
  private suspend fun getVersions() {
    repository.getVersions()
  }
}