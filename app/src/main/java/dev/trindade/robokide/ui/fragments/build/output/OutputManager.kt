package dev.trindade.robokide.ui.fragments.build.output

import android.content.Context
import android.view.ViewGroup

import dev.trindade.robokide.ui.terminal.LogView

class OutputManager(private val context: Context, private val content: ViewGroup) {

    fun addOutput(log: String) {
        val logView = LogView(context, log)
        content.addView(logView)
    }

    companion object {
        const val OUTPUT_KEY = "OUTPUT_KEY"
    }
}