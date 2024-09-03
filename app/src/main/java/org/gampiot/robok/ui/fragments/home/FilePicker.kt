package org.gampiot.robok.ui.fragments.home

import android.os.Build
import android.os.Environment
import android.content.Context
import android.app.Activity

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import dev.trindadedev.easyui.components.dialogs.PermissionDialog
import dev.trindadedev.easyui.filepicker.view.FilePickerDialog
import dev.trindadedev.easyui.filepicker.model.DialogProperties

import org.gampiot.robok.R
import org.gampiot.robok.feature.util.PermissionListener
import org.gampiot.robok.feature.util.requestReadWritePermissions
import org.gampiot.robok.feature.util.requestAllFilesAccessPermission
import org.gampiot.robok.feature.util.getStoragePermStatus
import org.gampiot.robok.feature.res.Strings

class FilePicker(
    private val context: Context,
    private val props: DialogProperties = DialogProperties()
) : FilePickerDialog(context, props), PermissionListener {

    private var permissionDialog: PermissionDialog? = null
    
    override fun show() {
        if (context is Activity) {
            if (getStoragePermStatus(context as Activity)) {
                showDialogW()
            } else {
                requestReadWritePermissionsDialog()
            }
        }
    }

    override fun onReceive(status: Boolean) {
        if (status) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager()) {
                    requestAllFilesAccessPermissionDialog()
                } else {
                    permissionDialog?.dismiss()
                }
            } else {
                permissionDialog?.dismiss()
            }
        } else {
            MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(Strings.error_storage_perm_title))
                .setMessage(context.getString(Strings.error_storage_perm_message))
                .setCancelable(false)
                .setPositiveButton(context.getString(Strings.common_word_allow)) { _, _ ->
                    requestReadWritePermissionsDialog()
                }
                .show()
        }
    }

    private fun requestReadWritePermissionsDialog() {
        permissionDialog = PermissionDialog.Builder(context)
            .setIconResId(R.drawable.ic_folder_24)
            .setText(context.getString(Strings.warning_storage_perm_message))
            .setAllowClickListener {
                requestReadWritePermissions(context, this@FilePicker)
            }
            .setDenyClickListener { }
            .build()

        permissionDialog?.show()
    }
    
    private fun requestAllFilesAccessPermissionDialog() {
        permissionDialog = PermissionDialog.Builder(context)
            .setIconResId(R.drawable.ic_folder_24)
            .setText(context.getString(Strings.warning_all_files_perm_message))
            .setAllowClickListener {
                requestAllFilesAccessPermission(context, this@FilePicker)
            }
            .setDenyClickListener { }
            .build()

        permissionDialog?.show()
    }
}
