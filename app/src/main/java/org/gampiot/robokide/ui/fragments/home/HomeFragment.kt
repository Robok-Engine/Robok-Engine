package org.gampiot.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent

import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robokide.R
import org.gampiot.robokide.databinding.FragmentHomeBinding
import org.gampiot.robokide.feature.util.getDefaultPathFile
import org.gampiot.robokide.feature.util.base.RobokFragment
import org.gampiot.robokide.feature.res.Strings
import org.gampiot.robokide.feature.settings.ui.fragment.SettingsFragment
import org.gampiot.robokide.feature.terminal.TerminalActivity
import org.gampiot.robokide.ui.fragments.create.project.CreateProjectFragment
import org.gampiot.robokide.ui.fragments.editor.EditorFragment
import org.gampiot.robokide.ui.fragments.about.AboutFragment

import dev.trindadedev.lib.filepicker.model.DialogConfigs
import dev.trindadedev.lib.filepicker.model.DialogProperties
import dev.trindadedev.lib.filepicker.view.FilePickerDialog

class HomeFragment (private val tansitionAxis : Int = MaterialSharedAxis.X) : RobokFragment(tansitionAxis) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentLayoutResId(R.id.fragment_container)
        binding.createProject.setOnClickListener {
            openFragment(CreateProjectFragment(MaterialSharedAxis.X))
        }
        
        binding.openProject.setOnClickListener {
            selectFolder()
        }
        
        binding.openSettings.setOnClickListener {
            openFragment(SettingsFragment(MaterialSharedAxis.X, R.id.fragment_container))
        }
        
        binding.openTerminal.setOnClickListener {
            startActivity(Intent(requireContext(), TerminalActivity::class.java))
        }
        
        binding.openEditor.setOnClickListener {
            openFragment(EditorFragment(MaterialSharedAxis.X))
        }
        
        binding.openAbout.setOnClickListener {
            openFragment(AboutFragment(MaterialSharedAxis.X))
        }
    }
    
    private fun selectFolder() {
        val properties = DialogProperties().apply {
             root = getDefaultPathFile()
             selection_mode = DialogConfigs.SINGLE_MODE
             selection_type = DialogConfigs.FOLDER_SELECT
        }
        
        val filePickerDialog = FilePickerDialog(this, properties).apply {
             setTitle(getString(Strings.title_select_folder))
             setDialogSelectionListener { files ->
                  if (files != null && files.isNotEmpty()) {
                        val fileNames = files.joinToString("\n") { file ->
                             file.substringAfterLast('/')
                        }
                  }
             }
        }
        filePickerDialog.show()
    }
    
    private fun onFolderSelect() {
        // example to open the editor:
        // val fragment = EditorFragment.newInstance(path)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}