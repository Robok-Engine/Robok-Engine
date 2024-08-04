package org.gampiot.robokide.feature.util

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.provider.Settings

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import java.io.File
import java.io.FileInputStream
import java.io.IOException

fun getDefaultPath(): String {
    return "/sdcard/"
}
fun getDefaultPathFile(): File {
    return File("/sdcard/")
}

fun requestPermission(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            activity.startActivity(intent)
        }
    } else {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_STORAGE_PERMISSIONS
            )
        }
    }
}

const val REQUEST_CODE_STORAGE_PERMISSIONS = 1001

fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    if (requestCode == REQUEST_CODE_STORAGE_PERMISSIONS) {
        if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            println("Permissions granted")
        } else {
            println("Permissions denied")
        }
    }
}

fun readTextFile(filePath: String): String {
    val file = File(filePath)
    return if (file.exists()) {
        try {
            file.readText()
        } catch (e: IOException) {
            println("Error reading file: ${e.message}")
            ""
        }
    } else {
        println("File not found: $filePath")
        ""
    }
}

fun readBinaryFile(filePath: String): ByteArray? {
    val file = File(filePath)
    return if (file.exists()) {
        try {
            FileInputStream(file).use { it.readBytes() }
        } catch (e: IOException) {
            println("Error reading file: ${e.message}")
            null
        }
    } else {
        println("File not found: $filePath")
        null
    }
}

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