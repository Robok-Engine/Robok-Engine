package dev.trindade.robokide.ui.components.preferences

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import dev.trindade.robokide.databinding.PreferenceGroupBinding

class PreferenceGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: PreferenceGroupBinding =
        PreferenceGroupBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PreferenceGroup,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.PreferenceGroup_title) ?: ""
                binding.preferenceGroupTitle.text = title
            } finally {
                recycle()
            }
        }
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun addPreference(view: View) {
        binding.preferenceGroupContent.addView(view)
    }

    override fun setOnClickListener(listener: OnClickListener?) {
        binding.preferenceGroup.setOnClickListener(listener)
    }
}