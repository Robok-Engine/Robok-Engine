package dev.trindade.robokide.ui.syntax

import android.graphics.Color
import java.util.regex.Pattern

class SyntaxScheme(val pattern: Pattern, val color: Int) {

    companion object {
        const val COMMENTS_COLOR = "#757575"
        const val NOT_WORD_COLOR = "#656600"
        const val NUMBERS_COLOR = "#006766"
        const val PRIMARY_COLOR = "#000000"
        const val QUOTES_COLOR = "#008800"
        const val SECONDARY_COLOR = "#2196f3"
        const val VARIABLE_COLOR = "#660066"

        private val mJavaPattern = Array(12) { "" }
        private val mXmlPattern = Array(4) { "" }

        init {
            initializeJavaPattern()
            initializeXmlPattern()
        }

        @JvmStatic
        fun JAVA(): List<SyntaxScheme> {
            return listOf(
                SyntaxScheme(Pattern.compile(mJavaPattern[0] + mJavaPattern[1]), Color.parseColor(PRIMARY_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[2] + mJavaPattern[3] + mJavaPattern[4]), Color.parseColor(SECONDARY_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[5]), Color.parseColor(NUMBERS_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[11]), Color.parseColor(NOT_WORD_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[6]), Color.parseColor(PRIMARY_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[10]), Color.parseColor(VARIABLE_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[7]), Color.parseColor(NUMBERS_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[8]), Color.parseColor(QUOTES_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[9]), Color.parseColor(COMMENTS_COLOR))
            )
        }

        @JvmStatic
        fun XML(): List<SyntaxScheme> {
            return listOf(
                SyntaxScheme(Pattern.compile(mJavaPattern[0] + mJavaPattern[1]), Color.parseColor(PRIMARY_COLOR)),
                SyntaxScheme(Pattern.compile(mXmlPattern[2]), Color.parseColor(SECONDARY_COLOR)),
                SyntaxScheme(Pattern.compile(mXmlPattern[0]), Color.parseColor(VARIABLE_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[11]), Color.parseColor(NOT_WORD_COLOR)),
                SyntaxScheme(Pattern.compile(mXmlPattern[3]), Color.parseColor(SECONDARY_COLOR)),
                SyntaxScheme(Pattern.compile(mXmlPattern[1]), Color.parseColor(COMMENTS_COLOR)),
                SyntaxScheme(Pattern.compile(mJavaPattern[8]), Color.parseColor(QUOTES_COLOR))
            )
        }

        private fun initializeJavaPattern() {
            mJavaPattern[0] = "\\b(out|print|println|valueOf|toString|concat|equals|for|while|switch|getText\\b"
            mJavaPattern[1] = "|println|printf|print|out|parseInt|round|sqrt|charAt|compareTo|compareToIgnoreCase|concat|contains|contentEquals|equals|length|toLowerCase|trim|toUpperCase|toString|valueOf|substring|startsWith|split|replace|replaceAll|lastIndexOf|size)\\b"
            mJavaPattern[2] = "\\b(public|private|protected|void|switch|case|class|import|package|extends|Activity|TextView|EditText|LinearLayout|CharSequence|String|int|onCreate|ArrayList|float|if|else|for|static|Intent|Button|SharedPreferences\\b"
            mJavaPattern[3] = "|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|interface|long|native|new|package|private|protected|"
            mJavaPattern[4] = "public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)\\b"
            mJavaPattern[5] = "\\b0x[0-9a-f]{6,8}|\\b([0-9]+)\\b"
            mJavaPattern[6] = "(\\w+)(\\()+"
            mJavaPattern[7] = "(?:@)\\w+\\b"
            mJavaPattern[8] = "\"(.*)\"|'(.*)'"
            mJavaPattern[9] = "/\\*(?:.|[\\n\\r])*?\\*/|//.*"
            mJavaPattern[10] = "\\b(?:[A-Z])[a-zA-Z0-9]+\\b"
            mJavaPattern[11] = "(?!\\s)\\W"
        }

        private fun initializeXmlPattern() {
            mXmlPattern[0] = "\\w+:\\w+"
            mXmlPattern[1] = "<!--(?:.|[\\n\\r])*?-->|//\\*(?:.|[\\n\\r])*?\\*//|//.*"
            mXmlPattern[2] = "<([A-Za-z][A-Za-z0-9]*)\\b[^>]*>|</([A-Za-z][A-Za-z0-9]*)\\b[^>]*>|(.+?):(.+?);"
            mXmlPattern[3] = "[<>/]"
        }
    }

    fun getPrimarySyntax(): SyntaxScheme {
        return SyntaxScheme(Pattern.compile(mJavaPattern[6]), Color.parseColor(PRIMARY_COLOR))
    }
}