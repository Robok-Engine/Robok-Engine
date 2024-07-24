package com.robok.ide.ui.fragments.settings.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.compose.ui.platform.ComposeView

import com.google.android.material.transition.MaterialSharedAxis

import com.robok.ide.R
import com.robok.ide.databinding.FragmentSettingsEditorBinding
import com.robok.ide.ui.base.RobokFragment
import com.robok.ide.ui.components.editor.RobokCodeEditor
import com.robok.ide.ui.components.editor.ThemeManager

import dev.trindadedev.lib.ui.components.preferences.compose.*

class SettingsEditorFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

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
        
        binding.composeView.setContent {
            PreferenceItem(
                iconResId = R.drawable.ic_settings_24,
                title = getString(R.string.settings_editor_theme_title),
                summary = getString(R.string.settings_editor_theme_description),
                onClick = { 
                    ThemeManager.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { which ->
                        ThemeManager.selectTheme(codeEditor.getCodeEditor(), which)
                    }
                }
            )
        }

        val savedThemeIndex = ThemeManager.loadTheme(requireContext())
        ThemeManager.selectTheme(codeEditor.getCodeEditor(), savedThemeIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}