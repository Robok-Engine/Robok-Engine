package org.robok.engine.core.utils

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
import android.content.res.Configuration
import android.graphics.Color
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

fun View.enableEdgeToEdgePaddingListener(
    ime: Boolean = false,
    top: Boolean = false,
    extra: ((Insets) -> Unit)? = null,
) {
    if (fitsSystemWindows) throw IllegalArgumentException("fitsSystemWindows must be disabled")

    if (this is AppBarLayout) {
        if (ime) throw IllegalArgumentException("AppBarLayout cannot have ime flag enabled")

        val collapsingToolbarLayout =
            children.find { it is CollapsingToolbarLayout } as? CollapsingToolbarLayout

        collapsingToolbarLayout?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { _, insets -> insets }
        }

        val expandedTitleMarginStart = collapsingToolbarLayout?.expandedTitleMarginStart
        val expandedTitleMarginEnd = collapsingToolbarLayout?.expandedTitleMarginEnd

        ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
            val cutoutAndBars =
                insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
                )

            (view as AppBarLayout).children.forEach { child ->
                if (child is CollapsingToolbarLayout) {
                    val leftInset =
                        if (child.layoutDirection == View.LAYOUT_DIRECTION_LTR) cutoutAndBars.left
                        else cutoutAndBars.right
                    val rightInset =
                        if (child.layoutDirection == View.LAYOUT_DIRECTION_RTL) cutoutAndBars.left
                        else cutoutAndBars.right

                    if (
                        expandedTitleMarginStart != null &&
                            expandedTitleMarginStart != (child.expandedTitleMarginStart + leftInset)
                    ) {
                        child.expandedTitleMarginStart = expandedTitleMarginStart + leftInset
                    }
                    if (
                        expandedTitleMarginEnd != null &&
                            expandedTitleMarginEnd != (child.expandedTitleMarginEnd + rightInset)
                    ) {
                        child.expandedTitleMarginEnd = expandedTitleMarginEnd + rightInset
                    }
                }
                child.setPadding(cutoutAndBars.left, 0, cutoutAndBars.right, 0)
            }
            view.setPadding(0, cutoutAndBars.top, 0, 0)

            val insetsIgnoringVisibility =
                insets.getInsetsIgnoringVisibility(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
                )

            extra?.invoke(cutoutAndBars)
            WindowInsetsCompat.Builder(insets)
                .setInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout(),
                    Insets.of(cutoutAndBars.left, 0, cutoutAndBars.right, cutoutAndBars.bottom),
                )
                .setInsetsIgnoringVisibility(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout(),
                    Insets.of(
                        insetsIgnoringVisibility.left,
                        0,
                        insetsIgnoringVisibility.right,
                        insetsIgnoringVisibility.bottom,
                    ),
                )
                .build()
        }
    } else {
        val initialPaddingLeft = paddingLeft
        val initialPaddingTop = paddingTop
        val initialPaddingRight = paddingRight
        val initialPaddingBottom = paddingBottom

        ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
            val mask =
                WindowInsetsCompat.Type.systemBars() or
                    WindowInsetsCompat.Type.displayCutout() or
                    if (ime) WindowInsetsCompat.Type.ime() else 0

            val insetsValue = insets.getInsets(mask)
            view.setPadding(
                initialPaddingLeft + insetsValue.left,
                initialPaddingTop + (if (top) insetsValue.top else 0),
                initialPaddingRight + insetsValue.right,
                initialPaddingBottom + insetsValue.bottom,
            )

            extra?.invoke(insetsValue)
            WindowInsetsCompat.Builder(insets)
                .setInsets(mask, Insets.NONE)
                .setInsetsIgnoringVisibility(mask, Insets.NONE)
                .build()
        }
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun Int.dpToPx(context: Context): Int =
    (this.toFloat() * context.resources.displayMetrics.density).toInt()

@Suppress("NOTHING_TO_INLINE")
inline fun Float.dpToPx(context: Context): Float = (this * context.resources.displayMetrics.density)

fun ComponentActivity.enableEdgeToEdgeProperly() {
    if (
        (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
            Configuration.UI_MODE_NIGHT_YES
    ) {
        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))
    } else {
        val darkScrim = Color.argb(0x80, 0x1b, 0x1b, 0x1b)
        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, darkScrim))
    }
}
