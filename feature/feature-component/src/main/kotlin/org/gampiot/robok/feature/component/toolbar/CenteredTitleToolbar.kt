package org.gampiot.robok.feature.component.toolbar

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

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
