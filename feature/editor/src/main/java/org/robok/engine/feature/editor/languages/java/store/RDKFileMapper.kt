package org.robok.engine.feature.editor.languages.java.store

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

import android.content.Context
import dalvik.system.DexClassLoader
import dalvik.system.DexFile
import java.io.File

class RDKFileMapper(private val context: Context) {

  private val robokClasses: HashMap<String, String> = HashMap()
  private val actuallyRdk = "RDK-1"

  private val rdkDexDir: File = File(context.filesDir, "$actuallyRdk/dex/jar")

  init {
    mapRdkClasses()
  }

  fun getClasses(): HashMap<String, String> {
    return robokClasses
  }

  private fun mapRdkClasses() {
    val dexFile = File(rdkDexDir.absolutePath, "classes.dex")
    dexFile.setReadOnly()

    if (dexFile.exists()) {
      try {
        val dex = DexFile(dexFile.absolutePath)
        val entries = dex.entries()

        while (entries.hasMoreElements()) {
          val className = entries.nextElement()
          val simpleName = className.substringAfterLast(".")
          robokClasses[simpleName] = className
        }
      } catch (e: Exception) {
        println("Error reading dex file: ${e.message}")
      }
    } else {
      robokClasses["RDKNotExistsException"] = "robok.rdk.RDKNotExistsException"
    }
  }

  fun getDexClassLoader(): DexClassLoader {
    val dexFile = File(rdkDexDir, "classes.dex")
    if (!dexFile.exists()) {
      throw IllegalStateException("Dex file not found: ${dexFile.absolutePath}")
    }

    val optimizedDir = context.getDir("dex_opt", Context.MODE_PRIVATE)

    return DexClassLoader(
      dexFile.absolutePath,
      optimizedDir.absolutePath,
      null, // native libs dir, if needed
      context.classLoader,
    )
  }

  fun loadAllClasses(): HashMap<String, Class<*>> {
    val loadedClasses = HashMap<String, Class<*>>()
    val classLoader = getDexClassLoader()

    for ((simpleName, fullName) in robokClasses) {
      try {
        val clazz = classLoader.loadClass(fullName)
        loadedClasses[simpleName] = clazz
      } catch (e: ClassNotFoundException) {
        println("Class not found: $fullName")
      } catch (e: Exception) {
        println("Error loading class: $fullName - ${e.message}")
      }
    }

    return loadedClasses
  }
}
