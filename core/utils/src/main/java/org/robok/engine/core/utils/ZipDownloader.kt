package org.robok.engine.core.utils

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ZipDownloader(private val context: Context) {

  suspend fun downloadAndExtractZip(zipUrl: String, outputDir: File): Boolean =
    withContext(Dispatchers.IO) {
      val url = URL(zipUrl)
      val connection = url.openConnection() as HttpURLConnection

      try {
        connection.inputStream.use { inputStream ->
          if (!outputDir.exists()) {
            outputDir.mkdirs()
          }

          val zipFile = File(context.filesDir, "temp.zip")
          FileOutputStream(zipFile).use { fileOutputStream -> inputStream.copyTo(fileOutputStream) }

          extractZipFile(zipFile, outputDir)
        }
        true
      } catch (e: Exception) {
        e.printStackTrace()
        false
      } finally {
        connection.disconnect()
      }
    }

  private fun extractZipFile(zipFile: File, outputDir: File) {
    ZipInputStream(zipFile.inputStream()).use { zipInputStream ->
      var zipEntry: ZipEntry? = zipInputStream.nextEntry

      while (zipEntry != null) {
        val newFile = File(outputDir, zipEntry.name)
        if (zipEntry.isDirectory) {
          newFile.mkdirs()
        } else {
          newFile.parentFile?.mkdirs()
          FileOutputStream(newFile).use { fileOutputStream ->
            zipInputStream.copyTo(fileOutputStream)
          }
        }
        zipEntry = zipInputStream.nextEntry
      }
    }
    zipFile.delete()
  }
}
