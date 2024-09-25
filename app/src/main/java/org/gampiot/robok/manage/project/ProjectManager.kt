package org.gampiot.robok.manage.project

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
import android.os.Environment

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import org.gampiot.robok.feature.component.terminal.RobokTerminalWithRecycler
import org.gampiot.robok.feature.template.code.android.game.logic.GameScreenLogicTemplate
import org.gampiot.robok.models.project.ProjectTemplate

import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

import org.robok.aapt2.compiler.CompilerTask
import org.robok.aapt2.model.Project
import org.robok.aapt2.model.Library
import org.robok.aapt2.logger.Logger
import org.robok.aapt2.SystemLogPrinter

sealed class ProjectCreationResult {
    object Success : ProjectCreationResult()
    data class Error(val exception: Exception) : ProjectCreationResult()
}

sealed class BuildResult {
    object Success : BuildResult()
    data class Error(val exception: Exception) : BuildResult()
}

class ProjectManager(private val context: Context) {

    private var outputPath: File? = null

    fun setProjectPath(value: File) {
        outputPath = value
    }

    fun getProjectPath(): File? {
        return outputPath
    }

    suspend fun create(projectName: String, packageName: String, template: ProjectTemplate): ProjectCreationResult {
        return withContext(Dispatchers.IO) {
            try {
                val zipFileInputStream = context.assets.open(template.zipFileName)
                val projectDir = outputPath ?: throw IllegalStateException("Project path not set")

                if (!projectDir.exists()) {
                    projectDir.mkdirs()
                }

                unzipAssets(zipFileInputStream, projectDir, projectName, packageName)
                createJavaClass(projectName, packageName, projectDir)

                ProjectCreationResult.Success
            } catch (e: Exception) {
                ProjectCreationResult.Error(e)
            }
        }
    }

    private fun unzipAssets(zipFileInputStream: InputStream, projectDir: File, projectName: String, packageName: String) {
        ZipInputStream(BufferedInputStream(zipFileInputStream)).use { zipInputStream ->
            var zipEntry: ZipEntry?

            while (zipInputStream.nextEntry.also { zipEntry = it } != null) {
                zipEntry?.let {
                    if (!it.isDirectory) {
                        val outputFileName = generateOutputFileName(it.name, projectName, packageName)
                        val outputFile = File(projectDir, outputFileName)

                        outputFile.parentFile?.mkdirs()
                        FileOutputStream(outputFile).use { fos ->
                            zipInputStream.copyTo(fos)
                        }
                    }
                    zipInputStream.closeEntry()
                }
            }
        }
    }

    private fun generateOutputFileName(entryName: String, projectName: String, packageName: String): String {
        return entryName
            .replace("project_template_name", projectName)
            .replace("game/logic/\$pkgName", "game/logic/${packageName.replace('.', '/')}")
    }

    private fun createJavaClass(projectName: String, packageName: String, projectDir: File) {
        val template = GameScreenLogicTemplate().apply {
            setCodeClassName("MainScreen")
            setCodeClassPackageName(packageName)
            configure()
        }

        val classFilePath = "game/logic/${packageName.replace('.', '/')}/${template.getCodeClassName()}.java"
        val javaFile = File(projectDir, classFilePath)

        javaFile.parentFile?.mkdirs()
        FileOutputStream(javaFile).use { fos ->
            fos.write(template.getCodeClassContent()?.toByteArray() ?: ByteArray(0))
        }
    }

    suspend fun build(): BuildResult {
        return withContext(Dispatchers.IO) {
            try {
                val projectPath = getProjectPath()?.absolutePath ?: throw IllegalStateException("Project path not set")
                val project = Project().apply {
                    setLibraries(Library.fromFile(File("")))
                    setResourcesFile(File("$projectPath/game/res/"))
                    setOutputFile(File("$projectPath/build/"))
                    setJavaFile(File("$projectPath/game/logic/"))
                    setManifestFile(File("$projectPath/game/AndroidManifest.xml"))
                    setMinSdk(21)
                    setTargetSdk(28)
                }

                val terminal = RobokTerminalWithRecycler(context)
                val logger = Logger().also {
                    it.attach(terminal.getRecyclerView())
                    SystemLogPrinter.start(it)
                }

                project.setLogger(logger)

                val task = CompilerTask(context)
                task.execute(project)

                terminal.show()

                BuildResult.Success
            } catch (e: Exception) {
                BuildResult.Error(e)
            }
        }
    }
}