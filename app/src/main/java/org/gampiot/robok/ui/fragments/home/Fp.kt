package org.gampiot.robok.ui.fragments.home

import android.content.Context

import dev.trindadedev.lib.filepicker.view.FilePickerDialog
import dev.trindadedev.lib.filepicker.model.DialogProperties

class Fp (val context: Context, val props: DialogProperties) : FilePickerDialog(context, props) {

    override fun requestStoragePermission () {
         super.requestStoragePermission()
    }
}