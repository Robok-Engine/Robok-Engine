package org.robok.engine.core.utils

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity
import android.app.Application
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

class KeyboardUtil(private val applicationClass: Application) {

  fun showSoftInput() {
    val imm = applicationClass.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.showSoftInput(null, InputMethodManager.SHOW_IMPLICIT)
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
    val imm = applicationClass.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.let {
      view.isFocusable = true
      view.isFocusableInTouchMode = true
      view.requestFocus()
      it.showSoftInput(
        view,
        flags,
        object : ResultReceiver(Handler(Looper.getMainLooper())) {
          override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            if (
              resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN ||
                resultCode == InputMethodManager.RESULT_HIDDEN
            ) {
              showSoftInput()
            }
          }
        },
      )
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
        view =
          focusView
            ?: EditText(window.context).apply {
              tag = "keyboardTagView"
              (decorView as ViewGroup).addView(this, 0, 0)
            }
        view.requestFocus()
      }
      hideSoftInput(view)
    }
  }

  fun hideSoftInput(view: View) {
    val imm = applicationClass.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
  }

  fun isSoftInputVisible(act: Activity): Boolean {
    return false
  }
}
