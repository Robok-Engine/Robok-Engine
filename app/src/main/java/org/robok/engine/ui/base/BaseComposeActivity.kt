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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import org.koin.android.ext.android.getKoin
import org.robok.engine.core.database.DefaultValues
import org.robok.engine.core.database.viewmodels.DatabaseViewModel
import org.robok.engine.core.components.dialog.permission.PermissionDialog
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.core.components.toast.ToastHost
import org.robok.engine.core.components.toast.rememberToastHostState
import org.robok.engine.core.utils.PermissionListener
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.core.utils.requestAllFilesAccessPermission
import org.robok.engine.core.utils.requestReadWritePermissions
import org.robok.engine.strings.Strings
import org.robok.engine.ui.theme.RobokTheme

abstract class BaseComposeActivity : BaseActivity(), PermissionListener {

  private var permissionDialogState by mutableStateOf<PermissionDialogState?>(null)
  protected val database: DatabaseViewModel by lazy { getKoin().get() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      RobokTheme {
        Screen()
      }
    }
  }

  @Composable
  private fun Screen() {
    val isFirstTime by database.isFirstTime.collectAsState(initial = DefaultValues.IS_FIRST_TIME)
    if (!isFirstTime) {
      HandlePermissions()
    }
    ProvideCompositionLocals {
      onScreenCreated()
      ToastHost()
    }
  }

  @Composable
  private fun HandlePermissions() {
    var hasPermission by remember {
      mutableStateOf(getStoragePermStatus(this)) 
    }
    LaunchedEffect(hasPermission) {
      if (hasPermission.not()) {
        permissionDialogState = PermissionDialogState(
          dialogText = getString(Strings.warning_all_files_perm_message),
          onAllowClick = {
            requestStoragePermission()
            hasPermission = true
          },
          onDenyClick = { finish() }
        )
      }
    }
    permissionDialogState?.let {
      StoragePermissionDialog(it)
    }
  }

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

  private fun requestStoragePermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      requestAllFilesAccessPermission(this, this)
    } else {
      requestReadWritePermissions(this, this)
    }
  }

  override fun onReceive(status: Boolean) {
    if (status) {
      permissionDialogState = null
    }
  }

  @Composable
  protected abstract fun onScreenCreated()

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    CompositionLocalProvider(
      LocalToastHostState provides rememberToastHostState(),
      content = content
    )
  }
  
  private data class PermissionDialogState(
    val dialogText: String,
    val onAllowClick: () -> Unit,
    val onDenyClick: () -> Unit
  )
}