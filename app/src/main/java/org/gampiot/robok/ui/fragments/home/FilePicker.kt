package org.gampiot.robok.ui.fragments.home

import android.content.Context
import android.app.Activity

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import dev.trindadedev.lib.filepicker.view.FilePickerDialog
import dev.trindadedev.lib.filepicker.model.DialogProperties

import org.gampiot.robok.R
import org.gampiot.robok.feature.component.dialog.PermissionDialog
import org.gampiot.robok.feature.util.PermissionListener
import org.gampiot.robok.feature.util.requestStoragePerm
import org.gampiot.robok.feature.res.Strings

class FilePicker(
    private val context: Context,
    private val props: DialogProperties = DialogProperties()
) : FilePickerDialog(context, props), PermissionListener {

    private var permissionDialog: PermissionDialog? = null

    override fun requestStoragePermission() {
        permDialog()
    }

    override fun onReceive(status: Boolean) {
        if (status) {
            permissionDialog?.dismiss()
        } else {
            MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(Strings.error_storage_perm_title))
                .setMessage(context.getString(Strings.error_storage_perm_message))
                .setCancelable(false)
                .setPositiveButton(context.getString(Strings.common_word_allow)) { _, _ ->
                    permDialog()
                }
                .show()
        }
    }

    fun permDialog() {
        if (context is Activity) {
            permissionDialog = PermissionDialog(
                context = context as Activity,
                iconResId = org.gampiot.robok.feature.component.R.drawable.ic_folder_24,
                text = context.getString(Strings.warning_storage_perm_message),
                allowClickListener = {
                     requestStoragePerm(context, this@FilePicker)
                },
                denyClickListener = { }
            )
            permissionDialog.show()
        } else {
            throw IllegalArgumentException("The context needs to be an Activity.")
        }
    }

}
