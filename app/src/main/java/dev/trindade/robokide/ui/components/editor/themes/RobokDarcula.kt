package dev.trindade.robokide.ui.components.editor.themes

/* 
 *  Class responsible for changing the colors of the Darcula Theme.
*/

import android.content.Context
import android.util.TypedValue

import androidx.annotation.AttrRes

import androidx.core.content.ContextCompat

import io.github.rosemoe.sora.widget.schemes.SchemeDarcula
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme

import dev.trindade.robokide.R

class RobokDarcula(context: Context) : SchemeDarcula() {
    init {
        setColor(EditorColorScheme.WHOLE_BACKGROUND, getColor(android.R.attr.colorBackground)) // set the background color
        setColor(EditorColorScheme.CURRENT_LINE, getColor(R.attr.colorOnBackground)) // set the current line color
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getColor(R.attr.colorSurfaceContainerHigh)) // set color bar for line numbers
    }

    private fun getColor(@AttrRes resId: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(resId, typedValue, true)
        return if (typedValue.resourceId != 0) {
            ContextCompat.getColor(context, typedValue.resourceId)
        } else {
            typedValue.data
        }
    }
}