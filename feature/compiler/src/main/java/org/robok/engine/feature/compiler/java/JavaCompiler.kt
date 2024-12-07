package org.robok.engine.feature.compiler.java

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
import com.android.tools.r8.D8
import dalvik.system.DexClassLoader
import java.io.*
import java.lang.reflect.InvocationTargetException
import org.eclipse.jdt.internal.compiler.batch.Main
import org.robok.engine.feature.compiler.Decompress

/**
 * Class that compiles Java code from a Java file.
 * @author Aquiles Trindade (trindadedev13)
 */
class JavaCompiler(private val context: Context) {

  private val logs = mutableListOf<String>()

  /**
   * Compiles the code using ECJ.
   * @param compileItem An item with information to compile.
   */
  fun compile(compileItem: CompileItem) {
    logs.clear()
    if (!compileItem.javaFile.exists() || !compileItem.javaFile.name.endsWith(".java")) {
      newLog("Invalid file: ${compileItem.javaFile.absolutePath}")
      return
    }

    val errorWriter = StringWriter()
    val errWriter = PrintWriter(errorWriter)

    val outputWriter = StringWriter()
    val outWriter = PrintWriter(outputWriter)

    val outputDir = File(compileItem.outputDir, "classes/")
    if (!outputDir.exists() && !outputDir.mkdirs()) {
      newLog("Failed to create output directory: ${outputDir.absolutePath}")
      return
    }

    val args = mutableListOf<String>(
      "-1.8",
      "-proc:none",
      "-nowarn",
      "-d", outputDir.absolutePath,
      "-sourcepath", " ",
      compileItem.javaFile.absolutePath,
      "-cp", getLibs()
    )

    val compiler = Main(outWriter, errWriter, false, null, null)
    val success = compiler.compile(args.toTypedArray())

    if (!success) {
      newLog("Failed to compile:\n$errorWriter")
      return
    }

    newLog("Compiled successfully:\n$outputWriter")

    try {
      val inputPath = outputDir.absolutePath
      val outputPath = "$inputPath/classes.jar"
      val jarPackager = JarCreator(inputPath, outputPath)
      jarPackager.create()
      runOldD8(outputDir)
    } catch (e: IOException) {
      newLog(e.toString())
    }
  }

  private fun runOldD8(outputDir: File) {
    try {
      val d8Args = mutableListOf(
        "--release",
        "--min-api", "21",
        "--lib", getAndroidJarFile().absolutePath,
        "--output", outputDir.absolutePath
      )
      val classes = getClassFiles(outputDir)
      for (file in classes) {
        if (file.name.endsWith(".class")) {
          d8Args.add(file.absolutePath)
        }
      }

      D8.main(d8Args.toTypedArray())
      run(outputDir)
    } catch (e: Exception) {
      newLog(e.toString())
    }
  }

  /**
   * Runs the compiled code using R8 and DexClassLoader.
   * @param outputDir The path where classes.jar is located.
   */
  fun run(outputDir: File) {
    try {
      val resultStr = StringBuilder()
      val outputStream = object : OutputStream() {
        override fun write(v: Int) {
          resultStr.append(v.toChar())
        }

        override fun toString(): String = resultStr.toString()
      }

      System.setOut(PrintStream(outputStream))
      System.setErr(PrintStream(outputStream))

      val className = "Main"
      val optimizedDir = context.getDir("odex", Context.MODE_PRIVATE).absolutePath

      val dexLoader = DexClassLoader(
        "${outputDir.absolutePath}/classes.dex",
        optimizedDir,
        null,
        context.classLoader
      )

      val calledClass = dexLoader.loadClass(className)
      val method = calledClass.getDeclaredMethod("main", Array<String>::class.java)
      method.invoke(null, arrayOf<String>())
      newLog(resultStr.toString())
    } catch (e: Exception) {
      newLog(e.toString())
    }
  }

  private fun getClassFiles(dir: File): List<File> {
    val files = mutableListOf<File>()
    val fileArr = dir.listFiles() ?: return files

    for (file in fileArr) {
      if (file.isDirectory) {
        files.addAll(getClassFiles(file))
      } else {
        files.add(file)
      }
    }

    return files
  }

  private fun newLog(log: String) {
    logs.add(log)
  }

  fun getLogs(): List<String> = logs

  private fun getLibs(): String {
    return "${getAndroidJarFile().absolutePath}:${getLambdaFactoryFile().absolutePath}"
  }

  private fun getAndroidJarFile(): File {
    val androidJar = File("${context.filesDir}/temp/android.jar")

    if (androidJar.exists()) return androidJar

    Decompress.unzipFromAssets(
      context, "android.jar.zip", androidJar.parentFile!!.absolutePath
    )

    return androidJar
  }

  private fun getLambdaFactoryFile(): File {
    val lambdaFactory = File("${context.filesDir}/temp/core-lambda-stubs.jar")

    if (lambdaFactory.exists()) return lambdaFactory

    Decompress.unzipFromAssets(
      context, "core-lambda-stubs.zip", lambdaFactory.parentFile!!.absolutePath
    )

    return lambdaFactory
  }

  data class CompileItem(
    val javaFile: File,
    val outputDir: File
  )
}