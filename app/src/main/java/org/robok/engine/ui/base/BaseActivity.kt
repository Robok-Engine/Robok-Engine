package org.robok.engine.ui.base

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

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoin
import org.robok.engine.core.database.viewmodels.DatabaseViewModel
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.core.utils.PermissionListener
import org.robok.engine.core.utils.requestAllFilesAccessPermission
import org.robok.engine.core.utils.requestReadWritePermissions
import org.robok.engine.defaults.DoNothing

/** Base Class for All Activities. */
abstract class BaseActivity : ComponentActivity(), PermissionListener {

  /** database to get database, like isFirstTime */
  public val database: DatabaseViewModel by lazy { getKoin().get() }

  /** preferences of app */
  public val preferences: PreferencesViewModel by lazy { getKoin().get() }

  private val allFilesPermissionLauncher =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
      val granted =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && Environment.isExternalStorageManager()
      onReceive(type = PermissionType.STORAGE, status = granted)
    }

  private val readWritePermissionLauncher =
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
      val allGranted = permissions.values.all { it }
      onReceive(type = PermissionType.STORAGE, status = allGranted)
    }

  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
  }

  /** request storage permission, with support for old and newer android's */
  public fun requestStoragePermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      requestAllFilesAccessPermission(this, allFilesPermissionLauncher)
    } else {
      requestReadWritePermissions(this, readWritePermissionLauncher)
    }
  }

  /**
   * called when return of permission android screen with type
   *
   * @param type Received type of permission
   * @param status Received status of Permission request
   *
   * implement in your activity to handle this.
   */
  protected open fun onReceive(type: PermissionType, status: Boolean) = DoNothing

  /**
   * called when return of permission android screen
   *
   * @param status Received status of Permission request
   *
   * implement in your activity to handle this.
   */
  @Deprecated(
    message = "Use the most informative method:",
    replaceWith = ReplaceWith("onReceive(PermissionType, Boolean)"),
    level = DeprecationLevel.HIDDEN,
  )
  override fun onReceive(status: Boolean) = DoNothing

  enum class PermissionType {
    STORAGE
  }
}
