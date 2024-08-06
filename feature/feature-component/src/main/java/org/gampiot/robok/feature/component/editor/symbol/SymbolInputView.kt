package org.gampiot.robok.feature.component.editor.symbol

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.view.View

import androidx.core.content.res.ResourcesCompat

import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.SymbolChannel

class SymbolInputView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var channel: SymbolChannel? = null

    init {
        setBackgroundColor(Color.TRANSPARENT)
        orientation = HORIZONTAL
    }

    fun bindEditor(editor: CodeEditor) {
        channel = editor.createNewSymbolChannel()
    }

    fun removeSymbols() {
        removeAllViews()
    }

    fun addSymbols(display: Array<String>, insertText: Array<String>) {
        val count = maxOf(display.size, insertText.size)

        for (i in 0 until count) {
            val btn = Button(context, null, android.R.attr.buttonStyleSmall).apply {
                text = display[i]
                setTypeface(null, android.graphics.Typeface.BOLD)
                setTextSize(16f)

                val nightModeFlags = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
                val textColor = if (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                    0xFFFDA893.toInt()
                } else {
                    0xFFFDA893.toInt()
                }
                setTextColor(textColor)
                background = ColorDrawable(0)
                layoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
            }

            btn.setOnClickListener {
                channel?.insertSymbol(btn.text.toString(), 1)
            }

            addView(btn)
        }
    }
}
