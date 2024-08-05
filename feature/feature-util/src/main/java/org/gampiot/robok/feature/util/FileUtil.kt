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
    return "/sdcard/"
}

fun getDefaultPathFile(): File {
    return File("/sdcard/")
}

interface PermissionListener {
    fun onReceive(status: Boolean)
}

fun requestStoragePerm(activity: Activity, listener: PermissionListener) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            activity.startActivityForResult(intent, REQUEST_CODE_STORAGE_PERMISSIONS)
        } else {
            listener.onReceive(true)
        }
    } else {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_STORAGE_PERMISSIONS
            )
        } else {
            listener.onReceive(true)
        }
    }
}

fun getStoragePermStatus(activity: Activity): Boolean {
    return ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
           ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
}

const val REQUEST_CODE_STORAGE_PERMISSIONS = 1001

fun handlePermissionsResult(
    requestCode: Int,
    grantResults: IntArray,
    listener: PermissionListener
) {
    if (requestCode == REQUEST_CODE_STORAGE_PERMISSIONS) {
        val allPermissionsGranted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
        listener.onReceive(allPermissionsGranted)
    } else {
        listener.onReceive(false)
    }
}
