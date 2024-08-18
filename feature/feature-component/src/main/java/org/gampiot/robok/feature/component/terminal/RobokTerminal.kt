package org.gampiot.robok.feature.component.terminal

import android.content.Context
import android.view.LayoutInflater

import androidx.appcompat.app.AppCompatDelegate

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
}
