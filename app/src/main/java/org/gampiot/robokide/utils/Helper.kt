package org.gampiot.robokide.utils

import android.view.View

import androidx.activity.OnBackPressedDispatcher

fun getBackPressedClickListener(dispatcher: OnBackPressedDispatcher): View.OnClickListener {
    return View.OnClickListener { dispatcher.onBackPressed() }
}