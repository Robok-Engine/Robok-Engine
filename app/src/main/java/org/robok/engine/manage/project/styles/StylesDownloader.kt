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
import java.io.File
import org.robok.engine.core.utils.Log
import org.robok.engine.core.utils.ZipDownloader

/** All types of styles. */
enum class StyleType {
  DEFAULT // Default Robok Style.
}

/** Download styles by type. */
class StylesDownloader {

  /**
   * Starts the style download.
   *
   * @param context The android context to be used.
   * @param type The style to be downloaded.
   * @param outputDir where style will be downloaded.
   * @param onResult Lambda called when successfully downloaded.
   */
  suspend fun startDownload(
    context: Context,
    type: StyleType,
    outputDir: String,
    onResult: (Boolean) -> Unit,
  ) {
    val zipDownloader = ZipDownloader(context)
    val url = getUrlForType(type)
    val success = downloadAndExtract(zipDownloader, url, outputDir)
    onResult(success)
  }

  /**
   * Basic helper to download & extract zip with ZipDownloader.
   *
   * @param zipDownloader The Configure instance of zipDownloader
   * @param zipUrl The url to be downloaded.
   * @param outputDir where zip will be downloaded.
   */
  private suspend fun downloadAndExtract(
    zipDownloader: ZipDownloader,
    zipUrl: String,
    outputDir: String,
  ): Boolean {
    return try {
      zipDownloader.downloadAndExtractZip(zipUrl, File(outputDir))
      true
    } catch (e: Exception) {
      Log.e("StylesDownloader", "Error trying to download and extract ZIP file: ${e.message}")
      false
    }
  }

  /**
   * Returns an URL based on StyleType.
   *
   * @param type The style type requested
   */
  private fun getUrlForType(type: StyleType): String {
    val styleName =
      when (type) {
        StyleType.DEFAULT -> Styles.DEFAULT
        else -> "Unknow"
      }
    return Styles.BASE_URL + styleName
  }

  /** All Styles. used in download. */
  private object Styles {
    const val BASE_URL = "https://github.com/Robok-Engine/Robok-GUI-Styles/raw/refs/heads/main/"
    const val DEFAULT = "default_style.zip"
  }
}
