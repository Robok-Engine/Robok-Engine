package dev.trindade.robokide.manage.file

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

fun getDefaultPackage() : String {
     return "/sdcard/"
}

fun requestPermission(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            // Request MANAGE_EXTERNAL_STORAGE permission
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            activity.startActivity(intent)
        }
    } else {
        // Request read and write permissions
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

// Define a request code to identify the permission request
const val REQUEST_CODE_STORAGE_PERMISSIONS = 1001

// Handle the result of permission request
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