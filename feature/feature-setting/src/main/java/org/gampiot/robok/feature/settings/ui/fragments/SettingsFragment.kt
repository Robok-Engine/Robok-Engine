package org.gampiot.robok.feature.settings.ui.fragments

import android.os.Bundle

import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.annotation.IdRes 
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.ui.fragments.editor.SettingsEditorFragment
import org.gampiot.robok.feature.settings.ui.fragments.about.AboutFragment

class SettingsFragment(
     private val transitionAxis: Int = MaterialSharedAxis.X, 
     @IdRes private val fragmentLayoutResId: Int = 0
) : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(transitionAxis, true)
        returnTransition = MaterialSharedAxis(transitionAxis, false)
        exitTransition = MaterialSharedAxis(transitionAxis, true)
        reenterTransition = MaterialSharedAxis(transitionAxis, false)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_top, rootKey)
    }
    
    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {
            "settings_editor" -> {
                openFragment(SettingsEditorFragment(MaterialSharedAxis.X, fragmentLayoutResId))
                return true
            }
            "settings_about" -> {
                openFragment(AboutFragment(MaterialSharedAxis.X, fragmentLayoutResId))
                return true
            }
        }
        return super.onPreferenceTreeClick(preference)
    }

    private fun openFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(fragmentLayoutResId, fragment)
            .addToBackStack(null)
            .commit()
    }
}
