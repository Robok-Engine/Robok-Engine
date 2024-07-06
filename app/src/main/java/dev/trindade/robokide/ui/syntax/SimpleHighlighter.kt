package dev.trindade.robokide.ui.syntax

import android.text.*
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import android.widget.TextView

class SimpleHighlighter(private val mEditor: EditText?, syntaxType: String) {

    private val syntaxList: List<SyntaxScheme>
    private val mTextView: TextView? = null

    init {
        this.syntaxList = getSyntaxList(syntaxType)
        init()
    }

    constructor(textView: TextView, syntaxType: String) : this(null, syntaxType) {
        mTextView = textView
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
                    removeSpans(s, ForegroundColorSpan::class.java)
                    createHighlightSpans(syntaxList, s)
                }
            })
            removeSpans(editor.text, ForegroundColorSpan::class.java)
            createHighlightSpans(syntaxList, editor.text)
        } ?: mTextView?.let { textView ->
            val text = textView.text
            if (text is Editable) {
                removeSpans(text, ForegroundColorSpan::class.java)
                createHighlightSpans(syntaxList, text)
            } else {
                val builder = SpannableStringBuilder(text)
                removeSpans(builder, ForegroundColorSpan::class.java)
                createHighlightSpans(syntaxList, builder)
                textView.text = builder
            }
        }
    }

    private fun createHighlightSpans(syntaxList: List<SyntaxScheme>, editable: Editable) {
        for (scheme in syntaxList) {
            val matcher = scheme.pattern.matcher(editable)
            while (matcher.find()) {
                if (scheme == scheme.primarySyntax) {
                    editable.setSpan(ForegroundColorSpan(scheme.color), matcher.start(), matcher.end() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                } else {
                    editable.setSpan(ForegroundColorSpan(scheme.color), matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
    }

    private fun removeSpans(editable: Editable, type: Class<out CharacterStyle>) {
        val spans = editable.getSpans(0, editable.length, type)
        for (span in spans) {
            editable.removeSpan(span)
        }
    }

    private fun removeSpans(spannable: Spannable, type: Class<out CharacterStyle>) {
        val spans = spannable.getSpans(0, spannable.length, type)
        for (span in spans) {
            spannable.removeSpan(span)
        }
    }
}