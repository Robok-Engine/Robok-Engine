package org.robok.engine.core.utils

import java.io.File

object FileUtil {

  @JvmStatic
  fun createNewFile(path: String) {
    val file = File(path)
    if (!file.exists()) {
      file.parentFile?.mkdirs()
      file.createNewFile()
    }
  }

  @JvmStatic
  fun readFile(path: String): String {
    createNewFile(path)
    return File(path).readText()
  }

  @JvmStatic
  fun writeFile(path: String, content: String) {
    createNewFile(path)
    File(path).writeText(content)
  }

  @JvmStatic
  fun copyFile(sourcePath: String, destPath: String) {
    val sourceFile = File(sourcePath)
    if (!sourceFile.exists()) return

    createNewFile(destPath)
    sourceFile.copyTo(File(destPath), overwrite = true)
  }

  @JvmStatic
  fun deleteFile(path: String) {
    val file = File(path)
    if (!file.exists()) return

    if (file.isDirectory) {
      file.listFiles()?.forEach { deleteFile(it.absolutePath) }
    }
    file.delete()
  }

  @JvmStatic
  fun makeDir(path: String) {
    File(path).mkdirs()
  }

  @JvmStatic
  fun listDir(path: String, list: MutableList<String>) {
    val dir = File(path)
    if (!dir.exists() || dir.isFile) return

    val files = dir.listFiles() ?: return
    list.clear()
    files.forEach { list.add(it.absolutePath) }
  }
}
