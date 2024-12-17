package org.robok.engine.ui.screens.setup

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
 *   along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import android.os.Bundle
import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.Strings
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.switch.PreferenceSwitch
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.ui.screens.setup.components.BottomButtons
import kotlinx.coroutines.launch

@Composable
fun SetupPermissionsScreen(onBack: () -> Unit, onNext: () -> Unit) {
  val context = LocalContext.current
  val permissionStatus by remember { mutableStateOf(getStoragePermStatus(context as Activity)) }
  val toastHostState = LocalToastHostState.current
  val coroutineScope = rememberCoroutineScope()
  
  Scaffold(
    bottomBar = {
      BottomButtons(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        onNext = {
          coroutineScope.launch {
            toastHostState.showToast(
              message = context.getString(Strings.setup_permission_not_granted),
              icon = Icons.Rounded.Error,
            )
          }
          if (permissionStatus) onNext()
        },
        onBack = onBack,
      )
    }
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      PreferenceGroup {
        PreferenceSwitch(
          checked = permissionStatus,
          onCheckedChange = {
            requestStoragePermission(context)
          },
          label = stringResource(id = Strings.setup_permission_storage_title),
          description = stringResource(id = Strings.setup_permission_storage_message)
        )
      }
    }
  }
}

@Deprecated(
  message = "Deprecated. Use Compose Permission System",
  level = DeprecationLevel.HIDDEN
)
private fun requestStoragePermission(context: Context) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    requestAllFilesAccessPermission(context, null)
  } else {
    requestReadWritePermissions(context, null)
  }
}