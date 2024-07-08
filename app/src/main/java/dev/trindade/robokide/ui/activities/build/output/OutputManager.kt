package dev.trindade.robokide.ui.activities.build.output

import android.content.Context
import android.view.View

import dev.trindade.robokide.ui.terminal.LogView
import dev.trindade.robokide.R

class OutputManager (context: Context, content: View) {

    public fun addOutput (log: String) {
        val logView = LogView(context, log)
        content.addView(logView)
    }

}