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
    
    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
    
    private fun openFragmentSettings(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.settings_fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun navigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(requireActivity()))
    }
}