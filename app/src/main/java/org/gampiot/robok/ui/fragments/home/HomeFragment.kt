package org.gampiot.robok.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.provider.DocumentsContract

import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.annotation.IdRes 

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


import org.gampiot.robok.R
import org.gampiot.robok.BuildConfig
import org.gampiot.robok.databinding.FragmentHomeBinding
import org.gampiot.robok.feature.util.getDefaultPathFile
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.terminal.TerminalActivity
import org.gampiot.robok.ui.fragments.project.template.ProjectTemplatesFragment
import org.gampiot.robok.ui.fragments.project.create.CreateProjectFragment
import org.gampiot.robok.ui.fragments.editor.EditorFragment
import org.gampiot.robok.ui.activities.SettingsActivity

class HomeFragment : RobokFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val RESULT_OK = 9999
    
    private val folderPickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val uri: Uri? = result.data?.data
        uri?.let {
            processFolder(it)
        }
    }
    
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
            openFragment(ProjectTemplatesFragment())
        }
        
        binding.openProject.setOnClickListener {
            openFolderPicker()
        }
        binding.openSettings.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }
        
        binding.openTerminal.setOnClickListener {
            startActivity(Intent(requireContext(), TerminalActivity::class.java))
        }
    }
    
    private fun openFolderPicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        folderPickerLauncher.launch(intent)
    }
    
    private fun processFolder(uri: Uri) {
        requireActivity().contentResolver.takePersistableUriPermission(
            uri,
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
        )
        val documentId = DocumentsContract.getTreeDocumentId(uri)
        val folderUri = DocumentsContract.buildDocumentUriUsingTree(uri, documentId)
        val path = getPathFromUri(folderUri)
        
        if (path != null) {
            Snackbar.make(binding.root, "Caminho do diretório: $path", Snackbar.LENGTH_LONG).show()
            openFragment(
                 EditorFragment(
                      projectManager = ProjectManager(requireContext()), 
                      projectPath = path
                 )
             )
        } else {
            Snackbar.make(binding.root, "Erro: Caminho não encontrado para a URI", Snackbar.LENGTH_LONG).show()
        }
    }
    
    private fun getPathFromUri(uri: Uri): String? {
        val documentId = DocumentsContract.getDocumentId(uri)
        val split = documentId.split(":")
        val type = split[0]
        val relativePath = split[1]
        if ("primary".equals(type, true)) {
           return "/storage/emulated/0/$relativePath"
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
