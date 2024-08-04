package org.gampiot.robok.feature.component.terminal

import android.content.Context
import android.view.LayoutInflater

import com.google.android.material.bottomsheet.BottomSheetDialog

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutBottomsheetTerminalBinding
import org.gampiot.robok.feature.component.log.Log

class RobokTerminal(context: Context) : BottomSheetDialog(context) {

    private val binding: LayoutBottomsheetTerminalBinding =
        LayoutBottomsheetTerminalBinding.inflate(LayoutInflater.from(context))

    val terminal = binding.terminal

    init {
        setContentView(binding.root)
        setCancelable(true)
    }

    fun addLog(value: String) {
        val log = Log(context, value)
        terminal.addView(log)
    }

    private val isDarkMode: Boolean
        get() = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

    companion object {
        const val ERROR_COLOR = "#FF0000"
        const val WARNING_COLOR = "#FFC400"
        const val SUCCESS_COLOR = "#198754"
    }
}
