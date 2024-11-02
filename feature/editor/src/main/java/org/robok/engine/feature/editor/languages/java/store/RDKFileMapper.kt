package org.robok.engine.feature.editor.languages.java.store;

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
import java.io.File
import java.net.URL
import java.net.URLClassLoader

class RDKFileMapper(private val context: Context) {

    private val robokClasses: HashMap<String, String> = HashMap()
    private val actuallyRdk = "RDK-1"
    private val rdkDirectory: File = File(context.filesDir, "$actuallyRdk/rdk/")

    init {
        mapRdkClasses()
    }

    fun getClasses(): HashMap<String, String> {
        return robokClasses
    }

    private fun mapRdkClasses() {
        val rdkFolder = rdkDirectory

        if (rdkFolder.exists() && rdkFolder.isDirectory) {
            mapClassesRecursively(rdkFolder, "")
        } else {
            robokClasses["RDKNotExistsException"] = "robok.rdk.RDKNotExistsException"
        }
    }

    private fun mapClassesRecursively(folder: File, packageName: String) {
        val files = folder.listFiles() ?: return

        for (file in files) {
            if (file.isDirectory) {
                val newPackageName = if (packageName.isEmpty()) file.name else "$packageName.${file.name}"
                mapClassesRecursively(file, newPackageName)
            } else if (file.name.endsWith(".class")) {
                val className = file.name.removeSuffix(".class")
                val classPath = "$packageName.$className"
                robokClasses[className] = classPath
            }
        }
    }

    fun getClassLoader(): URLClassLoader {
        val url: URL = rdkDirectory.toURI().toURL()
        val urls = arrayOf(url)

        return URLClassLoader(urls)
    }
}