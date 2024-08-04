package org.gampiot.robokide.feature.util

import android.content.Context

import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat

lateinit context : Context

fun getAttrColor(@AttrRes resId: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(resId, typedValue, true)
    return if (typedValue.resourceId != 0) {
        ContextCompat.getColor(context, typedValue.resourceId)
    } else {
        typedValue.data
    }
}

fun setResContext (context: Context) {
    this.context = context
}

typealias AndroidAttr = android.R.attr