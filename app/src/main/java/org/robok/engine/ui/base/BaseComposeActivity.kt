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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.robok.engine.Strings
import org.robok.engine.core.components.dialog.permission.PermissionDialog
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.core.components.toast.ToastHost
import org.robok.engine.core.components.toast.rememberToastHostState
import org.robok.engine.core.database.DefaultValues
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.ui.draw.blur
import org.robok.engine.ui.theme.RobokTheme

/** Base activity for all compose activities. */
abstract class BaseComposeActivity : BaseActivity() {

  /** store the permission dialog values */
  private var permissionDialogState by mutableStateOf<PermissionDialogState?>(null)

  /** store the permissions state */
  public var permissionsState by mutableStateOf(PermissionsState(false))

  /** define if is to blur screen content */
  public var isBlurEnable by mutableStateOf(false)

  /** screen content blur radius */
  public var blurRadius by mutableStateOf(15)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    permissionsState.isStoragePermissionAllow = getStoragePermStatus(this)
    setContent { RobokTheme { Screen() } }
  }

  @Composable
  private fun Screen() {
    val isFirstTime by database.isFirstTime.collectAsState(initial = DefaultValues.IS_FIRST_TIME)
    if (!isFirstTime) {
      HandlePermissions()
    }
    ProvideCompositionLocals {
      Box(
        modifier = Modifier.fillMaxSize().blur(radius = blurRadius, isBlurEnable = isBlurEnable)
      ) {
        onScreenCreated()
      }
      ToastHost()
    }
  }

  /** verify if permission values, ask if is denied */
  @Composable
  private fun HandlePermissions() {
    var hasPermission by remember { mutableStateOf(getStoragePermStatus(this)) }
    LaunchedEffect(hasPermission) {
      if (hasPermission.not()) {
        permissionDialogState =
          PermissionDialogState(
            dialogText = getString(Strings.warning_all_files_perm_message),
            onAllowClick = { requestStoragePermission() },
            onDenyClick = { finish() },
          )
      }
    }
    permissionDialogState?.let { StoragePermissionDialog(it) }
  }

  /**
   * Storage Permission Dialog
   *
   * @param state PermissionDialogState instance with dialog values
   */
  @Composable
  private fun StoragePermissionDialog(state: PermissionDialogState) {
    PermissionDialog(
      icon = Icons.Rounded.Folder,
      dialogText = state.dialogText,
      onAllowClicked = {
        state.onAllowClick.invoke()
        permissionDialogState = null
      },
      onDenyClicked = {
        state.onDenyClick.invoke()
        permissionDialogState = null
      },
      onDismissRequest = { permissionDialogState = null },
    )
  }

  /**
   * called when return of permission android screen with type
   *
   * @param type Received type of permission
   * @param status Received status of Permission request
   *
   * implement in your activity to handle this.
   */
  override fun onReceive(type: PermissionType, status: Boolean) {
    super.onReceive(type, status)
    if (status) {
      permissionDialogState = null
    }
    when (type) {
      PermissionType.STORAGE -> permissionsState.isStoragePermissionAllow = status
    }
  }

  @Composable protected abstract fun onScreenCreated()

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    CompositionLocalProvider(
      LocalToastHostState provides rememberToastHostState(),
      content = content,
    )
  }

  /**
   * data class used to store permission dialog values
   *
   * @param dialogText Text to be shown in dialog
   * @param onAllowClick Event that will happen when click in allow.
   * @param onDenyClick Event that will happen when click in deny.
   */
  private data class PermissionDialogState(
    val dialogText: String,
    val onAllowClick: () -> Unit,
    val onDenyClick: () -> Unit,
  )

  /**
   * data class to store the value of permission
   *
   * @param isStoragePermissionAllow Status of Storage Permission
   */
  public data class PermissionsState(var isStoragePermissionAllow: Boolean)
}
