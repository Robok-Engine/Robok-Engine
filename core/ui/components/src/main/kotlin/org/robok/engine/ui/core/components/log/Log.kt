package org.robok.engine.ui.core.components.log

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
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import org.robok.engine.ui.core.components.R

/*
 * A Basic TextView to use like Log.i(..)
 * @author Aquiles Trindade (trindadedev).
 */

class Log : AppCompatTextView {

  constructor(context: Context) : super(context) {
    init(context, null, "")
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init(context, attrs, "")
  }

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
  ) : super(context, attrs, defStyleAttr) {
    init(context, attrs, "")
  }

  constructor(context: Context, text: String) : super(context) {
    init(context, null, text)
  }

  private fun init(context: Context, attrs: AttributeSet?, text: String) {
    setText(text)
    textSize = 12f

    val paddingInPx = resources.getDimensionPixelSize(R.dimen.log_padding)
    setPadding(paddingInPx, 0, paddingInPx, 0)
    /*
       left = paddingInPx,
       top = 0,
       right = paddingInPx,
       bottom = 0
    */
  }
}
