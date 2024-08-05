package org.gampiot.robok.fragments.home

import dev.trindadedev.lib.filepicker.view.FilePickerDialog
import dev.trindadedev.lib.filepicker.model.DialogProperties

class Fp (val context: Context, val props: DialogProperties) : FilePickerDialog(context, props) {

    override fun requestStoragePermission () {
         super.requestStoragePermission()
    }
}