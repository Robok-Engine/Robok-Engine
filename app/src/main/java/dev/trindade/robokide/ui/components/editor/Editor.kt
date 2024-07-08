package dev.trindade.robokide.ui.editor

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import dev.trindade.robokide.ui.syntax.SimpleHighlighter
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
            val syntaxType = typedArray.getString(R.styleable.Editor_syntaxType)
            typedArray.recycle()

            syntaxType?.let {
                SimpleHighlighter(this, it)
            }

            this.setText(
                """
                package com.my.newproject;
                
                import robok.*;
                
                public class MyClass {
                
                public String myString = "oi";
                pblic int myInt = 0;
                
                public void myMethod() {
                String yourString = "oii";
                
                if (yourString.equals("RobokIDE")) {
                // do something
                }
                }
                }
            """.trimIndent()
            )
        }
    }
}