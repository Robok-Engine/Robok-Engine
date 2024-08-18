package org.gampiot.robok.feature.component.terminal

import android.content.Context
import android.view.LayoutInflater

import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.bottomsheet.BottomSheetDialog

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutBottomsheetTerminalRBinding
import org.gampiot.robok.feature.component.log.Log

class RobokTerminalR(context: Context) : BottomSheetDialog(context) {

    private val binding: LayoutBottomsheetTerminalRBinding =
        LayoutBottomsheetTerminalRBinding.inflate(LayoutInflater.from(context))

    val recycler = binding.recycler

    init {
        setContentView(binding.root)
        setCancelable(true)
        binding.recycler.layoutManager = LinearLayoutManager(context)
    }

    private val isDarkMode: Boolean
        get() = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

    companion object {
        const val ERROR_COLOR = "#FF0000"
        const val WARNING_COLOR = "#FFC400"
        const val SUCCESS_COLOR = "#198754"
    }
}
