package dev.trindade.robokide.ui.syntax

import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Matcher

class SimpleHighlighter {

    private val syntaxList: List<SyntaxScheme>
    private val mEditor: EditText?
    private val mTextView: TextView?

    constructor(editor: EditText, syntaxType: String) {
        this.mEditor = editor
        this.mTextView = null
        this.syntaxList = getSyntaxList(syntaxType)
        init()
    }

    constructor(textView: TextView, syntaxType: String) {
        this.mTextView = textView
        this.mEditor = null
        this.syntaxList = getSyntaxList(syntaxType)
        init()
    }

    private fun getSyntaxList(syntaxType: String): List<SyntaxScheme> {
        return when (syntaxType.toLowerCase()) {
            "xml" -> SyntaxScheme.XML()
            "java" -> SyntaxScheme.JAVA()
            else -> throw IllegalArgumentException("Unsupported syntax type")
        }
    }

    private fun init() {
        mEditor?.let { editor ->
            editor.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {
                    applyHighlighting(s)
                }
            })
            applyHighlighting(editor.text)
        } ?: mTextView?.let {
            applyHighlighting(it.text)
        }
    }

    private fun applyHighlighting(text: CharSequence) {
        if (text !is Editable) return
        removeSpans(text, ForegroundColorSpan::class.java)
        createHighlightSpans(text)
    }

    private fun createHighlightSpans(editable: Editable) {
        for (scheme in syntaxList) {
            val matcher = scheme.pattern.matcher(editable)
            while (matcher.find()) {
                val start = matcher.start()
                val end = matcher.end()
                editable.setSpan(ForegroundColorSpan(scheme.color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }

    private fun removeSpans(editable: Editable, type: Class<out ForegroundColorSpan>) {
        val spans = editable.getSpans(0, editable.length, type)
        for (span in spans) {
            editable.removeSpan(span)
        }
    }
}