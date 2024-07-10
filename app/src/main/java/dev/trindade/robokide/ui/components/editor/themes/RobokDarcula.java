package dev.trindade.robokide.ui.components.editor

import android.content.Context

import androidx.core.content.ContextCompat

import io.github.rosemoe.sora.widget.EditorColorScheme
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula

class RobokDarcula(context: Context) : SchemeDarcula() {
    init {
        val customColor = ContextCompat.getColor(context, R.color.md_theme_background)
        colorPool.setColor(EditorColorScheme.WHOLE_BACKGROUND, customColor)
    }
}