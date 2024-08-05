package org.gampiot.robok.feature.component.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View

import androidx.annotation.DrawableRes

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutDialogPermissionBinding

class PermissionDialog(
    context: Context,
    @DrawableRes private var iconResId: Int = R.drawable.ic_dot_24,
    private var text: String = "Default text",
    private var allowClickListener: (() -> Unit)? = null,
    private var denyClickListener: (() -> Unit)? = null
) : Dialog(context) {

    private var _binding: LayoutDialogPermissionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = LayoutDialogPermissionBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        binding.dialogIcon.setImageResource(iconResId)
        binding.dialogText.text = Html.fromHtml(text)

        binding.buttonAllow.setOnClickListener {
            allowClickListener?.invoke()
            dismiss()
        }

        binding.buttonDeny.setOnClickListener {
            denyClickListener?.invoke()
            dismiss()
        }

        window?.decorView?.setBackgroundColor(0)
        setCancelable(false)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }
    
    fun setIconResId(@DrawableRes resId: Int) {
        iconResId = resId
        binding.dialogIcon.setImageResource(iconResId)
    }

    fun setText(text: String) {
        this.text = text
        binding.dialogText.text = Html.fromHtml(text)
    }

    fun setAllowClickListener(listener: () -> Unit) {
        allowClickListener = listener
    }

    fun setDenyClickListener(listener: () -> Unit) {
        denyClickListener = listener
    }
}
