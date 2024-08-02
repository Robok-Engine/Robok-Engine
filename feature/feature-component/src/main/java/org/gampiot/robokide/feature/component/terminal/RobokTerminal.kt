package org.gampiot.robokide.feature.component.terminal

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatDelegate

import com.google.android.material.bottomsheet.BottomSheetDialog

import org.gampiot.robokide.feature.component.R
import org.gampiot.robokide.feature.component.log.Log

class RobokTerminal(context: Context) : BottomSheetDialog(context) {

    public val terminal: LinearLayout
    private val bottomSheetView = LayoutInflater.from(context).inflate(org.gampiot.robokide.feature.res.R.layout.dialog_terminal, null)
    
    init {
        setContentView(bottomSheetView)
        setCancelable(true)
        terminal = bottomSheetView.findViewById(org.gampiot.robokide.feature.res.R.id.terminal)
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