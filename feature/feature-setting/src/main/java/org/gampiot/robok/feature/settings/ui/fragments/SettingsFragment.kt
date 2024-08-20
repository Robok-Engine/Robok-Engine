package org.gampiot.robok.feature.settings.ui.fragments

import android.os.Bundle

import androidx.preference.Preference
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis
import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.ui.fragments.editor.SettingsEditorFragment
import org.gampiot.robok.feature.settings.ui.fragments.about.AboutFragment
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.util.base.RobokPreferenceFragment

abstract class SettingsFragment : RobokPreferenceFragment(
    str = Strings.common_word_settings,
    fragmentCreator = { SettingsContentFragment() }
) {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_top, rootKey)
    }
    
    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {
            "settings_editor" -> {
                openFragment(SettingsEditorFragment(MaterialSharedAxis.X))
                return true
            }
            "settings_about" -> {
                openFragment(AboutFragment(MaterialSharedAxis.X))
                return true
            }
        }
        return super.onPreferenceTreeClick(preference)
    }
}

class SettingsContentFragment : RobokFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
