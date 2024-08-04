package org.gampiot.robokide.feature.util.base

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.IdRes

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar

import org.gampiot.robokide.feature.util.getBackPressedClickListener

open class RobokFragment(private val transitionMode: Int = MaterialSharedAxis.X) : Fragment() {

    @IdRes var layoutResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(transitionMode, true))
        setReturnTransition(MaterialSharedAxis(transitionMode, false))
        setExitTransition(MaterialSharedAxis(transitionMode, true))
        setReenterTransition(MaterialSharedAxis(transitionMode, false))
    }
    
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(layoutResId, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun openCustomFragment(@IdRes layoutResId: Int, fragment: Fragment) {
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
    
    fun setLayoutResId (@IdRes layoutResId: Int?) {
         this.layoutResId = layoutResId
    }
    
    fun getLayoutResId () : Int? {
         return layoutResId;
    }
}