package org.robok.engine.feature.settings.utils

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

import android.app.Activity
import android.content.Context
import android.widget.Toast
import android.os.Handler
import android.os.Looper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class ZipDownloader(private val context: Context) {

    suspend fun downloadAndExtractZip(zipUrl: String, outputDirName: String): Boolean = withContext(Dispatchers.IO) {
        val url = URL(zipUrl)
        val connection = url.openConnection() as HttpURLConnection

        try {
            connection.inputStream.use { inputStream ->
                val outputDir = File(context.filesDir, outputDirName)
                if (!outputDir.exists()) {
                    outputDir.mkdirs()
                }

                val zipFile = File(context.filesDir, "$outputDirName.zip")
                FileOutputStream(zipFile).use { fileOutputStream ->
                    inputStream.copyTo(fileOutputStream)
                }

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
                    newFile.parentFile.mkdirs()
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
