package org.gampiot.robok.core.utils.base

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
import android.os.Environment
import android.os.Build
import android.graphics.Color
import android.content.res.Configuration
import android.view.View
import android.view.WindowInsets

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat

import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import dev.chrisbanes.insetter.Insetter
import dev.trindadedev.easyui.components.dialogs.PermissionDialog

import org.gampiot.robok.core.utils.R
import org.gampiot.robok.core.utils.requestReadWritePermissions
import org.gampiot.robok.core.utils.requestAllFilesAccessPermission
import org.gampiot.robok.core.utils.getStoragePermStatus
import org.gampiot.robok.core.utils.getBackPressedClickListener
import org.gampiot.robok.core.utils.PermissionListener
import org.gampiot.robok.strings.Strings

open class RobokActivity : AppCompatActivity(), PermissionListener {

    private var permissionDialog: PermissionDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (!getStoragePermStatus(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                 requestAllFilesAccessPermissionDialog()
            } else {
                requestReadWritePermissionsDialog()
            }
        }
    }
    
    fun handleInsetts(rootView: View) {
        Insetter.builder()
            .padding(WindowInsetsCompat.Type.navigationBars())
            .applyToView(rootView);
    }

    private fun requestReadWritePermissionsDialog() {
        if (isFinishing || isDestroyed) {
            return
        }
        permissionDialog = PermissionDialog.Builder(this)
            .setIconResId(R.drawable.ic_folder_24)
            .setText(getString(Strings.warning_storage_perm_message))
            .setAllowClickListener {
                requestReadWritePermissions(this@RobokActivity, this@RobokActivity)
            }
            .setDenyClickListener {
                finish()
            }
            .build()

        permissionDialog?.show()
    }

    private fun requestAllFilesAccessPermissionDialog() {
        if (isFinishing || isDestroyed) {
            return
        }
        permissionDialog = PermissionDialog.Builder(this)
            .setIconResId(R.drawable.ic_folder_24)
            .setText(getString(Strings.warning_all_files_perm_message))
            .setAllowClickListener {
                requestAllFilesAccessPermission(this@RobokActivity, this@RobokActivity)
            }
            .setDenyClickListener {
                finish()
            }
            .build()

        permissionDialog?.show()
    }

    open fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }

    open fun isDarkMode(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onReceive(status: Boolean) {
        if (status) {
            if (Build.VERSION.SDK_INT >= 9) {
              MaterialAlertDialogBuilder(this)
                .setTitle(getString(Strings.error_storage_perm_title))
                .setMessage(getString(Strings.error_storage_perm_message))
                .setCancelable(false)
                .setPositiveButton(Strings.common_word_allow) { _, _ ->
                    requestReadWritePermissionsDialog()
                }
                .show()
            }
        }
    }
}
