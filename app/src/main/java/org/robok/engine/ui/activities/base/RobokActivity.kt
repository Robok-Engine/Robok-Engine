package org.robok.engine.ui.activities.base

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

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.runtime.*
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import dev.chrisbanes.insetter.Insetter
import kotlinx.coroutines.runBlocking
import org.robok.engine.core.components.dialog.permission.PermissionDialog
import org.robok.engine.core.utils.PermissionListener
import org.robok.engine.core.utils.getBackPressedClickListener
import org.robok.engine.core.utils.getStoragePermStatus
import org.robok.engine.core.utils.requestAllFilesAccessPermission
import org.robok.engine.core.utils.requestReadWritePermissions
import org.robok.engine.strings.Strings
import org.robok.engine.ui.theme.XMLThemeManager

open class RobokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val themeManager = XMLThemeManager()
        runBlocking { themeManager.apply(this@RobokActivity) }
        super.onCreate(savedInstanceState)
    }

    fun handleInsetts(rootView: View) {
        Insetter.builder().padding(WindowInsetsCompat.Type.navigationBars()).applyToView(rootView)
    }

    open fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }

    open fun isDarkMode(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
}

open class RobokComposeActivity : RobokActivity(), PermissionListener {
    private var showPermissionDialog by mutableStateOf(false)
    private var permissionDialogText by mutableStateOf("")
    private var onAllowClick: (() -> Unit)? = null
    private var onDenyClick: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
    }

    @Composable
    fun configurePermission() {
        CheckPermissions()
        if (showPermissionDialog) {
            PermissionDialog(
                icon = Icons.Default.Folder,
                dialogText = permissionDialogText,
                onAllowClicked = {
                    onAllowClick?.invoke()
                    showPermissionDialog = false
                },
                onDenyClicked = {
                    onDenyClick?.invoke()
                    showPermissionDialog = false
                },
                onDismissRequest = { showPermissionDialog = false },
            )
        }
    }

    @Composable
    private fun CheckPermissions() {
        if (!getStoragePermStatus(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                permissionDialogText = getString(Strings.warning_all_files_perm_message)
                onAllowClick = {
                    requestAllFilesAccessPermission(
                        this@RobokComposeActivity,
                        this@RobokComposeActivity,
                    )
                }
            } else {
                permissionDialogText = getString(Strings.warning_storage_perm_message)
                onAllowClick = {
                    requestReadWritePermissions(
                        this@RobokComposeActivity,
                        this@RobokComposeActivity,
                    )
                }
            }
            onDenyClick = { finish() }
            showPermissionDialog = true
        }
    }

    override fun onReceive(status: Boolean) {
        if (!status) {
            showPermissionDialog = true
            permissionDialogText = getString(Strings.error_storage_perm_message)
            onAllowClick = {
                requestReadWritePermissions(this@RobokComposeActivity, this@RobokComposeActivity)
            }
            onDenyClick = { finish() }
        }
    }
}
