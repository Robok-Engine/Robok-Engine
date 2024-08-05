package org.gampiot.robok.ui.fragments.home

import android.content.Context

import androidx.annotation.NonNull

import dev.trindadedev.lib.filepicker.view.FilePickerDialog
import dev.trindadedev.lib.filepicker.model.DialogProperties

class Fp (@NonNull private val context: Context = null, private val props: DialogProperties = DialogProperties()) : FilePickerDialog(context, props) {

    override fun requestStoragePermission () {
         super.requestStoragePermission()
    }
}