package org.gampiot.robokide.ui.components.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.View

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

import org.gampiot.robokide.R

class Toolbar : AppBarLayout {

    private lateinit var materialToolbar: MaterialToolbar

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.robok_toolbar, this)
        materialToolbar = findViewById(R.id.toolbar)
    }

    fun setTitleCentered(centered: Boolean) {
        materialToolbar.isTitleCentered = centered
    }
}