package org.gampiot.robok.feature.component.dialog

import android.app.Dialog
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color

import androidx.fragment.app.DialogFragment
import androidx.annotation.DrawableRes

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.Material
import org.gampiot.robok.feature.component.databinding.LayoutDialogPermissionBinding

class PermissionDialog(
    @DrawableRes private val iconResId: String,
    private val text: String,
) : DialogFragment() {

    private var _binding: LayoutDialogPermissionBinding? = null
    private val binding get() = _binding!!

    private var allowClickListener: (() -> Unit)? = null
    private var denyClickListener: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, 
        container: ViewGroup?, 
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutDialogPermissionBinding.inflate(inflater, container, false)
        val view = binding.root

        @DrawableRes val iconResIdResId = requireContext().resources.getIdentifier(iconResId, "drawable", requireContext().packageName)
        binding.dialogIcon.setImageResource(iconResIdResId)
        binding.dialogText.text = Html.fromHtml(text)

        binding.buttonAllow.setOnClickListener {
            allowClickListener?.invoke()
            dismiss()
        }

        binding.buttonDeny.setOnClickListener {
            denyClickListener?.invoke()
            dismiss()
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), Material.style.Theme_Material3_DayNight_Dialog).apply {
            window?.decorView?.setBackgroundColor(0)
            setCancelable(false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setAllowClickListener(listener: () -> Unit) {
        allowClickListener = listener
    }

    fun setDenyClickListener(listener: () -> Unit) {
        denyClickListener = listener
    }
}

/* example to use 
val permissionDialog = PermissionDialog(
    iconResId = "iconResId_name",
    text = "Please grant permission.",
    backgroundColor = "#FFFFFF",
    buttonsColor = "#FF0000",
    textsColor = "#000000"
)

permissionDialog.setAllowClickListener {
    // Custom action for Allow button
}

permissionDialog.setDenyClickListener {
    // Custom action for Deny button
}

permissionDialog.show(supportFragmentManager, "PermissionDialog")

*/