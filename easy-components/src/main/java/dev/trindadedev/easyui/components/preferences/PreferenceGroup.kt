package dev.trindadedev.easyui.components.preferences

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import dev.trindadedev.easyui.components.R

class PreferenceGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    public val preferenceGroupTitle: TextView
    public val preferenceGroupContent: LinearLayout
    public val preferenceGroup: View

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_preference_group, this, true)

        preferenceGroupTitle = findViewById(R.id.preference_group_title)
        preferenceGroupContent = findViewById(R.id.preference_group_content)
        preferenceGroup = findViewById(R.id.preference_group)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PreferenceGroup,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.PreferenceGroup_preferenceGroupTitle) ?: ""
                preferenceGroupTitle.text = title
            } finally {
                recycle()
            }
        }
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun addPreference(view: View) {
        preferenceGroupContent.addView(view)
    }

    override fun setOnClickListener(listener: OnClickListener?) {
        preferenceGroup.setOnClickListener(listener)
    }
}