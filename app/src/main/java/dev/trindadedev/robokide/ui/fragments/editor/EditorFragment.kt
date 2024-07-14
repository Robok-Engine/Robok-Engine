package dev.trindadedev.robokide.ui.fragments.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.tabs.TabLayout

import dev.trindadedev.robokide.R
import dev.trindadedev.robokide.databinding.FragmentEditorBinding
import dev.trindadedev.robokide.ui.terminal.RobokTerminal
import dev.trindadedev.robokide.ui.fragments.build.output.OutputFragment
import dev.trindadedev.robokide.ui.fragments.editor.logs.LogsFragment
import dev.trindadedev.robokide.ui.fragments.editor.diagnostic.DiagnosticFragment
import dev.trindadedev.robokide.ui.base.RobokFragment

import robok.dev.compiler.logic.LogicCompiler
import robok.dev.compiler.logic.LogicCompilerListener
import robok.dev.diagnostic.logic.DiagnosticListener

class EditorFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

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
        
        val diagnosticListener = object : DiagnosticListener {
            override fun onDiagnosticReceive (diagnostic: String) {
                
            }
        }

        val compiler = LogicCompiler(requireContext(), compilerListener)

        binding.runButton.setOnClickListener {
            val code = binding.codeEditor.text.toString()
            terminal.show()
            compiler.compile(code)
        }

        binding.seeLogs.setOnClickListener {
            terminal.show()
        }

        tabLayoutConfig()
    }

    private fun tabLayoutConfig() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.text) {
                        getString(R.string.text_logs) -> {
                            openCustomFragment(R.id.drawer_editor_fragment_container, LogsFragment(MaterialSharedAxis.Y))
                        }

                        getString(R.string.text_diagnostic) -> {
                            openCustomFragment(R.id.drawer_editor_fragment_container, DiagnosticFragment(MaterialSharedAxis.Y))
                        }
                        else -> {
                            // Handle other tabs if needed
                        }
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
            override fun onTabUnselected(tab: TabLayout.Tab?) { }
        })
    }
    
    fun setDiagnosticError () {
    
    }
    
    fun setDiagnosticOk () {
    
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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