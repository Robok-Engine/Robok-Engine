package dev.trindade.robokide.ui.fragments.build.output

import android.content.Context
import android.view.ViewGroup

import dev.trindade.robokide.ui.components.log.Log

class OutputManager(private val context: Context, private val content: ViewGroup) {

    fun addOutput(log: String) {
        val logView = Log(context, log)
        content.addView(logView)
    }

    companion object {
        const val OUTPUT_KEY = "OUTPUT_KEY"
    }
}