package org.gampiot.robok.feature.util

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import org.gampiot.robok.feature.util.application.RobokApp

object KeyboardUtils {

    private fun showSoftInput() {
        val robokApp = RobokApp()
        val imm = robokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun showSoftInput(activity: Activity?) {
        if (activity != null && !isSoftInputVisible(activity)) {
            showSoftInput()
        }
    }

    fun showSoftInput(view: View) {
        showSoftInput(view, 0)
    }

    fun showSoftInput(view: View, flags: Int) {
        val robokApp = RobokApp()
        val imm = robokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.let {
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.requestFocus()
            it.showSoftInput(view, flags, object : ResultReceiver(Handler()) {
                override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                    if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN || resultCode == InputMethodManager.RESULT_HIDDEN) {
                        showSoftInput()
                    }
                }
            })
        }
    }

    fun hideSoftInput(activity: Activity?) {
        activity?.let { hideSoftInput(it.window) }
    }

    fun hideSoftInput(window: Window?) {
        window?.let {
            var view = it.currentFocus
            if (view == null) {
                val decorView = it.decorView
                val focusView = decorView.findViewWithTag<View>("keyboardTagView")
                view = focusView ?: EditText(window.context).apply {
                    tag = "keyboardTagView"
                    (decorView as ViewGroup).addView(this, 0, 0)
                }
                view.requestFocus()
            }
            hideSoftInput(view)
        }
    }

    fun hideSoftInput(view: View) {
        val robokApp = RobokApp()
        val imm = robokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun isSoftInputVisible(activity: Activity): Boolean {
        return false
    }
}

