package org.gampiot.robok.feature.util

import android.view.View

import androidx.activity.OnBackPressedDispatcher

fun getBackPressedClickListener(dispatcher: OnBackPressedDispatcher): View.OnClickListener {
    return View.OnClickListener { dispatcher.onBackPressed() }
}

class Helper {
     fun getBackPressedClickListener(dispatcher: OnBackPressedDispatcher): View.OnClickListener {
           return View.OnClickListener { dispatcher.onBackPressed() }
     }
}