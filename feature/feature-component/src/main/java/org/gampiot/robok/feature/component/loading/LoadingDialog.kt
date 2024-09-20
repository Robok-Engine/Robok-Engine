package org.gampiot.robok.feature.component.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import org.gampiot.robok.feature.component.databinding.LayoutLoadingDialogBinding

class LoadingDialog(context: Context) : Dialog(context) {

    private lateinit var binding: LayoutLoadingDialogBinding
    private val c: Context = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoadingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
