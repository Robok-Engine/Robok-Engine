package org.gampiot.robok.feature.util

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

import androidx.annotation.NonNull
import androidx.annotation.Nullable

import org.gampiot.robok.feature.util.application.RobokApplication

open class KeyboardUtil {

    open fun showSoftInput() {
        val imm = RobokApplication.instance.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.showSoftInput(null, InputMethodManager.SHOW_IMPLICIT)
    }

    open fun showSoftInput(activity: Activity?) {
        if (activity != null && !isSoftInputVisible(activity)) {
            showSoftInput()
        }
    }

    open fun showSoftInput(view: View) {
        showSoftInput(view, 0)
    }

    open fun showSoftInput(view: View, flags: Int) {
        val imm = RobokApplication.instance.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.let {
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.requestFocus()
            it.showSoftInput(view, flags, object : ResultReceiver(Handler(Looper.getMainLooper())) {
                override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                    if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN || resultCode == InputMethodManager.RESULT_HIDDEN) {
                        showSoftInput()
                    }
                }
            })
        }
    }

    open fun hideSoftInput(activity: Activity?) {
        activity?.let { hideSoftInput(it.window) }
    }

    open fun hideSoftInput(window: Window?) {
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

    open fun hideSoftInput(view: View) {
        val imm = RobokApplication.instance.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
    
    open fun isSoftInputVisible (act: Activity): Boolean {
        return false
    }
}
