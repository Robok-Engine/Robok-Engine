package org.gampiot.robok.feature.settings.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.databinding.FragmentSettingsBinding
import org.gampiot.robok.feature.settings.ui.fragments.editor.SettingsEditorFragment
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.res.Strings

import dev.trindadedev.lib.ui.components.preference.withicon.Preference

class SettingsFragment(private val transitionAxis: Int = MaterialSharedAxis.X, private val fragmentLayoutResId: Int = 0) : RobokFragment(transitionAxis) {

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
        setFragmentLayoutResId(fragmentLayoutResId)
        
        val editorSettings = Preference(requireContext()).apply {
               setTitle(getString(Strings.settings_editor_title))
               setDescription(getString(Strings.settings_editor_description))
               setIcon(R.drawable.ic_settings_24)
               setPreferenceClickListener {
                      openFragment(SettingsEditorFragment(MaterialSharedAxis.X, fragmentLayoutResId))
               }
        }
        binding.content.addView(editorSettings)
        
        val aboutPage = Preference(requireContext()).apply {
               setTitle(getString(Strings.settings_about_title))
               setDescription(getString(Strings.settings_about_description))
               setIcon(R.drawable.ic_info_24)
               setPreferenceClickListener {
                      openFragment(AboutFragment(MaterialSharedAxis.X, fragmentLayoutResId))
               }
        }
        binding.content.addView(aboutPage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}