package dev.trindade.robokide.ui.base

import androidx.fragment.app.Fragment
import android.os.Bundle

import com.google.android.material.transition.MaterialSharedAxis

open class RobokFragment (private val transitionMode: Int = MaterialSharedAxis.X): Fragment() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(transitionMode, true))
        setReturnTransition(MaterialSharedAxis(transitionMode, false))
        setExitTransition(MaterialSharedAxis(transitionMode, true))
        setReenterTransition(MaterialSharedAxis(transitionMode, false))
    }
}