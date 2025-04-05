package org.robok.engine.ui.base

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
