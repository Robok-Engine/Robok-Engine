package org.gampiot.robok.feature.settings.ui.fragments.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes 

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.databinding.FragmentSettingsEditorBinding
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.component.editor.RobokCodeEditor
import org.gampiot.robok.feature.component.editor.ThemeManager
import org.gampiot.robok.feature.res.Strings

import dev.trindadedev.lib.ui.components.preference.Preference

class SettingsEditorFragment(
    private val tansitionAxis : Int = MaterialSharedAxis.X,
    @IdRes private val fragmentLayoutResId: Int = 0
) : RobokFragment(tansitionAxis, fragmentLayoutResId) {

    private var _binding: FragmentSettingsEditorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsEditorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        
        val codeEditor = RobokCodeEditor(requireContext())
        
        val editorTheme = Preference(requireContext()).apply {
            setTitle(getString(Strings.settings_editor_theme_title))
            setDescription(getString(Strings.settings_editor_theme_description))
            setPreferenceClickListener {
                ThemeManager.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { which ->
                    ThemeManager.selectTheme(codeEditor.getCodeEditor(), which)
                }
            }
        }
        binding.content.addView(editorTheme)

        val savedThemeIndex = ThemeManager.loadTheme(requireContext())
        ThemeManager.selectTheme(codeEditor.getCodeEditor(), savedThemeIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}