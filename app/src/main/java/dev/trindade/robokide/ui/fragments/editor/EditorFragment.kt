package dev.trindade.robokide.ui.fragments.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.google.android.material.snackbar.SnackBar

import dev.trindade.robokide.databinding.FragmentEditorBinding
import dev.trindade.robokide.ui.terminal.RobokTerminal

import robok.dev.compiler.logic.LogicCompiler
import robok.dev.compiler.logic.LogicCompilerListener

class EditorFragment : Fragment() {

    private var _binding: FragmentEditorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val path = arguments?.getString(PROJECT_PATH) ?: "/sdcard/Robok/Projects/Default/"
        
        val terminal = RobokTerminal(requireContext())
        
        val compilerListener = object : LogicCompilerListener {
            override fun onCompiled(logs: String) {
                showTerminal(terminal, logs)
            }
            override fun onOutput (output: String) {
                val outputFragment = OutputFragment.newInstance(output)
                SnackBar.make(binding.root, R.string.message_compiled, 4000)
                    .setAction(R.string.go_to_outputs, {
                    
                    }
                .show()    
                openTerminal(outputFragment)
            }
        }
        
        val compiler = LogicCompiler(requireContext(), compilerListener)
        
        binding.runButton.setOnClickListener {
            val code = binding.codeEditor.text.toString()
            compiler.compile(code)
        }
        
        binding.seeLogs.setOnClickListener {
            showTerminal(terminal, null)
        }
    }
    
    private fun showTerminal(terminal: RobokTerminal, logs: String?) {
        logs?.let {
            terminal.addLog(it)
        }
        terminal.show()
    }
    
    fun openFragment (fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val PROJECT_PATH = "arg_path"

        fun newInstance(path: String): EditorFragment {
            val fragment = EditorFragment()
            val args = Bundle().apply {
                putString(PROJECT_PATH, path)
            }
            fragment.arguments = args
            return fragment
        }
    }
}