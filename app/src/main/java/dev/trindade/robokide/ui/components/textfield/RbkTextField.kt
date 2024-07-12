package dev.trindade.robokide.ui.components.textfield

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.text.Editable
import android.text.TextUtils

import androidx.core.content.ContextCompat

import com.google.android.material.textfield.TextInputEditText

import dev.trindade.robokide.R
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

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RbkTextField, defStyleAttr, 0)
        
        binding.background.hint = typedArray.getString(R.styleable.RbkTextField_rbkTextFieldHint)
        binding.background.placeholderText = typedArray.getString(R.styleable.RbkTextField_rbkTextFieldPlaceholderText)
        
        val textString: String? = typedArray.getString(R.styleable.RbkTextField_rbkTextFieldText)
        val editableText: Editable? = if (!TextUtils.isEmpty(textString)) {
            Editable.Factory.getInstance().newEditable(textString)
        } else {
            null
        }
        binding.edittext.text = editableText
        
        val startIconDrawableRes = typedArray.getResourceId(R.styleable.RbkTextField_rbkTextFieldStartIconDrawable, 0)
        if (startIconDrawableRes != 0) {
            binding.background.startIconDrawable = ContextCompat.getDrawable(context, startIconDrawableRes)
        }
        
        // Always recycle the TypedArray
        typedArray.recycle()
    }

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
}