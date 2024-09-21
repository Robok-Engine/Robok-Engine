package org.gampiot.robok.feature.component.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import com.google.android.material.loadingindicator.LoadingIndicator

import org.gampiot.robok.feature.component.databinding.LayoutLoadingDialogBinding

/*
* A Basic Dialog with MDC Loading Indicator.
* @author Aquiles Trindade (trindadedev).
*/

class LoadingDialog(context: Context) : Dialog(context) {

    private lateinit var binding: LayoutLoadingDialogBinding
    private val c: Context = context
    private lateinit var loadingIndicator: LoadingIndicator 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoadingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingIndicator = binding.loadingIndicator
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
