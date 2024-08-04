package org.gampiot.robok.feature.component.log

import android.content.Context
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView

import org.gampiot.robok.feature.component.R

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
        //setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx)
    }
}