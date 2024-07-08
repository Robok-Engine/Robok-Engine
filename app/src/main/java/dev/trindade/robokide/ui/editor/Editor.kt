package dev.trindade.robokide.ui.editor

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import dev.trindade.robokide.R

class Editor : EditText {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Editor)
            val syntaxType = typedArray.getString(R.styleable.Editor_syntaxt_type)
            typedArray.recycle()

            customAttribute?.let {
                SimpleHighlighter(this, syntaxType)
            }
        }
    }
}