package dev.trindade.robokide.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.FragmentHomeBinding
import dev.trindade.robokide.ui.components.log.Log
import dev.trindade.robokide.ui.fragments.create.project.CreateProjectFragment
import dev.trindade.robokide.ui.fragments.editor.EditorFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(MaterialSharedAxis.Y, true))
        setReturnTransition(MaterialSharedAxis(MaterialSharedAxis.Y, false))
        setExitTransition(MaterialSharedAxis(MaterialSharedAxis.Y, true))
        setReenterTransition(MaterialSharedAxis(MaterialSharedAxis.Y, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createProject.setOnClickListener {
            openFragment(CreateProjectFragment())
        }
        
        binding.openProject.setOnClickListener {
            selectFolder()
        }
        
        binding.openEditor.setOnClickListener {
            openFragment(EditorFragment(MaterialSharedAxis.Y))
        }
    }
    
    fun selectFolder () {
        /* 
          logic for select project folder
        */
    }
    
    fun onFolderSelect() {
        /*
           example for open editor: 
           val fragment = EditorFragment.newInstance(path) 
        */
    }
    
    fun openFragment(fragment: Fragment) {
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