package dev.trindade.robokide.ui.fragments.output

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import dev.trindade.robokide.databinding.FragmentOutputBinding
import dev.trindade.robokide.ui.terminal.LogView

class OutputFragment : Fragment() {

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val output = arguments?.getString(OUTPUT)
        
        val outputManager = OutputManager(requireContext(), binding.content)
        
        output?.let {
            outputManager.addOutput(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val OUTPUT = "OUTPUT"

        fun newInstance(OUTPUT: String): OutputFragment {
            val fragment = OutputFragment()
            val args = Bundle().apply {
                putString(OUTPUT, OUTPUT)
            }
            fragment.arguments = args
            return fragment
        }
    }
}