package org.gampiot.robok.feature.util

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

fun getDefaultPath(): String {
    return Environment.getExternalStorageDirectory().absolutePath
}

fun getDefaultPathFile(): File {
    return Environment.getExternalStorageDirectory()
}

interface PermissionListener {
    fun onReceive(status: Boolean)
}

fun requestAllFilesAccessPermission(activity: Activity, listener: PermissionListener) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
                data = android.net.Uri.parse("package:${activity.packageName}")
            }
            activity.startActivityForResult(intent, REQUEST_CODE_ALL_FILES_ACCESS_PERMISSION)
        } else {
            listener.onReceive(true)
        }
    } else {
        listener.onReceive(true)
    }
}

fun requestReadWritePermissions(activity: Activity, listener: PermissionListener) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_READ_WRITE_PERMISSIONS
            )
        } else {
            listener.onReceive(true)
        }
    } else {
        listener.onReceive(true)
    }
}

fun getStoragePermStatus(activity: Activity): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Environment.isExternalStorageManager()
    } else {
        ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }
}

const val REQUEST_CODE_READ_WRITE_PERMISSIONS = 1001
const val REQUEST_CODE_ALL_FILES_ACCESS_PERMISSION = 1002

fun handlePermissionsResult(
    requestCode: Int,
    grantResults: IntArray,
    listener: PermissionListener
) {
    when (requestCode) {
        REQUEST_CODE_READ_WRITE_PERMISSIONS -> {
            val allPermissionsGranted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
            listener.onReceive(allPermissionsGranted)
        }
        REQUEST_CODE_ALL_FILES_ACCESS_PERMISSION -> {
            listener.onReceive(Environment.isExternalStorageManager())
        }
        else -> {
            listener.onReceive(false)
        }
    }
}
