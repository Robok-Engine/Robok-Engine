package org.gampiot.robok.feature.settings.ui.fragments

import android.os.Bundle

import androidx.preference.Preference

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.ui.fragments.editor.SettingsEditorFragment
import org.gampiot.robok.feature.settings.ui.fragments.about.AboutFragment
import org.gampiot.robok.feature.util.base.RobokPreferenceFragment


class SettingsFragment(
    @IdRes private val fragmentLayoutResId: Int = 0
) : RobokPreferenceFragment(MaterialSharedAxis.X) {

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
