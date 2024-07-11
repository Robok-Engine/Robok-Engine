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
import dev.trindade.robokide.ui.components.editor.ThemeManager

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
        
        val editorTheme = Preference(requireContext()).apply {
            setTitle(getString(R.string.settings_editor_title))
            setDescription(getString(R.string.settings_editor_description))
            setPreferenceClickListener {
                val codeEditor = CodeEditorView(requireContext())
                ThemeManager.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { which ->
                    ThemeManager.selectTheme(codeEditor.getCodeEditor(), which)
                }
            }
        }
        binding.content.addView(editorTheme)

        val savedThemeIndex = ThemeManager.loadTheme(requireContext())
        val codeEditor = CodeEditorView(requireContext())
        ThemeManager.selectTheme(codeEditor.getCodeEditor(), savedThemeIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}