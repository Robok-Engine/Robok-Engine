package org.robok.engine.core.utils

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat

@Deprecated("Pls refactor that fucked up thingy")
interface PermissionListener {
  fun onReceive(status: Boolean)
}

@Deprecated("Pls refactor that fucked up thingy")
fun requestAllFilesAccessPermission(activity: Activity, launcher: ActivityResultLauncher<Intent>) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    if (!Environment.isExternalStorageManager()) {
      val intent =
        Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
          data = Uri.parse("package:${activity.packageName}")
        }
      launcher.launch(intent)
    }
  }
}

@Deprecated("Pls refactor that fucked up thingy")
fun requestReadWritePermissions(
  activity: Activity,
  launcher: ActivityResultLauncher<Array<String>>,
) {
  if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
    launcher.launch(
      arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    )
  }
}

@Deprecated("Pls refactor that fucked up thingy")
fun getStoragePermStatus(activity: Activity?): Boolean {
  return if (activity == null) {
    false
  } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    Environment.isExternalStorageManager()
  } else {
    ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) ==
      PackageManager.PERMISSION_GRANTED &&
      ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
        PackageManager.PERMISSION_GRANTED
  }
}
