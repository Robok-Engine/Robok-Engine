package com.robok.ide.ui.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import com.robok.ide.R
import com.robok.ide.databinding.FragmentSettingsBinding
import com.robok.ide.ui.base.RobokFragment
import com.robok.ide.ui.fragments.settings.editor.SettingsEditorFragment

import dev.trindadedev.lib.ui.components.preferences.compose.*

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
        
        binding.composeView.setContent {
            PreferenceItem(
                iconResId = R.drawable.ic_settings_24, 
                title = getString(R.string.settings_editor_title),
                summary = getString(R.string.settings_editor_description),
                onClick = { 
                    openFragment(SettingsEditorFragment(MaterialSharedAxis.X)) 
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}