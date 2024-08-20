package org.gampiot.robok.feature.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.graphics.Insets

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.util.getBackPressedClickListener

abstract class RobokPreferenceFragment(
    private val str: Int,
    private val fragmentCreator: () -> RobokFragment 
) : PreferenceFragmentCompat() {

    @IdRes
    var layoutResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(MaterialSharedAxis.X, true))
        setReturnTransition(MaterialSharedAxis(MaterialSharedAxis.X, false))
        setExitTransition(MaterialSharedAxis(MaterialSharedAxis.X, true))
        setReenterTransition(MaterialSharedAxis(MaterialSharedAxis.X, false))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_top_settings, container, false)
        val topAppBar = rootView.findViewById<MaterialToolbar>(R.id.topAppBar)
        val collapsingToolbar = rootView.findViewById<CollapsingToolbarLayout>(R.id.collapsingtoolbar)

        rootView.findViewById<AppBarLayout>(R.id.appbarlayout).enableEdgeToEdgePaddingListener()
        collapsingToolbar.title = getString(str)

        topAppBar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        childFragmentManager
            .beginTransaction()
            .addToBackStack(System.currentTimeMillis().toString())
            .add(R.id.settings, fragmentCreator())
            .commit()

        return rootView
    }

    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
    
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(layoutResId, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun setFragmentLayoutResId(@IdRes layoutResId: Int) {
        this.layoutResId = layoutResId
    }

    fun getFragmentLayoutResId(): Int {
        return layoutResId
    }

    // Função para habilitar Listener de Padding para Edge-to-Edge
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
}
