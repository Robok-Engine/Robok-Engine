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
import org.gampiot.robokide.feature.util.getDefaultPath
import org.gampiot.robokide.feature.settings.ui.fragment.SettingsFragment
import org.gampiot.robokide.feature.util.base.RobokFragment
import org.gampiot.robokide.feature.terminal.TerminalActivity
import org.gampiot.robokide.ui.fragments.create.project.CreateProjectFragment
import org.gampiot.robokide.ui.fragments.editor.EditorFragment
import org.gampiot.robokide.ui.fragments.about.AboutFragment

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
        binding.createProject.setOnClickListener {
            openFragment(CreateProjectFragment(MaterialSharedAxis.X))
        }
        
        binding.openProject.setOnClickListener {
            selectFolder()
        }
        
        binding.openSettings.setOnClickListener {
            openFragment(SettingsFragment(MaterialSharedAxis.X))
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
        // logic to select project folder
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