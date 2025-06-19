package org.robok.engine.res

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

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat

class ResUtils(val context: Context) {

  fun getAttrColor(@AttrRes attrResID: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrResID, typedValue, true)
    return if (typedValue.resourceId != 0) {
      ContextCompat.getColor(context, typedValue.resourceId)
    } else {
      typedValue.data
    }
  }

  fun getColor(@AttrRes attrResID: Int): Int = ContextCompat.getColor(context, attrResID)
}
