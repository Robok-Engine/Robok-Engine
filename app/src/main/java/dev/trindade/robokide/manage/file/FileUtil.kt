package dev.trindade.robokide.manage.file

import java.io.File

fun createFolder(folderPath: String) {
    val folder = File(folderPath)
    if (!folder.exists()) {
        val folderCreated = folder.mkdirs()
        if (folderCreated) {
            println("Folder created successfully: $folderPath")
        } else {
            println("Failed to create folder: $folderPath")
        }
    } else {
        println("The folder already exists: $folderPath")
    }
}

fun createFile(filePath: String) {
    val file = File(filePath)
    if (!file.exists()) {
        val fileCreated = file.createNewFile()
        if (fileCreated) {
            println("File created successfully: $filePath")
        } else {
            println("Failed to create file: $filePath")
        }
    } else {
        println("The file already exists: $filePath")
    }
}