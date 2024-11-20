package org.robok.engine.manage.project.styles

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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */
 
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.robok.engine.core.utils.ZipDownloader
import org.robok.engine.core.utils.RobokLog
import java.io.File

class StylesDownloader(
  private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
) {

  fun startDownload(
    context: Context, 
    type: Type,
    outputDir: String,
    onResult: (Boolean) -> Unit
  ) {
    val zipDownloader = ZipDownloader(context)
    val url = getUrlForType(type)

    coroutineScope.launch {
      val success = downloadAndExtract(zipDownloader, url, outputDir)
      onResult(success)
    }
  }

  private suspend fun downloadAndExtract(
    zipDownloader: ZipDownloader,
    zipUrl: String,
    outputDir: String
  ): Boolean {
    return try {
      zipDownloader.downloadAndExtractZip(zipUrl, File(outputDir))
      true
    } catch (e: Exception) {
      RobokLog.e("StylesDownloader", "Error trying to download and extract ZIP file: ${e.message}")
      false
    }
  }

  private fun getUrlForType(type: Type): String {
    return when (type) {
      Type.DEFAULT -> StylesUrls.DEFAULT
    }
  }

  private object StylesUrls {
    const val DEFAULT = "https://github.com/Robok-Engine/Robok-GUI-Styles/raw/refs/heads/main/default_style.zip"
  }

  enum class Type {
    DEFAULT;
  }
}