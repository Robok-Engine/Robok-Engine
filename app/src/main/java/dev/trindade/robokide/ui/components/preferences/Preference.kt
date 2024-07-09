package dev.trindade.robokide.ui.components.preferences

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.PreferenceBinding

class Preference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: PreferenceBinding = PreferenceBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Preference,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.Preference_preferenceTitle) ?: ""
                val description = getString(R.styleable.Preference_preferenceDescription) ?: ""
                binding.preferenceTitle.text = title
                binding.preferenceDescription.text = description
            } finally {
                recycle()
            }
        }
    }

    fun setOnClickListener(listenerClick: View.OnClickListener) {
        binding.preference.setOnClickListener(listenerClick)
    }
}