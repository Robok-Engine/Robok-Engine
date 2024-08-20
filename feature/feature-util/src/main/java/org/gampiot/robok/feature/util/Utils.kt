package org.gampiot.robok.feature.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.graphics.Insets

fun View.enableEdgeToEdgePaddingListener(ime: Boolean = false, top: Boolean = false,
                                             extra: ((Insets) -> Unit)? = null) {
        if (fitsSystemWindows) throw IllegalArgumentException("must have fitsSystemWindows disabled")
        if (this is AppBarLayout) {
            if (ime) throw IllegalArgumentException("AppBarLayout must have ime flag disabled")
            val collapsingToolbarLayout = children.find { it is CollapsingToolbarLayout } as CollapsingToolbarLayout?
            collapsingToolbarLayout?.let {
                ViewCompat.setOnApplyWindowInsetsListener(it) { _, insets -> insets }
            }
            val expandedTitleMarginStart = collapsingToolbarLayout?.expandedTitleMarginStart
            val expandedTitleMarginEnd = collapsingToolbarLayout?.expandedTitleMarginEnd
            ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
                val cutoutAndBars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
                )
                (v as AppBarLayout).children.forEach {
                    if (it is CollapsingToolbarLayout) {
                        val es = expandedTitleMarginStart!! + if (it.layoutDirection
                            == View.LAYOUT_DIRECTION_LTR) cutoutAndBars.left else cutoutAndBars.right
                        if (es != it.expandedTitleMarginStart) it.expandedTitleMarginStart = es
                        val ee = expandedTitleMarginEnd!! + if (it.layoutDirection
                            == View.LAYOUT_DIRECTION_RTL) cutoutAndBars.left else cutoutAndBars.right
                        if (ee != it.expandedTitleMarginEnd) it.expandedTitleMarginEnd = ee
                    }
                    it.setPadding(cutoutAndBars.left, 0, cutoutAndBars.right, 0)
                }
                v.setPadding(0, cutoutAndBars.top, 0, 0)
                val i = insets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()
                        or WindowInsetsCompat.Type.displayCutout())
                extra?.invoke(cutoutAndBars)
                return@setOnApplyWindowInsetsListener WindowInsetsCompat.Builder(insets)
                    .setInsets(WindowInsetsCompat.Type.systemBars()
                            or WindowInsetsCompat.Type.displayCutout(), Insets.of(cutoutAndBars.left, 0, cutoutAndBars.right, cutoutAndBars.bottom))
                    .setInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()
                            or WindowInsetsCompat.Type.displayCutout(), Insets.of(i.left, 0, i.right, i.bottom))
                    .build()
            }
        } else {
            val pl = paddingLeft
            val pt = paddingTop
            val pr = paddingRight
            val pb = paddingBottom
            ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
                val mask = WindowInsetsCompat.Type.systemBars() or
                        WindowInsetsCompat.Type.displayCutout() or
                        if (ime) WindowInsetsCompat.Type.ime() else 0
                val i = insets.getInsets(mask)
                v.setPadding(pl + i.left, pt + (if (top) i.top else 0), pr + i.right,
                    pb + i.bottom)
                extra?.invoke(i)
                return@setOnApplyWindowInsetsListener WindowInsetsCompat.Builder(insets)
                    .setInsets(mask, Insets.NONE)
                    .setInsetsIgnoringVisibility(mask, Insets.NONE)
                    .build()
            }
        }
    }