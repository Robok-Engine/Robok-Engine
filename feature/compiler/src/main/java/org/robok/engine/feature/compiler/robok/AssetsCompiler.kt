package org.robok.engine.feature.compiler.robok

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
import org.robok.engine.core.utils.FileUtil

class AssetsCompiler(val context: Context, val projectPath: File) {

  lateinit var projectName: String
  var logs: MutableList<Log>? = null
  lateinit var compileListener: CompileListener

  companion object {
    private const val TAG = "AssetsCompiler"
  }

  @FunctionalInterface
  interface CompileListener {
    fun whenFinish(logs: List<Log>)
  }

  fun compileAll(): Boolean {
    logs = mutableListOf()
    projectName = projectPath.absolutePath.split("/").filter { it.isNotEmpty() }.last()
    newCompileLog("Starting Assets Compiler...")
    return compileTextsToString()
  }

  private fun compileTextsToString(): Boolean {
    return try {
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
      true
    } catch (e: Exception) {
      newCompileError(e.toString())
      false
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
