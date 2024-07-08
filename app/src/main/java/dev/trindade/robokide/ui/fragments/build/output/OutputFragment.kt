package dev.trindade.robokide.ui.fragments.build.output

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.databinding.FragmentOutputBinding
import dev.trindade.robokide.ui.components.log.Log

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
    
    override fun onCreate (savedInstanceState: Bundle) {
        super(savedInstanceState)
        setEnterTransition(MaterialSharedAxis(MaterialSharedAxis.X, true))
        setReturnTransition(MaterialSharedAxis(MaterialSharedAxis.X, false))
        setExitTransition(MaterialSharedAxis(MaterialSharedAxis.X, true))
        setReenterTransition(MaterialSharedAxis(MaterialSharedAxis.X, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
  
        output?.let {
            addOutput(it)
        }
    }
    
    fun addOutput(log: String) {
        val logView = Log(requireContext(), log)
        binding.content.addView(logView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val OUTPUT = "RBK BUILD SUCCESS."

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