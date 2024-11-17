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
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import android.os.Environment
import dalvik.system.DexFile
import dalvik.system.DexClassLoader

class RDKFileMapper(private val context: Context) {

    private val robokClasses: HashMap<String, String> = HashMap()
    private val actuallyRdk = "RDK-1"

    // Diretório contendo o arquivo .dex ou .jar
    private val rdkDirectory: File = File(
        Environment.getExternalStorageDirectory(), "$actuallyRdk/dex/"
    )

    init {
        mapRdkClasses()
    }

    fun getClasses(): HashMap<String, String> {
        return robokClasses
    }

    

private fun mapRdkClasses() {
    val rdkFolder = rdkDirectory
    val dexFile = File(rdkFolder, "classes.dex") // Ou o caminho para seu arquivo .dex

    if (dexFile.exists()) {
        try {
            val dex = DexFile(dexFile.absolutePath)
            val entries = dex.entries()

            // Preenche o HashMap com as classes encontradas no arquivo .dex
            while (entries.hasMoreElements()) {
                val className = entries.nextElement()
                val simpleName = className.substringAfterLast(".")
                robokClasses[simpleName] = className
                //robokClasses[className] = className
            }
        } catch (e: Exception) {
            println("Error reading dex file: ${e.message}")
        }
    } else {
        robokClasses["RDKNotExistsException"] = "robok.rdk.RDKNotExistsException"
    }
}

    fun getDexClassLoader(): DexClassLoader {
        // Arquivo .dex ou .jar que será carregado
        val dexFile = File(rdkDirectory, "classes.dex") // ou um .jar compilado
        if (!dexFile.exists()) {
            throw IllegalStateException("Dex file not found: ${dexFile.absolutePath}")
        }

        // Diretório para arquivos temporários de otimização
        val optimizedDir = context.getDir("dex_opt", Context.MODE_PRIVATE)

        // Inicializa o DexClassLoader
        return DexClassLoader(
            dexFile.absolutePath, // Caminho do arquivo .dex ou .jar
            optimizedDir.absolutePath, // Caminho para arquivos otimizados
            null, // Caminho para bibliotecas nativas, se necessário
            context.classLoader // ClassLoader pai
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