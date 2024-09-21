package org.gampiot.robok.feature.util.base

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.IdRes

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.color.MaterialColors

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.util.getBackPressedClickListener

open class RobokFragment() : Fragment() {

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
    
    fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
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