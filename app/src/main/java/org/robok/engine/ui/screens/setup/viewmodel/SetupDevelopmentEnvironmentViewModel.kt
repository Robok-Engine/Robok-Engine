package org.robok.engine.ui.screens.setup.viewmodel

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.robok.engine.String
import org.robok.engine.core.utils.ZipDownloader
import org.robok.engine.ui.screens.setup.state.SetupDevelopmentEnvironmentViewModel
import org.robok.engine.ui.screens.settings.rdk.viewmodel.DownloadState
import kotlinx.coroutines.launch
import java.io.File

class SetupDevelopmentEnvironmentViewModel: ViewModel() {
  private var _uiState = mutableStateOf(SetupDevelopmentEnvironmentUIState())
  val uiState: SetupDevelopmentEnvironmentUIState
    get() = _uiState
  
  fun startAndroidSDKDownload(context: Context) {
    startDownload(
      context = context,
      zipUrl = Urls.ANDROID_SDK,
      outputDir = File(context.filesDir, "android-sdk"),
      state = uiState.androidSDKDownloadState
    )
  }
  
  private fun startDownload(
    context: Context,
    zipUrl: String,
    outputDir: File,
    downloadState: DownloadState
  ) {
    val zd = ZipDownloader(context)
    downloadState = DownloadState.Loading

    viewModelScope.launch {
      val result = zd.downloadAndExtractZip(zipUrl, outputDir)

      downloadState =
        if (result) {
          DownloadState.Success(context.getString(Strings.settings_configure_rdk_version_success))
        } else {
          DownloadState.Error(context.getString(Strings.settings_configure_rdk_version_error))
        }
    }
  }
  
  object Urls {
    const val ANDROID_SDK = "https://raw.githubusercontent.com/Robok-Engine/Robok-Libs/refs/heads/main/android.jar"
  }
}