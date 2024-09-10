package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class ZipDownloader(private val context: Context) {

    fun downloadAndExtractZip(zipUrl: String, outputDirName: String) {
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
