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
import dev.trindade.robokide.ui.components.editor.CodeEditorView

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
       
        val editorSettings = Preference(requireContext())
        editorSettings.setTitle(getString(R.string.settings_editor_title))
        editorSettings.setDescription(getString(R.string.settings_editor_description))
        editorSettings.setPreferenceClickListener {
             openFragment(SettingsEditorFragment(MaterialSharedAxis.X))
             CodeEditorView.showSwitchThemeDialog(requireActivity(), null, null)
        }
        binding.content.addView(editorSettings)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}