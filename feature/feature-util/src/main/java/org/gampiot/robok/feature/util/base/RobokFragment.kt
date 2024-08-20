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

open class RobokFragment(
    val transitionMode: Int = MaterialSharedAxis.X,
    @IdRes var fragmentLayoutd: Int 
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(MaterialColors.getColor(view, android.R.attr.colorBackground))
    }
    
    open fun updateFragmentLayoutd(@IdRes fragmentLayoutResIdV: Int) {
        fragmentLayoutd = fragmentLayoutResIdV
    }
    
    @IdRes 
    fun getFragmentLayoutResId(): Int = fragmentLayoutd
        
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(fragmentLayoutd, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun openFragment(fragment: PreferenceFragmentCompat) {
        parentFragmentManager.beginTransaction().apply {
            replace(fragmentLayoutd, fragment)
            addToBackStack(null)
            commit()
        }
    }
   
    fun openFragment(@IdRes idRes: Int, fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(idRes, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
}