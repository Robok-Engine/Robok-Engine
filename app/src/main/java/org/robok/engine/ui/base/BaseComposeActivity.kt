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

import android.os.Build
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
import androidx.compose.ui.graphics.Color
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.PaletteStyle
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import org.robok.engine.Strings
import org.robok.engine.core.database.DefaultValues as DBDefaultValues
import org.robok.engine.core.settings.DefaultValues as PrefsDefaultValues
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.ui.core.components.dialog.permission.PermissionDialog
import org.robok.engine.ui.core.components.toast.LocalToastHostState
import org.robok.engine.ui.core.components.toast.ToastHost
import org.robok.engine.ui.core.components.toast.rememberToastHostState
import org.robok.engine.ui.draw.blur
import org.robok.engine.ui.platform.LocalThemeDynamicColor
import org.robok.engine.ui.platform.LocalThemePaletteStyleIndex
import org.robok.engine.ui.platform.LocalThemeSeedColor
import org.robok.engine.ui.theme.RobokTheme
import org.robok.engine.ui.theme.paletteStyles
import org.robok.engine.ui.theme.rememberDynamicScheme

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
    setContent {
      ProvideCompositionLocals {
        RobokTheme {
          Screen()
        }
      }
    }
  }

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    val appIsUseMonet by
      preferences.appIsUseMonet.collectAsState(initial = PrefsDefaultValues.IS_USE_MONET)
    val appThemeSeedColor: Int by
      preferences.appThemeSeedColor.collectAsState(initial = PrefsDefaultValues.APP_THEME_SEED_COLOR)
    val appThemePaletteStyleIndex by
      preferences.appThemePaletteStyleIndex.collectAsState(
        initial = PrefsDefaultValues.APP_THEME_PALETTE_STYLE_INDEX
      )
    val tonalPalettes =
      if (appIsUseMonet && Build.VERSION.SDK_INT >= 31) rememberDynamicScheme().toTonalPalettes()
      else
        Color(appThemeSeedColor)
          .toTonalPalettes(
            paletteStyles.getOrElse(appThemePaletteStyleIndex) { PaletteStyle.TonalSpot }
          )

    CompositionLocalProvider(
      LocalThemeSeedColor provides appThemeSeedColor,
      LocalThemePaletteStyleIndex provides appThemePaletteStyleIndex,
      LocalThemeDynamicColor provides appIsUseMonet,
      LocalTonalPalettes provides tonalPalettes,
      LocalToastHostState provides rememberToastHostState(),
      content = content,
    )
  }

  @Composable
  private fun Screen() {
    val isFirstTime by database.isFirstTime.collectAsState(initial = DBDefaultValues.IS_FIRST_TIME)
    if (!isFirstTime) {
      HandlePermissions()
    }

    Box(
      modifier =
        Modifier.fillMaxSize()
          .blur(radius = blurRadius, isBlurEnable = false) // remove blur for now
    ) {
      onScreenCreated()
    }
    ToastHost()
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
