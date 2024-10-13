package org.robok.engine.core.utils

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

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

interface PermissionListener {
    fun onReceive(status: Boolean)
}

fun requestAllFilesAccessPermission(activity: Activity, listener: PermissionListener) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            val intent =
                Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
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
    if (
        ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) !=
            PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            ) != PackageManager.PERMISSION_GRANTED
    ) {

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            ),
            REQUEST_CODE_READ_WRITE_PERMISSIONS,
        )
    } else {
        listener.onReceive(true)
    }
}

fun getStoragePermStatus(activity: Activity): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Environment.isExternalStorageManager()
    } else {
        ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            ) == PackageManager.PERMISSION_GRANTED
    }
}

const val REQUEST_CODE_READ_WRITE_PERMISSIONS = 1001
const val REQUEST_CODE_ALL_FILES_ACCESS_PERMISSION = 1002

fun handlePermissionsResult(
    requestCode: Int,
    grantResults: IntArray,
    listener: PermissionListener,
) {
    when (requestCode) {
        REQUEST_CODE_READ_WRITE_PERMISSIONS -> {
            val allPermissionsGranted =
                grantResults.isNotEmpty() &&
                    grantResults.all { it == PackageManager.PERMISSION_GRANTED }
            listener.onReceive(allPermissionsGranted)
        }
        REQUEST_CODE_ALL_FILES_ACCESS_PERMISSION -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                listener.onReceive(Environment.isExternalStorageManager())
            }
        }
        else -> {
            listener.onReceive(false)
        }
    }
}
