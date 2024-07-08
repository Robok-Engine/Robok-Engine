package dev.trindade.robokide.terminal

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.trindade.robokide.R

class RobokTerminal(context: Context) : BottomSheetDialog(context) {

    private val terminal: LinearLayout
    private val bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_terminal, null)
    
    init {
        setContentView(bottomSheetView)
        setCancelable(true)
        terminal = bottomSheetView.findViewById(R.id.background_terminal)
    }

    private val isDarkMode: Boolean
        get() = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> false
            AppCompatDelegate.MODE_NIGHT_YES -> true
            else -> false
        }

    companion object {
        const val WHITE = "#FFFFFF"
        const val BLACK = "#000000"
        const val ERROR_COLOR = "#FF0000"
        const val WARNING_COLOR = "#FFC400"
        const val SUCCESS_COLOR = "#198754"
    }
}