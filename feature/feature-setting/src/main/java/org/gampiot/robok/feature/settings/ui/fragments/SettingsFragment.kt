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
import org.gampiot.robok.feature.util.base.preference.RobokSettingsFragment
import org.gampiot.robok.feature.util.base.preference.RobokPreferenceFragment 
import org.gampiot.robok.feature.component.terminal.RobokTerminal

class SettingsFragment(): RobokSettingsFragment(
       settingsTitle = Strings.settings_about_title, 
       fragmentCreator = { SettingsTopFragment() }
   )

class SettingsTopFragment() : RobokPreferenceFragment() {

    private lateinit var terminal: RobokTerminal

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_top, rootKey)
        terminal = RobokTerminal(requireContext())
    }
    
    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {
            "settings_editor" -> {
                openFragment(SettingsEditorFragment(MaterialSharedAxis.X, R.id.fragment_container))
                return true
            }
            "settings_about" -> {
                openFragment(AboutFragment(MaterialSharedAxis.X, R.id.fragment_container))
                return true
            }
        }
        return super.onPreferenceTreeClick(preference)
    }
}
