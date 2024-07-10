package dev.trindade.robokide.ui.components.textfield

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.trindade.robokide.databinding.LayoutRbkTextfieldBinding

class RbkTextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutRbkTextfieldBinding = LayoutRbkTextfieldBinding.inflate(
        LayoutInflater.from(context), 
        this, 
        true
    )

    var hint: CharSequence?
        get() = binding.background.hint
        set(value) {
            binding.background.hint = value
        }

    var placeholderText: CharSequence?
        get() = binding.background.placeholderText
        set(value) {
            binding.background.placeholderText = value
        }

    var startIconDrawableRes: Int
        get() = 0
        set(value) {
            binding.background.startIconDrawable = ContextCompat.getDrawable(context, value)
        }

    var text: CharSequence?
        get() = binding.edittext.text
        set(value) {
            binding.edittext.setText(value)
        }

    init {
    }
}