package org.gampiot.robok.feature.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.feature.util.getBackPressedClickListener
import org.gampiot.robok.logic.enableEdgeToEdgePaddingListener

abstract class RobokPreferenceFragment(
    private val str: Int,
    private val fragmentCreator: () -> Fragment
) : Fragment() {

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

    fun setFragmentLayoutResId(@IdRes layoutResId: Int) {
        this.layoutResId = layoutResId
    }

    fun getFragmentLayoutResId(): Int {
        return layoutResId
    }
}
