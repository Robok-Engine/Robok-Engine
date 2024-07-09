package dev.trindade.robokide.ui.syntax

import android.graphics.Color
import java.util.regex.Pattern

class SyntaxScheme(val pattern: Pattern, val color: Int) {

    companion object {
        // Standard colors for different token types
        val PRIMARY_COLOR: Int = Color.parseColor("#000000")
        val SECONDARY_COLOR: Int = Color.parseColor("#2196f3")
        val VARIABLE_COLOR: Int = Color.parseColor("#660066")
        val NUMBERS_COLOR: Int = Color.parseColor("#006766")
        val QUOTES_COLOR: Int = Color.parseColor("#008800")
        val COMMENTS_COLOR: Int = Color.parseColor("#757575")
        val NOT_WORD_COLOR: Int = Color.parseColor("#656600")

        // Regular expression patterns for Java and XML
        private val JAVA_PATTERNS = arrayOf(
            "\\b(out|print|println|valueOf|toString|concat|equals|for|while|switch|getText)\\b",
            "\\b(public|private|protected|void|switch|case|class|import|package|extends|Activity|TextView|EditText|LinearLayout|CharSequence|String|int|onCreate|ArrayList|float|if|else|for|static|Intent|Button|SharedPreferences|return|super)\\b",
            "\\b(abstract|assert|boolean|break|byte|case|catch|char|const|continue|default|do|double|else|enum|final|finally|float|goto|if|implements|instanceof|interface|long|native|new|short|strictfp|synchronized|this|throw|throws|transient|try|volatile|true|false|null)\\b",
            "\\b(0x[0-9a-fA-F]+|[0-9]+)\\b",
            "\"([^\"]*)\"|'([^']*)'",
            "(\\/\\/[^\\n]*|\\/\\*(.|\\n)*?\\*\\/)",
            "\\b([A-Z]\\w+)\\b",
            "\\W"
        )

        private val XML_PATTERNS = arrayOf(
            "<([A-Za-z][A-Za-z0-9]*)\\b[^>]*>|</([A-Za-z][A-Za-z0-9]*)\\b[^>]*>",
            "<!--(?:.|[\\n\\r])*?-->",
            "\\w+:\\w+",
            "[<>/]"
        )

        fun JAVA(): ArrayList<SyntaxScheme> {
            val arrayList = ArrayList<SyntaxScheme>()
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[0]), PRIMARY_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[1]), SECONDARY_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[2]), SECONDARY_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[3]), NUMBERS_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[4]), QUOTES_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[5]), COMMENTS_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[6]), VARIABLE_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(JAVA_PATTERNS[7]), NOT_WORD_COLOR))
            return arrayList
        }

        fun XML(): ArrayList<SyntaxScheme> {
            val arrayList = ArrayList<SyntaxScheme>()
            arrayList.add(SyntaxScheme(Pattern.compile(XML_PATTERNS[0]), PRIMARY_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(XML_PATTERNS[1]), COMMENTS_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(XML_PATTERNS[2]), VARIABLE_COLOR))
            arrayList.add(SyntaxScheme(Pattern.compile(XML_PATTERNS[3]), SECONDARY_COLOR))
            return arrayList
        }
    }

    fun getPattern(): Pattern {
        return pattern
    }

    fun getColor(): Int {
        return color
    }
}