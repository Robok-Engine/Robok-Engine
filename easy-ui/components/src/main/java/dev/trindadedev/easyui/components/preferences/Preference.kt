package dev.trindadedev.easyui.components.preferences

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import dev.trindadedev.easyui.components.R

class Preference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    public val preferenceTitle: TextView
    public val preferenceDescription: TextView
    public val preference: View

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_preference, this, true)

        preferenceTitle = findViewById(R.id.preference_title)
        preferenceDescription = findViewById(R.id.preference_description)
        preference = findViewById(R.id.preference)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Preference,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.Preference_preferenceTitle) ?: ""
                val description = getString(R.styleable.Preference_preferenceDescription) ?: ""
                preferenceTitle.text = title
                preferenceDescription.text = description
            } finally {
                recycle()
            }
        }
    }

    fun setPreferenceClickListener(listenerClick: View.OnClickListener) {
        preference.setOnClickListener(listenerClick)
    }
    
    fun setTitle(value: String) {
         preferenceTitle.text = value
    }
    
    fun setDescription(value: String) {
         preferenceDescription.text = value
    }
}