package dev.trindade.robokide.ui.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.databinding.FragmentSettingsBinding
import dev.trindade.robokide.ui.base.RobokFragment
import dev.trindade.robokide.ui.components.preferences.Preference

class SettingsFragment (private val tansitionAxis : Int = MaterialSharedAxis.Y) : RobokFragment(tansitionAxis) {

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
        editorSettings.preferenceTitle = getString(R.string.settings_editor_title)
        editorSettings.preferenceTitle = getString(R.string.settings_editor_description)
        editorSettings.setPreferenceClickListener {
             openFragmentSettings(SettingsEditorFragment(MaterialSharedAxis.Y))
        }
        binding.root.addView(editorSettings)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}