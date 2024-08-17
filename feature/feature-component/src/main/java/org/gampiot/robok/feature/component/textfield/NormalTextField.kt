package org.gampiot.robok.feature.component.textfield

import android.content.Context
import android.util.AttributeSet

import dev.trindadedev.lib.ui.components.textfield.TInput

class NormalTextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TInput(context, attrs, defStyleAttr) {

    fun setCornerRadius(radii: Float) {
        textInputLayout.setBoxCornerRadii(radii, radii, radii, radii)
    }
}

