package dev.trindade.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.FragmentHomeBinding
import dev.trindade.robokide.ui.base.RobokFragment
import dev.trindade.robokide.ui.fragments.create.project.CreateProjectFragment
import dev.trindade.robokide.ui.fragments.editor.EditorFragment

class HomeFragment (private val tansitionAxis : Int = MaterialSharedAxis.Y) : RobokFragment(tansitionAxis) {

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
            openFragment(CreateProjectFragment(MaterialSharedAxis.Y))
        }
        
        binding.openProject.setOnClickListener {
            selectFolder()
        }
        
        binding.openEditor.setOnClickListener {
            openFragment(EditorFragment(MaterialSharedAxis.Y))
        }
    }
    
    private fun selectFolder() {
        // logic to select project folder
        val options = PickOptions(
            mimeType = listOf(MimeType.IMAGE_PNG, MimeType.IMAGE_JPEG, MimeType.DIRECTORY, MimeType("value here")),
            localOnly = false,
            rootPath = "/storage/emulated/0/",
            maxSelection = 8
        )
        
        FilePickerSphereManager(this, true).callbacks(object : FilePickerCallbacks {
            override fun onFileSelectionChanged(file: FileModel, selected: Boolean) {
                Log.i("FilePickerSphere", "File clicked: ${file.name}\n Selected: $selected")
            }
            
            override fun onOpenFile(file: FileModel) {
                Log.i("FilePickerSphere", "Open file: ${file.name}")
            }
            
            override fun onSelectedFilesChanged(files: List<FileModel>) {
                // Handle selected files change
            }
            
            override fun onAllFilesSelected(files: List<FileModel>) {
               // Handle all files selected
            }
        }).container(R.id.fragment_container)
        .model(FilePickerModel(options))
        .picker()
        
    }
    
    private fun onFolderSelect() {
        // example to open the editor:
        // val fragment = EditorFragment.newInstance(path)
    }
    
    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}