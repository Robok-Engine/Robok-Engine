package dev.trindade.robokide.ui.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.FragmentSettingsBinding
import dev.trindade.robokide.ui.base.RobokFragment
import dev.trindade.robokide.ui.components.preferences.Preference
import dev.trindade.robokide.ui.fragments.settings.editor.SettingsEditorFragment
import dev.trindade.robokide.ui.activities.SettingsActivity

class SettingsFragment(private val transitionAxis: Int = MaterialSharedAxis.Y) : RobokFragment(transitionAxis) {

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
        val settingsActivity = activity as? SettingsActivity
        val editorSettings = Preference(requireContext())
        editorSettings.setTitle(getString(R.string.settings_editor_title))
        editorSettings.setDescription(getString(R.string.settings_editor_description))
        editorSettings.setPreferenceClickListener {
             openFragmentSettings(SettingsEditorFragment(MaterialSharedAxis.X))
             CodeEditorView.showSwitchThemeDialog(requireActivity(), null, null)
             settingsActivity?.setToolbarTitle(getString(R.string.settings_editor_title))
        }
        binding.content.addView(editorSettings)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}