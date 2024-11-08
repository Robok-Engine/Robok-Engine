package org.robok.engine.feature.compiler.android.model;

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

import java.io.File
import java.util.regex.Pattern
import org.robok.engine.core.utils.FileUtil

data class Library(
  private val path: File
) {
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