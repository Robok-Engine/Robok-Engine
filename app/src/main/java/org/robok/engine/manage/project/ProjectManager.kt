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
import org.amix.Amix
import org.koin.android.ext.android.getKoin
import org.robok.engine.RobokApplication
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.Log
import org.robok.engine.core.utils.extractZipFromAssets
import org.robok.engine.core.utils.isValidPath
import org.robok.engine.feature.compiler.android.CompilerTask
import org.robok.engine.feature.compiler.android.SystemLogPrinter
import org.robok.engine.feature.compiler.android.logger.Logger
import org.robok.engine.feature.compiler.android.model.Library
import org.robok.engine.feature.compiler.android.model.Project
import org.robok.engine.manage.project.models.ProjectSettings
import org.robok.engine.manage.project.styles.StyleType
import org.robok.engine.manage.project.styles.StylesDownloader
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.templates.logic.ScreenLogicTemplate
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

  fun create(projectName: String, packageName: String, template: ProjectTemplate) {
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
          createMainScreen(projectName, packageName)
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

  private fun createMainScreen(projectName: String, packageName: String) {
    try {
      val template =
        ScreenLogicTemplate().apply {
          name = "MainScreen"
          this.packageName = packageName
          regenerate()
        }

      val classFilePath = "game/logic/${packageName.replace('.', '/')}/${template.name}.java"
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

  fun compileProject(buildLogger: Logger = Logger(), result: CompilerTask.OnCompileResult) {
    try {
      val coroutineScope = CoroutineScope(Dispatchers.IO)

      SystemLogPrinter.start(context, buildLogger)

      copyIconToPrivate()
      compileAllAmixFiles()
      coroutineScope.launch { downloadStyles() }

      var rdkVersion = "RDK-1"
      runBlocking { rdkVersion = rdkVersionFlow.first() }
      val libs = mutableListOf<Library>()

      libs.addAll(Library.fromFile(getLibsPath()))

      val jarDir = File(context.filesDir, "${rdkVersion}/jar/")
      if (jarDir.exists()) {
        libs.addAll(Library.fromFile(jarDir))
      }

      val project =
        Project().apply {
          libraries = libs
          resourcesFile = getAndroidResPath()
          outputFile = File("${projectPath.absolutePath}/build/")
          javaFile = File("${projectPath.absolutePath}/game/logic/")
          manifestFile = File(getAndroidManifestFile().absolutePath)
          logger = buildLogger
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

  /** compiles all .amx files of project */
  fun compileAllAmixFiles() {
    // TODO: Logs on Build BottomSheet
    getAllAmixFiles().forEach { file ->
      if (file.extension.equals("amx") || file.extension.equals("amix")) {
        val amixCode = FileUtil.readFile(file.absolutePath)
        val fileName = file.nameWithoutExtension
        generateXmlFromAmix(
          amixCode = amixCode,
          onGenerateCode = { generatedCode, config ->
            FileUtil.writeFile(
              getAndroidResPath().absolutePath + "/layout/${fileName}.xml",
              generatedCode,
            )
          },
        )
      }
    }
  }

  /** compile .amx file and return XML result */
  fun generateXmlFromAmix(
    amixCode: String,
    onGenerateCode: Amix.OnGenerateCode,
    onError: Amix.OnError? = null,
  ) {
    val builder =
      Amix.Builder()
        .setUseComments(false)
        .setUseStyle(true)
        .setUseVerticalRoot(true)
        .setCode(amixCode)
        .setOnGenerateCode(onGenerateCode)

    onError?.let { builder.setOnError(it) }

    val amix = builder.create()
    amix.compile()
  }

  private suspend fun downloadStyles() {
    // TODO: Logs on Build Bottom Sheet
    // TODO: do a for-each in hud files and verify what styles are used
    val sd = StylesDownloader()
    sd.startDownload(
      context = context,
      type = StyleType.DEFAULT,
      outputDir = "${getAndroidResPath()}/drawable/",
      onResult = { isSuccess -> },
    )
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

  fun getAllAmixFiles(): List<File> {
    val screensFolderList = FileUtil.listFilesInDir(getScreensPath())
    val hudFolderList = FileUtil.listFilesInDir(getHudsPath())
    val allAmixFiles = mutableListOf<File>()
    allAmixFiles.addAll(screensFolderList)
    allAmixFiles.addAll(hudFolderList)
    return allAmixFiles
  }

  fun getProjectSettingsFromFile(): ProjectSettings? {
    val p = getProjectSettingsFile().absolutePath
    if (p.isValidPath()) {
      return getJson().decodeFromString<ProjectSettings>(FileUtil.readFile(p))
    } else {
      return null
    }
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
