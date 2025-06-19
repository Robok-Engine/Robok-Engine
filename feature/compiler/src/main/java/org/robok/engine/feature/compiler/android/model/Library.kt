package org.robok.engine.feature.compiler.android.model

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

import java.io.File
import java.util.regex.Pattern
import org.robok.engine.core.utils.FileUtil

data class Library(private val path: File) {
  private val libraryName: String = path.name
  private val packagePattern = Pattern.compile("(package\\=\".*\")")

  constructor(path: String) : this(File(path))

  companion object {
    fun fromFile(file: File): MutableList<Library> {
      val libraries = mutableListOf<Library>()

      if (!file.exists()) return libraries

      val children = file.listFiles() ?: return libraries

      for (child in children) {
        if (File(child, "classes.jar").exists()) {
          libraries.add(Library(child.absolutePath))
        }
      }
      return libraries
    }
  }

  fun getPath(): File = path

  fun getName(): String = libraryName

  fun getResourcesFile(): File = File(path, "res")

  fun getClassJarFile(): File = File(path, "classes.jar")

  fun getDexFiles(): List<File> {
    val files = mutableListOf<File>()
    val fileArray = path.listFiles() ?: return files

    for (file in fileArray) {
      if (file.name.endsWith(".dex")) {
        files.add(file)
      }
    }
    return files
  }

  fun requiresResourceFile(): Boolean = File(path, "res").exists()

  fun getPackageName(): String? {
    val manifest = FileUtil.readFile("${path.absolutePath}/AndroidManifest.xml")
    val matcher = packagePattern.matcher(manifest)

    return if (matcher.find()) {
      matcher.group(1)?.substring(9, matcher.group(1).length - 1)
    } else {
      null
    }
  }
}
