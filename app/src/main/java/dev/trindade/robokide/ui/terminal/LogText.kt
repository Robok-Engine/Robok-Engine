package dev.trindade.robokide.ui.terminal

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

import dev.trindade.robokide.ui.syntax.SimpleHighlighter

class LogText : TextView {

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
    }
}