package dev.trindade.robokide.ui.base

import android.os.Bundle

import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar

import dev.trindade.robokide.utils.getBackPressedClickListener

open class RobokFragment(private val transitionMode: Int = MaterialSharedAxis.X) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(transitionMode, true))
        setReturnTransition(MaterialSharedAxis(transitionMode, false))
        setExitTransition(MaterialSharedAxis(transitionMode, true))
        setReenterTransition(MaterialSharedAxis(transitionMode, false))
    }

    fun navigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(requireActivity()))
    }
}