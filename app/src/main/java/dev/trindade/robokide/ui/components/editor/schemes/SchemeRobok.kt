package dev.trindade.robokide.ui.components.editor.schemes

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

class SchemeRobok(context: Context) : SchemeDarcula() {

    val context : Context

    init {
        this.context = context
        setColor(EditorColorScheme.WHOLE_BACKGROUND, getAttrColor(android.R.attr.colorBackground)) // set the background color
        setColor(EditorColorScheme.CURRENT_LINE, getAttrColor(com.google.android.material.R.attr.colorOnBackground)) // set the current line color
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getAttrColor(com.google.android.material.R.attr.colorSurfaceContainerHigh)) // set color bar for line numbers
    }

    private fun getAttrColor(@AttrRes resId: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(resId, typedValue, true)
        return if (typedValue.resourceId != 0) {
            ContextCompat.getColor(context, typedValue.resourceId)
        } else {
            typedValue.data
        }
    }
}