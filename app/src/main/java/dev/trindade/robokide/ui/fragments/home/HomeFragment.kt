package dev.trindade.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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