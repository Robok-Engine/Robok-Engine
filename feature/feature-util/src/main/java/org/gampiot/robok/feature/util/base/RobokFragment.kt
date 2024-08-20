package org.gampiot.robok.feature.util.base

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.IdRes

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.color.MaterialColors

import org.gampiot.robok.feature.util.getBackPressedClickListener

open class RobokFragment(private val transitionMode: Int = MaterialSharedAxis.X) : Fragment() {

    @IdRes var layoutResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(transitionMode, true))
        setReturnTransition(MaterialSharedAxis(transitionMode, false))
        setExitTransition(MaterialSharedAxis(transitionMode, true))
        setReenterTransition(MaterialSharedAxis(transitionMode, false))
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(MaterialColors.getColor(view, android.R.attr.colorBackground))
    }
    
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(layoutResId, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun openFragment(fragment: PreferenceFragmentCompat) {
        parentFragmentManager.beginTransaction().apply {
            replace(layoutResId, fragment)
            addToBackStack(null)
            commit()
        }
    }
   
    fun openFragment(@IdRes layoutResId: Int, fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(layoutResId, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
    
    fun setFragmentLayoutResId (@IdRes layoutResId: Int) {
         this.layoutResId = layoutResId
    }
    
    fun getFragmentLayoutResId () : Int {
         return layoutResId;
    }
}