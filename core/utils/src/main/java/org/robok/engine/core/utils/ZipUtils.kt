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

/*
  Class to help with zip management.
  @author Aquiles Trindade.
*/

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

fun extractZipFromAssets(context: Context, assetFileName: String, outputDir: File) {
  val inputStream: InputStream = context.assets.open(assetFileName)
  ZipInputStream(inputStream).use { zipInputStream ->
    var zipEntry: ZipEntry? = zipInputStream.nextEntry
    while (zipEntry != null) {
      val newFile = File(outputDir, zipEntry.name)
      if (zipEntry.isDirectory) {
        newFile.mkdirs()
      } else {
        newFile?.parentFile?.mkdirs()
        FileOutputStream(newFile).use { fos -> zipInputStream.copyTo(fos) }
      }
      zipInputStream.closeEntry()
      zipEntry = zipInputStream.nextEntry
    }
  }
}
