package org.gampiot.robokide.feature.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat

class ResUtils {
 
     private lateinit var context: Context
     
     fun getAttrColor(@AttrRes resId: Int): Int {
          val typedValue = TypedValue()
          context.theme.resolveAttribute(resId, typedValue, true)
          return if (typedValue.resourceId != 0) {
              ContextCompat.getColor(context, typedValue.resourceId)
          } else {
              typedValue.data
          }
     }
     
     fun setResContext(ctx: Context) {
          context = ctx
     }
}

typealias AndroidAttr = android.R.attr