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
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.util.base.preference.BaseSettingFragment
import org.gampiot.robok.feature.util.base.preference.BasePreferenceFragment 

class SettingsFragment(
     private val transitionAxis: Int = MaterialSharedAxis.X,
     @IdRes private val fragmentLayoutResId: Int
): BaseSettingFragment(
       MaterialSharedAxis.X, 
       Strings.settings_about_title, 
       { SettingsTopFragment(transitionAxis, fragmentLayoutResId) },
       fragmentLayoutResId
   )

class SettingsTopFragment(
     private val transitionAxis: Int = MaterialSharedAxis.X, 
     @IdRes private val fragmentLayoutResId: Int
) : BasePreferenceFragment(fragmentLayoutResId) {

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
}
