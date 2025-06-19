package org.robok.engine.feature.compiler.robok

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

import android.content.Context
import java.io.File
import org.robok.engine.core.utils.FileUtil

class ResourcesCompiler(val context: Context, val projectPath: File) {

  lateinit var projectName: String
  var logs: MutableList<Log>? = null
  lateinit var compileListener: CompileListener

  companion object {
    private const val TAG = "ResourcesCompiler"
  }

  @FunctionalInterface
  interface CompileListener {
    fun whenFinish(logs: List<Log>)
  }

  fun compileAll() {
    logs = mutableListOf()
    projectName = projectPath.absolutePath.split("/").filter { it.isNotEmpty() }.last()
    newCompileLog("Starting Assets Compiler...")
    compileTextsToString()
  }

  private fun compileTextsToString() {
    try {
      val list = arrayListOf<String>()
      var pathToSave = File("")

      FileUtil.listDir(projectPath.absolutePath + "/game/assets/texts/", list)
      list.forEach {
        val file = File(it)

        if (!file.name.equals("strings.xml")) {
          val start = file.name.indexOf("strings-") + "strings-".length
          val end = file.name.indexOf(".xml")
          val countryCode = file.name.substring(start, end)
          pathToSave =
            File(context.filesDir.absolutePath, projectName + "/xml/res/values-$countryCode")
          newCompileLog("Compiling ${countryCode} language...")
        } else {
          pathToSave = File(context.filesDir.absolutePath, projectName + "/xml/res/values")
          newCompileLog("Compiling default language...")
        }

        FileUtil.writeFile(
          pathToSave.absolutePath + "/strings.xml",
          FileUtil.readFile(file.absolutePath),
        )
      }
      newCompileLog("Assets Texts Compiled Successfully!")
    } catch (e: Exception) {
      newCompileError(e.toString())
    }
    compileListener.whenFinish(logs?.toList() ?: listOf())
  }

  private fun newCompileLog(log: String) = logs?.add(Log(LogType.NORMAL, log))

  private fun newCompileError(log: String) = logs?.add(Log(LogType.ERROR, log))

  data class Log(val type: LogType, val text: String)

  enum class LogType {
    NORMAL,
    ERROR,
  }
}
