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

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.stringResource
import org.robok.engine.core.components.dialog.permission.PermissionDialog
import org.robok.engine.core.components.toast.ToastHost
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.core.components.toast.rememberToastHostState
import org.robok.engine.core.utils.PermissionListener
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.core.utils.requestAllFilesAccessPermission
import org.robok.engine.core.utils.requestReadWritePermissions
import org.robok.engine.strings.Strings
import org.robok.engine.ui.theme.RobokTheme

abstract class BaseComposeActivity : BaseActivity(), PermissionListener {

  private var showStoragePermissionDialog by mutableStateOf(false)
  private var permissionDialogText by mutableStateOf("")
  private var onAllowClick: (() -> Unit)? = null
  private var onDenyClick: (() -> Unit)? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      enableEdgeToEdge()
      RobokTheme {
        ProvideCompositionLocals {
          onScreenCreated()
          ToastHost()
        }
      }
    }
  }

  @Composable protected abstract fun onScreenCreated()

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    val toastHostState = rememberToastHostState()
    CompositionLocalProvider(LocalToastHostState provides toastHostState, content = content)
  }

  @Composable
  private fun checkPermissions() {
    checkStoragePermissions()
    if (showStoragePermissionDialog) {
      PermissionDialog(
        icon = Icons.Rounded.Folder,
        dialogText = stringResource(id = Strings.warning_all_files_perm_message),
        onAllowClicked = {
          onAllowClick?.invoke()
          showStoragePermissionDialog = false
        },
        onDenyClicked = {
          onDenyClick?.invoke()
          showStoragePermissionDialog = false
        },
        onDismissRequest = { showStoragePermissionDialog = false },
      )
    }
  }

  @Composable
  private fun checkStoragePermissions() {
    if (!getStoragePermStatus(this)) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        onAllowClick = {
          requestAllFilesAccessPermission(this@BaseComposeActivity, this@BaseComposeActivity)
        }
      } else {
        onAllowClick = {
          requestReadWritePermissions(this@BaseComposeActivity, this@BaseComposeActivity)
        }
      }
      onDenyClick = { finish() }
      showStoragePermissionDialog = true
    }
  }

  override fun onReceive(status: Boolean) {}
}
