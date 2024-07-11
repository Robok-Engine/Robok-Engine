package dev.trindade.robokide.ui.fragments.settings.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.FragmentSettingsEditorBinding
import dev.trindade.robokide.ui.base.RobokFragment
import dev.trindade.robokide.ui.components.editor.CodeEditorView
import dev.trindade.robokide.ui.components.preferences.Preference

class SettingsEditorFragment (private val tansitionAxis : Int = MaterialSharedAxis.X) : RobokFragment(tansitionAxis) {

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
        
        val editorTheme = Preference(requireContext())
        editorTheme.setTitle(getString(R.string.settings_editor_title))
        editorTheme.setDescription(getString(R.string.settings_editor_description))
        editorTheme.setPreferenceClickListener {
             val codeEditor = CodeEditorView(requireContext())
             codeEditor.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { _, _ ->
                
             }
        }
        binding.content.addView(editorTheme)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}