package dev.trindade.robokide.ui.components.editor.themes

/* 
 *  Class responsible for changing the colors of the Darcula Theme.
*/
import android.content.Context
import android.util.TypedValue
import androidx.core.content.ContextCompat
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula

class RobokDarcula(context: Context) : SchemeDarcula() {
    init {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.colorBackground, typedValue, true)
        
        val backgroundColor = if (typedValue.resourceId != 0) {
            ContextCompat.getColor(context, typedValue.resourceId)
        } else {
            typedValue.data
        }
        
        setColor(EditorColorScheme.WHOLE_BACKGROUND, backgroundColor)
    }
}