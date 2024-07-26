package com.robok.ide.ui.base

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.activity.OnBackPressedDispatcher

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar

import com.robok.ide.R
import com.robok.ide.utils.getBackPressedClickListener

open class RobokFragment(private val transitionMode: Int = MaterialSharedAxis.X) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(transitionMode, true))
        setReturnTransition(MaterialSharedAxis(transitionMode, false))
        setExitTransition(MaterialSharedAxis(transitionMode, true))
        setReenterTransition(MaterialSharedAxis(transitionMode, false))
    }
    
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun openCustomFragment(resId: Int, fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(resId, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
}