package org.gampiot.robok.feature.component.dialog

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.DialogFragment
import androidx.annotation.DrawableRes

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutDialogPermissionBinding

class PermissionDialog : DialogFragment() {

    private var _binding: LayoutDialogPermissionBinding? = null
    private val binding get() = _binding!!

    private var allowClickListener: (() -> Unit)? = null
    private var denyClickListener: (() -> Unit)? = null

    @DrawableRes private var iconResId: Int = R.drawable.ic_dot_24 
    private var text: String = "Default text"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutDialogPermissionBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.dialogIcon.setImageResource(iconResId)     
        binding.dialogText.text = Html.fromHtml(text)
        
        binding.buttonAllow.setOnClickListener {
            allowClickListener?.invoke()
        }
        binding.buttonDeny.setOnClickListener {
            denyClickListener?.invoke()
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext()).apply {
            window?.decorView?.setBackgroundColor(0)
            setCancelable(false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setIconResId(@DrawableRes resId: Int) {
        iconResId = resId
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setAllowClickListener(listener: () -> Unit) {
        allowClickListener = listener
    }

    fun setDenyClickListener(listener: () -> Unit) {
        denyClickListener = listener
    }
}
