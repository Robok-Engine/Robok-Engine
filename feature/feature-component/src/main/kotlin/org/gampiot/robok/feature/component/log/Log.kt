package org.gampiot.robok.feature.component.log

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

import android.content.Context
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView

import org.gampiot.robok.feature.component.R

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

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, "")
    }
    
    constructor(context: Context, text: String) : super(context) {
        init(context, null, text)
    }

    private fun init(context: Context, attrs: AttributeSet?, text: String) {
        setText(text)
        textSize = 12f
        
        val paddingInPx = resources.getDimensionPixelSize(R.dimen.log_padding)
        setPadding(
             paddingInPx,
             0,
             paddingInPx, 
             0
        )
        /*
          left = paddingInPx,
          top = 0,
          right = paddingInPx,
          bottom = 0
       */
    }
}
