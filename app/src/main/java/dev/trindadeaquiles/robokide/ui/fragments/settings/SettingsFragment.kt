package dev.trindadeaquiles.robokide.ui.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindadeaquiles.robokide.R
import dev.trindadeaquiles.robokide.databinding.FragmentSettingsBinding
import dev.trindadeaquiles.robokide.ui.base.RobokFragment
import dev.trindadeaquiles.robokide.ui.fragments.settings.editor.SettingsEditorFragment

import dev.trindadeaquiles.ui.preferences.Preference

class SettingsFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        
        val editorSettings = Preference(requireContext())
        editorSettings.setTitle(getString(R.string.settings_editor_title))
        editorSettings.setDescription(getString(R.string.settings_editor_description))
        editorSettings.setPreferenceClickListener {
             openFragment(SettingsEditorFragment(MaterialSharedAxis.X))
        }
        binding.content.addView(editorSettings)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}