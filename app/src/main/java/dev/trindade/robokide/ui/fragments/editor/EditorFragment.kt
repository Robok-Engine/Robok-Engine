package dev.trindade.robokide.ui.fragments.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.FragmentEditorBinding
import dev.trindade.robokide.databinding.DrawerFragmentEditorBinding
import dev.trindade.robokide.databinding.ContentFragmentEditorBinding
import dev.trindade.robokide.ui.terminal.RobokTerminal
import dev.trindade.robokide.ui.fragments.build.output.OutputFragment
import dev.trindade.robokide.ui.base.RobokFragment

import robok.dev.compiler.logic.LogicCompiler
import robok.dev.compiler.logic.LogicCompilerListener

class EditorFragment (private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

    private var _binding: FragmentEditorBinding? = null
    private val binding get() = _binding!!
    
    private var _bindingContent: ContentFragmentEditorBinding? = null
    private val bindingContent get() = _bindingContent!!
    
    private var _bindingDrawer: DrawerFragmentEditorBinding? = null
    private val bindingDrawer get() = _bindingDrawer!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditorBinding.inflate(inflater, container, false)
        _bindingContent = ContentFragmentEditorBinding.inflate(inflater, container, false)
        _bindingDrawer = DrawerFragmentEditorBinding.inflate(inflater, container, false)

        binding.root.findViewById<FrameLayout>(R.id.content_container).addView(bindingContent.root)
        binding.root.findViewById<NavigationView>(R.id.navigation_view).addView(bindingDrawer.root)

        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val path = arguments?.getString(PROJECT_PATH) ?: "/sdcard/Robok/Projects/Default/"
        
        val terminal = RobokTerminal(requireContext())
        
        val compilerListener = object : LogicCompilerListener {
            override fun onCompiling(log: String) {
                terminal.addLog(log)
            }

            override fun onCompiled(output: String) {
                val outputFragment = OutputFragment(MaterialSharedAxis.X)
                outputFragment.addOutput(requireContext(), layoutInflater, view as ViewGroup, output)
                
                Snackbar.make(binding.root, R.string.message_compiled, Snackbar.LENGTH_LONG)
                    .setAction(R.string.go_to_outputs) {
                        openFragment(outputFragment)
                        terminal.dismiss()
                    }
                    .show()
            }
        }
        
        val compiler = LogicCompiler(requireContext(), compilerListener)
        
        bindingContent.runButton.setOnClickListener {
            val code = bindingContent.codeEditor.text.toString()
            terminal.show()
            compiler.compile(code)
        }
        
        bindingContent.seeLogs.setOnClickListener {
            terminal.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _bindingContent = null
        _bindingDrawer = null
    }

    companion object {
        private const val PROJECT_PATH = "arg_path"

        fun newInstance(path: String): EditorFragment {
            return EditorFragment(MaterialSharedAxis.X).apply {
                arguments = Bundle().apply {
                    putString(PROJECT_PATH, path)
                }
            }
        }
    }
}