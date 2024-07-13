package dev.trindadedev.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent

import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import com.jn.filepickersphere.filelist.common.mime.MimeType
import com.jn.filepickersphere.filepicker.FilePickerCallbacks
import com.jn.filepickersphere.filepicker.FilePickerSphereManager
import com.jn.filepickersphere.filepicker.style.FileItemStyle
import com.jn.filepickersphere.filepicker.style.FilePickerStyle
import com.jn.filepickersphere.models.FileModel
import com.jn.filepickersphere.models.FilePickerModel
import com.jn.filepickersphere.models.PickOptions

import dev.trindadedev.robokide.R
import dev.trindadedev.robokide.databinding.FragmentHomeBinding
import dev.trindadedev.robokide.ui.base.RobokFragment
import dev.trindadedev.robokide.ui.fragments.create.project.CreateProjectFragment
import dev.trindadedev.robokide.ui.fragments.editor.EditorFragment
import dev.trindadedev.robokide.manage.file.getDefaultPath
import dev.trindadedev.robokide.ui.components.dialog.RobokDialog
import dev.trindadedev.robokide.ui.fragments.settings.SettingsFragment

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
                 val dialog = RobokDialog(requireContext())
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