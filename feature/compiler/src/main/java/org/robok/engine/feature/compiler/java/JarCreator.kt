package org.robok.engine.feature.compiler.java

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

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.jar.Attributes
import java.util.jar.JarEntry
import java.util.jar.JarOutputStream
import java.util.jar.Manifest

/**
 * Basic .jar creator
 *
 * @author Aquiles Trindade (trindadedev)
 */
class JarCreator(
  private val input: String,
  private val output: String,
  private val attributes: Attributes = getDefaultAttributes(),
) {

  init {
    require(input.isNotBlank() && output.isNotBlank()) {
      "Input and output paths must be non-null and non-empty."
    }
  }

  companion object {
    private fun getDefaultAttributes(): Attributes {
      return Attributes().apply { put(Attributes.Name("Created-By"), "Sparkles IDE") }
    }
  }

  @Throws(IOException::class)
  fun create() {
    val classesFile = File(input)
    require(classesFile.exists() && classesFile.isDirectory) {
      "Input path must be a valid directory."
    }

    FileOutputStream(File(output)).use { fileOutputStream ->
      JarOutputStream(fileOutputStream, createManifest(attributes)).use { jarOutputStream ->
        classesFile.listFiles()?.forEach { file ->
          addFileToJar(classesFile.path, file, jarOutputStream)
        }
      }
    }
  }

  private fun createManifest(options: Attributes): Manifest {
    return Manifest().apply {
      mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
      mainAttributes.putAll(options)
    }
  }

  private fun addFileToJar(parentPath: String, source: File, target: JarOutputStream) {
    val name = source.path.substring(parentPath.length + 1).replace("\\", "/")
    if (source.isDirectory) {
      handleDirectory(name, source, target, parentPath)
    } else {
      handleFile(name, source, target)
    }
  }

  private fun handleDirectory(
    name: String,
    source: File,
    target: JarOutputStream,
    parentPath: String,
  ) {
    var dirName = name
    if (dirName.isNotEmpty() && !dirName.endsWith("/")) {
      dirName += "/"
    }
    val entry = JarEntry(dirName).apply { time = source.lastModified() }
    target.putNextEntry(entry)
    target.closeEntry()
    source.listFiles()?.forEach { nestedFile -> addFileToJar(parentPath, nestedFile, target) }
  }

  private fun handleFile(name: String, source: File, target: JarOutputStream) {
    val entry = JarEntry(name).apply { time = source.lastModified() }
    target.putNextEntry(entry)
    BufferedInputStream(FileInputStream(source)).use { input ->
      val buffer = ByteArray(1024)
      var count: Int
      while (input.read(buffer).also { count = it } != -1) {
        target.write(buffer, 0, count)
      }
    }
    target.closeEntry()
  }
}
