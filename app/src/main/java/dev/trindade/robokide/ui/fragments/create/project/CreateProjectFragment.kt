package dev.trindade.robokide.ui.fragments.create.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.databinding.FragmentCreateProjectBinding
import dev.trindade.robokide.ui.components.log.Log

class CreateProjectFragment : Fragment() {

    private var _binding: FragmentCreateProjectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateProjectBinding.inflate(inflater, container, false)
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}