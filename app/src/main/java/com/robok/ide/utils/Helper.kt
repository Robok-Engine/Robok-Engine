package com.robok.ide.utils

import androidx.activity.OnBackPressedDispatcher
import android.view.View

fun getBackPressedClickListener(dispatcher: OnBackPressedDispatcher): View.OnClickListener {
    return View.OnClickListener { dispatcher.onBackPressed() }
}