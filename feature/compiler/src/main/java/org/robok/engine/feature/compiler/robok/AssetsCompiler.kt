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
import kotlinx.coroutines.delay
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.RobokLog

class AssetsCompiler(val context: Context, val projectPath: File) {

  lateinit var projectName: String
  lateinit var logs: MutableList<String>
  lateinit var compileListener: CompileListener
  
  companion object {
    private const val TAG = "AssetsCompiler"
    private const val FAKE_DELAY_1 = 200L
    private const val FAKE_DELAY_2 = 5000L
  }

  @FunctionalInterface
  interface CompileListener {
    fun whenFinish(logs: List<String>)
  }

  init {
    projectName = projectPath.absolutePath.split("/").filter { it.isNotEmpty() }.last()
  }

  fun compileAll() {
    runBlocking {
      newLog("Starting Assets Compiler...")
      delay(FAKE_DELAY_2)
      compileTextsToString()
    }
  }

  private suspend fun compileTextsToString() {
    val list = arrayListOf<String>()
    var pathToSave = File()
    
    FileUtil.listDir(projectPath.absolutePath + "/game/assets/texts/", list)
    list.forEach {
      val file = File(it)
      if (!file.getName().equals("strings.xml")) { 
        val start = file.getName().indexOf("strings-") + "strings-".length
        val end = file.getName().indexOf(".xml")
        val countryCode = file.getName().substring(start, end)
        pathToSave = File(context.filesDir.absolutePath, projectName + "/xml/res/values-" + countryCode)
        newLog("Compiling ${countryCode} language...")
      } else {
        pathToSave = File(context.filesDir.absolutePath, projectName + "/xml/res/values")
        newLog("Compiling default language...")
      }
      FileUtil.writeFile(
        pathToSave.absolutePath + "/strings.xml",
        FileUtil.readFile(file.absolutePath),
      )
      delay(FAKE_DELAY_1)
    }
    delay(FAKE_DELAY_1)
    newLog("Assets Texts Compiled Successfully!")
    compileListener.whenFinish(logs.toList())
  }
  
  private fun newLog(log: String) {
    RobokLog.d(tag = "AssetsCompiler", message = log)
    newLog(log)
  }
}