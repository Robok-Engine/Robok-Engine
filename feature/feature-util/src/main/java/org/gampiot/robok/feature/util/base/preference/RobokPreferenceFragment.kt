package org.gampiot.robok.feature.util.base.preference

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View

import androidx.annotation.IdRes 
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.util.dpToPx
import org.gampiot.robok.feature.util.enableEdgeToEdgePaddingListener

abstract class RobokPreferenceFragment(): PreferenceFragmentCompat() {

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
        view.findViewById<RecyclerView>(androidx.preference.R.id.recycler_view).apply {
            setPadding(paddingLeft, paddingTop + 12.dpToPx(context), paddingRight, paddingBottom)
            enableEdgeToEdgePaddingListener()
        }
    }

    override fun setPreferencesFromResource(preferencesResId: Int, key: String?) {
        super.setPreferencesFromResource(preferencesResId, key)
    }

    override fun setDivider(divider: Drawable?) {
        super.setDivider(ColorDrawable(Color.TRANSPARENT))
    }

    override fun setDividerHeight(height: Int) {
        super.setDividerHeight(0)
    }
    
    open fun openFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}