package dev.trindadeaquiles.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent

import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import com.jn.filepickersphere.filelist.common.mime.MimeType
import com.jn.filepickersphere.filepicker.FilePickerCallbacks
import com.jn.filepickersphere.filepicker.FilePickerSphereManager
import com.jn.filepickersphere.filepicker.style.FileItemStyle
import com.jn.filepickersphere.filepicker.style.FilePickerStyle
import com.jn.filepickersphere.models.FileModel
import com.jn.filepickersphere.models.FilePickerModel
import com.jn.filepickersphere.models.PickOptions

import dev.trindadeaquiles.robokide.R
import dev.trindadeaquiles.robokide.databinding.FragmentHomeBinding
import dev.trindadeaquiles.robokide.manage.file.getDefaultPath
import dev.trindadeaquiles.robokide.ui.base.RobokFragment
import dev.trindadeaquiles.robokide.ui.fragments.create.project.CreateProjectFragment
import dev.trindadeaquiles.robokide.ui.fragments.editor.EditorFragment
import dev.trindadeaquiles.robokide.ui.fragments.about.AboutFragment
import dev.trindadeaquiles.robokide.ui.fragments.settings.SettingsFragment

import robok.dev.opengl.GameActivity 

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
        
        binding.openEditor.setOnClickListener {
            openFragment(EditorFragment(MaterialSharedAxis.X))
        }
        
        binding.openAbout.setOnClickListener {
            openFragment(AboutFragment(MaterialSharedAxis.X))
        }
        
        binding.openOpenGl.setOnClickListener {
            startActivity(Intent(requireContext(), GameActivity::class.java))
        }
    }
    
    private fun selectFolder() {
        // logic to select project folder
        val options = PickOptions(
            mimeType = listOf(MimeType.DIRECTORY),
            localOnly = false,
            rootPath = getDefaultPath(),
            maxSelection = 1
        )
        
        FilePickerSphereManager(requireContext(), true).callbacks(object : FilePickerCallbacks {
            override fun onFileSelectionChanged(file: FileModel, selected: Boolean) { }
            override fun onOpenFile(file: FileModel) {
                 val dialog = MaterialAlertDialogBuilder(requireContext())
                     .setTitle("File selected")
                     .setMessage(file.name)
                     .setPositiveButton("OK", null)
                     .show();
            }
            override fun onSelectedFilesChanged(files: List<FileModel>) { }
            override fun onAllFilesSelected(files: List<FileModel>) { }
        }).container(R.id.fragment_container)
        .model(FilePickerModel(options))
        .picker()
        
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