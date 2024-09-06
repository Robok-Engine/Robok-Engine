package org.gampiot.robok.feature.component.toolbar

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.google.android.material.appbar.AppBarLayout

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutCenteredTitleToolbarBinding

class CenteredTitleToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {

    private val binding: LayoutCenteredTitleToolbarBinding

    init {
        binding = LayoutCenteredTitleToolbarBinding.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater),
            this,
            true
        )

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CenteredTitleToolbar,
            defStyleAttr,
            0
        ).apply {
            try {
                binding.toolbar.title = getString(R.styleable.CenteredTitleToolbar_title) ?: ""
            } finally {
                recycle()
            }
        }
    }
}
