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
import kotlinx.coroutines.runBlocking
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.RobokLog

class AssetsCompiler(val context: Context, val projectPath: File) {

  lateinit var projectName: String
  var logs: MutableList<String>? = null
  lateinit var compileListener: CompileListener

  companion object {
    private const val TAG = "AssetsCompiler"
  }

  @FunctionalInterface
  interface CompileListener {
    fun whenFinish(logs: List<String>)
  }
  
  fun compileAll() {
    logs = mutableListOf()
    projectName = projectPath.absolutePath.split("/").filter { it.isNotEmpty() }.last()
    newBuildLog("Starting Assets Compiler...")
    newLog("Path: ${projectPath}")
    newLog("Name: ${projectName}")
    compileTextsToString()
  }

  private fun compileTextsToString() {
    val list = arrayListOf<String>()
    var pathToSave = File("")

    FileUtil.listDir(projectPath.absolutePath + "/game/assets/texts/", list)
    list.forEach {
      val file = File(it)
      if (!file.name.equals("strings.xml")) { 
        val start = file.name.indexOf("strings-") + "strings-".length
        val end = file.name.indexOf(".xml")
        val countryCode = file.name.substring(start, end)
        pathToSave = File(context.filesDir.absolutePath, projectName + "/xml/res/values-$countryCode")
        newBuildLog("Compiling ${countryCode} language...")
      } else {
        pathToSave = File(context.filesDir.absolutePath, projectName + "/xml/res/values")
        newBuildLog("Compiling default language...")
      }
      FileUtil.writeFile(
        pathToSave.absolutePath + "/strings.xml",
        FileUtil.readFile(file.absolutePath),
      )
    }
    newBuildLog("Assets Texts Compiled Successfully!")
    compileListener.whenFinish(logs?.toList() ?: listOf())
  }
  
  private fun newBuildLog(log: String) {
    RobokLog.d(tag = TAG, message = log)
    logs?.add(log)
  }
  
  private fun newLog(log: String) {
    RobokLog.d(tag = TAG, message = log)
  }
}