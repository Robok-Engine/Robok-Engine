package org.robok.engine.manage.project

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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Context
import android.os.Environment
import java.io.BufferedInputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.android.ext.android.getKoin
import org.robok.engine.RobokApplication
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.Log
import org.robok.engine.core.utils.extractZipFromAssets
import org.robok.engine.core.utils.isValidPath
import org.robok.engine.feature.compiler.android.CompilerTask
import org.robok.engine.feature.compiler.android.SystemLogPrinter
import org.robok.engine.feature.compiler.android.logger.LoggerViewModel
import org.robok.engine.feature.compiler.android.model.Library
import org.robok.engine.feature.compiler.android.model.Project as CompilerProject
import org.robok.engine.manage.project.models.Project
import org.robok.engine.manage.project.models.ProjectSettings
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.templates.Language
import org.robok.engine.templates.logic.JavaScreenTemplate
import org.robok.engine.templates.logic.KotlinScreenTemplate
import org.robok.engine.templates.xml.AndroidManifestTemplate
import org.robok.engine.templates.xml.BasicXML

class ProjectManager(private var context: Context) {

  companion object {
    private const val TAG = "ProjectManager"
    val PROJECTS_PATH =
      File(Environment.getExternalStorageDirectory().absolutePath + "/Robok/Projects/")
  }

  lateinit var projectPath: File
  lateinit var creationListener: CreationListener
  lateinit var preferencesViewModel: PreferencesViewModel

  init {
    preferencesViewModel = RobokApplication.getInstance().getKoin().get()
  }

  fun create(
    projectName: String,
    packageName: String,
    language: Language,
    template: ProjectTemplate,
  ) {
    try {
      context.assets?.open(template.zipFileName)?.use { zipFileInputStream ->
        ZipInputStream(BufferedInputStream(zipFileInputStream)).use { zipInputStream ->
          if (!projectPath.exists()) {
            projectPath.mkdirs()
          }

          var zipEntry: ZipEntry?
          while (zipInputStream.nextEntry.also { zipEntry = it } != null) {
            if (!zipEntry!!.isDirectory) {
              val entryName = zipEntry!!.name
              val outputFileName =
                entryName
                  .replace(template.name, projectName)
                  .replace("game/logic/\$pkgName", "game/logic/${packageName.replace('.', '/')}")
              val outputFile = File(projectPath, outputFileName)

              if (outputFile?.parentFile?.exists()!!.not()) {
                outputFile?.parentFile?.mkdirs()
              }

              FileOutputStream(outputFile).use { fos ->
                val buffer = ByteArray(1024)
                var length: Int
                while (zipInputStream.read(buffer).also { length = it } > 0) {
                  fos.write(buffer, 0, length)
                }
              }
            }
            zipInputStream.closeEntry()
          }
          createProjectSettingsFile()
          createMainScreen(projectName, packageName, language)
          createAndroidManifest(packageName)
          createStringsFile(projectName)
          extractLibs(projectName)
        }
      }
    } catch (e: FileNotFoundException) {
      notifyCreationError(e, "create")
    } catch (e: IOException) {
      notifyCreationError(e, "create")
    }
  }

  private fun createMainScreen(projectName: String, packageName: String, language: Language) {
    try {
      val template =
        when (language) {
          Language.Java -> JavaScreenTemplate()
          else -> KotlinScreenTemplate()
        }.apply {
          name = "MainScreen"
          this.packageName = packageName
          regenerate()
        }

      val fileExt = when (language) {
        Language.Java -> "java"
        else -> "kt"
      }

      val classFilePath = "game/logic/${packageName.replace('.', '/')}/${template.name}.${fileExt}"
      val javaFile = File(projectPath, classFilePath)

      if (javaFile?.parentFile?.exists()!!.not()) {
        javaFile?.parentFile?.mkdirs()
      }

      FileOutputStream(javaFile).use { fos -> fos.write(template.code.toByteArray()) }
    } catch (e: FileNotFoundException) {
      notifyCreationError(e, "createMainScreen")
    } catch (e: IOException) {
      notifyCreationError(e, "createMainScreen")
    }
  }

  private fun createStringsFile(projectName: String) {
    val stringsFile =
      BasicXML().apply {
        name = projectName
        type = "string"
        key = "name"
        add("example_string", "any value")
        regenerate()
      }
    Log.d(TAG, stringsFile.code)
    FileUtil.writeFile(
      "${projectPath.absolutePath}/game/assets/texts/strings.xml",
      stringsFile.code,
    )
  }

  private fun createAndroidManifest(packageName: String) {
    val androidManifest =
      AndroidManifestTemplate().apply {
        val mainScreenName = getProjectSettingsFromFile()?.mainScreenName
        val gameName = getProjectSettingsFromFile()?.gameName

        this.packageName = packageName

        if (mainScreenName != null) this.mainScreenName = "$packageName.$mainScreenName"
        if (gameName != null) this.gameName = gameName
        regenerate()
      }
    FileUtil.writeFile(getAndroidManifestFile().absolutePath, androidManifest.code)
  }

  private fun createProjectSettingsFile() {
    val config =
      ProjectSettings(
        gameName = getProjectName(),
        mainScreenName = "MainScreen",
        gameIconPath = "game/assets/images/game_icon.png",
      )
    FileUtil.writeFile(getProjectSettingsFile().absolutePath, getJson().encodeToString(config))
  }

  private fun extractLibs(projectName: String) {
    extractZipFromAssets(context, "libs.zip", getLibsPath())

    creationListener.onProjectCreate()
  }

  val rdkVersionFlow: Flow<String>
    get() = preferencesViewModel.installedRDKVersion

  fun compileProject(buildLoggerViewModel: LoggerViewModel, result: CompilerTask.OnCompileResult) {
    try {

      SystemLogPrinter.start(context, buildLoggerViewModel)

      copyIconToPrivate()
      
      var rdkVersion = "RDK-1"
      runBlocking { rdkVersion = rdkVersionFlow.first() }
      val libs = mutableListOf<Library>()

      libs.addAll(Library.fromFile(getLibsPath()))

      val jarDir = File(context.filesDir, "${rdkVersion}/jar/")
      if (jarDir.exists()) {
        libs.addAll(Library.fromFile(jarDir))
      }

      val project =
        CompilerProject().apply {
          libraries = libs
          resourcesFile = getAndroidResPath()
          outputFile = File("${projectPath.absolutePath}/build/")
          javaFile = File("${projectPath.absolutePath}/game/logic/")
          manifestFile = File(getAndroidManifestFile().absolutePath)
          logger = buildLoggerViewModel
          minSdk = ProjectBuildConfig.MIN_SDK
          targetSdk = ProjectBuildConfig.TARGET_SDK
          rootPath = projectPath
        }

      val task = CompilerTask(context, result)
      task.execute(project)
    } catch (e: Exception) {
      notifyBuildError(e, "build")
    }
  }

  private fun copyIconToPrivate() {
    val config = getProjectSettingsFromFile()
    if (config?.gameIconPath != null) {
      val destPath = "${getAndroidResPath()}/drawable/ic_launcher.png"
      FileUtil.copyFile("${projectPath}/${config.gameIconPath}", destPath)
      return
    }
    Log.e(TAG, "gameIconPath is null")
  }

  fun writeToProjectSettings(buildConfig: ProjectSettings) {
    FileUtil.writeFile(getProjectSettingsFile().absolutePath, getJson().encodeToString(buildConfig))
  }

  fun getProjectName(): String {
    return projectPath.absolutePath.substringAfterLast("/")
  }

  fun getLibsPath(): File {
    return File(context.filesDir, "${getProjectName()}/libs/")
  }

  fun getAndroidManifestFile(): File {
    return File(context.filesDir, "${getProjectName()}/xml/AndroidManifest.xml")
  }

  fun getAndroidResPath(): File {
    return File(context.filesDir, "${getProjectName()}/xml/res/")
  }

  fun getProjectSettingsFile(): File {
    return File(projectPath, ".robok/config.json")
  }

  fun getHudsPath(): File {
    return File(projectPath, "game/assets/hud/")
  }

  fun getScreensPath(): File {
    return File(projectPath, "game/assets/screens/")
  }

  fun getProjectSettingsFromFile(): ProjectSettings? {
    val p = getProjectSettingsFile().absolutePath
    if (p.isValidPath()) {
      return getJson().decodeFromString<ProjectSettings>(FileUtil.readFile(p))
    } else {
      return null
    }
  }

  fun getProject(): Project? {
    val settings = getProjectSettingsFromFile()
    if (settings == null) return null
    return Project(name = getProjectName(), settings = settings!!)
  }

  override fun toString(): String {
    val msg =
      """
      ProjectName = ${getProjectName()}
      ProjectPath = ${projectPath}
    """
    return msg
  }

  private fun getJson(): Json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
  }

  private fun notifyCreationError(value: String) {
    creationListener.onProjectCreateError(value)
  }

  private fun notifyCreationError(value: String, methodName: String) {
    creationListener.onProjectCreateError("$value Method: $methodName")
  }

  private fun notifyCreationError(e: Exception, methodName: String) {
    creationListener.onProjectCreateError("${e.toString()} Method: $methodName")
  }

  private fun notifyBuildError(value: String) {
    creationListener.onProjectCreateError(value)
  }

  private fun notifyBuildError(value: String, methodName: String) {
    creationListener.onProjectCreateError("$value Method: $methodName")
  }

  private fun notifyBuildError(e: Exception, methodName: String) {
    creationListener.onProjectCreateError("${e.toString()} Method: $methodName")
  }

  interface CreationListener {
    fun onProjectCreate()

    fun onProjectCreateError(error: String)
  }

  object ProjectBuildConfig {
    const val MIN_SDK = 21
    const val TARGET_SDK = 28
  }
}
