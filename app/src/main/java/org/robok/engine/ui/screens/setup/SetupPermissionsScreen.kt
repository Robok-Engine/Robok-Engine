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

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.robok.engine.Strings
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.switch.PreferenceSwitch
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.ui.base.BaseComposeActivity
import org.robok.engine.ui.screens.setup.components.BottomButtons

@Composable
fun SetupPermissionsScreen(onBack: () -> Unit, onNext: () -> Unit) {
  val context = LocalContext.current
  val activity = context as BaseComposeActivity
  val permissionsState = activity.permissionsState
  val toastHostState = LocalToastHostState.current
  val coroutineScope = rememberCoroutineScope()

  BackHandler { onBack() }
  Screen(
    label = stringResource(id = Strings.text_permissions),
    backArrowVisible = false,
    modifier = Modifier.systemBarsPadding(),
    bottomBar = {
      BottomButtons(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        onNext = {
          if (permissionsState.isStoragePermissionAllow) {
            onNext()
          } else {
            coroutineScope.launch {
              toastHostState.showToast(
                message = context.getString(Strings.setup_permission_not_granted),
                icon = Icons.Rounded.Error,
              )
            }
          }
        },
        onBack = onBack,
      )
    },
  ) { innerPadding ->
    Column(modifier = Modifier.fillMaxSize()) {
      PreferenceGroup {
        PreferenceSwitch(
          checked = permissionsState.isStoragePermissionAllow,
          onCheckedChange = { activity?.requestStoragePermission() },
          label = stringResource(id = Strings.setup_permission_storage_title),
          description = stringResource(id = Strings.warning_storage_perm_message),
        )
      }
    }
  }
}
