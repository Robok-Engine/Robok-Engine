package org.gampiot.robok.feature.settings.ui.fragments.editor

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
import org.gampiot.robok.feature.component.terminal.RobokTerminal
import org.gampiot.robok.feature.component.editor.RobokCodeEditor
import org.gampiot.robok.feature.component.editor.ThemeManager

class SettingsEditorFragment(
     private val transitionAxis: Int = MaterialSharedAxis.X,
     @IdRes private val fragmentLayoutResId: Int
): BaseSettingFragment(
       MaterialSharedAxis.X, 
       Strings.settings_about_title, 
       { SettingsEditorTopFragment(transitionAxis, fragmentLayoutResId) },
       fragmentLayoutResId
   )

class SettingsEditorTopFragment(
     private val transitionAxis: Int = MaterialSharedAxis.X, 
     @IdRes private val fragmentLayoutResId: Int
) : BasePreferenceFragment(fragmentLayoutResId) {

    private lateinit var terminal: RobokTerminal
    private lateinit var codeEditor: RobokCodeEditor
        
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_editor, rootKey)
        codeEditor = RobokCodeEditor(requireContext())
        val savedThemeIndex = ThemeManager.loadTheme(requireContext())
        ThemeManager.selectTheme(codeEditor.getCodeEditor(), savedThemeIndex)
    }
    
    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {
            "settings_editor_theme" -> {
                ThemeManager.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { which ->
                    ThemeManager.selectTheme(codeEditor.getCodeEditor(), which)
                }
                return true
            }
        }
        return super.onPreferenceTreeClick(preference)
    }
}
