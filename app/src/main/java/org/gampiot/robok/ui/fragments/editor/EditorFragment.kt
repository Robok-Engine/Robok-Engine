package org.gampiot.robok.ui.fragments.editor

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.annotation.IdRes 

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.transition.MaterialSharedAxis

import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentEditorBinding
import org.gampiot.robok.feature.component.editor.EditorListener
import org.gampiot.robok.feature.component.terminal.RobokTerminal
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.ui.fragments.build.output.OutputFragment
import org.gampiot.robok.ui.fragments.editor.logs.LogsFragment
import org.gampiot.robok.ui.fragments.editor.diagnostic.DiagnosticFragment

import robok.compiler.logic.LogicCompiler
import robok.compiler.logic.LogicCompilerListener
import robok.diagnostic.logic.DiagnosticListener

class EditorFragment(
    private val tansitionAxis : Int = MaterialSharedAxis.X,
    @IdRes private val fragmentLayoutResId: Int = 0
) : RobokFragment(tansitionAxis, fragmentLayoutResId) {

    var _binding: FragmentEditorBinding? = null
    val binding get() = _binding!!
    val handler = Handler(Looper.getMainLooper())
    val diagnosticTimeoutRunnable = object : Runnable {
        override fun run() {
            binding.diagnosticStatusImage.setBackgroundResource(R.drawable.ic_success_24)
            binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
            binding.diagnosticStatusImage.visibility = View.VISIBLE
        }
    }

    val diagnosticStandTime : Long = 800

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

                Snackbar.make(binding.root, Strings.message_compiled, Snackbar.LENGTH_LONG)
                    .setAction(Strings.go_to_outputs) {
                        openFragment(outputFragment)
                        terminal.dismiss()
                    }
                    .show()
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

        configureTabLayout()
        configureToolbar()
        configureDrawer()
        configureEditor()
    }

    fun configureTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.text) {
                        getString(Strings.text_logs) -> {
                            openFragment(R.id.drawer_editor_right_fragment_container, LogsFragment(MaterialSharedAxis.Y))
                        }
                        getString(Strings.text_diagnostic) -> {
                            openFragment(R.id.drawer_editor_right_fragment_container, DiagnosticFragment(MaterialSharedAxis.Y))
                        }
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    fun configureToolbar() {
        binding.diagnosticStatusDotProgress.startAnimation()
        binding.toolbar.setNavigationOnClickListener {
              if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
              } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START)
              }
        }
        binding.diagnosticStatusImage.setOnClickListener {
              if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.END)
              } else {
                    binding.drawerLayout.openDrawer(GravityCompat.END)
              }
              binding.tabLayout.getTabAt(1)?.select()
        }
    }

    fun configureDrawer() {
        binding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            var leftDrawerOffset = 0f
            var rightDrawerOffset = 0f

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val drawerWidth = drawerView.width
                when (drawerView.id) {
                    R.id.navigation_view_left -> {
                        leftDrawerOffset = drawerWidth * slideOffset
                        binding.content.translationX = leftDrawerOffset
                    }
                    R.id.navigation_view_right -> {
                        rightDrawerOffset = drawerWidth * slideOffset
                        binding.content.translationX = -rightDrawerOffset
                    }
                }
            }

            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {
                binding.content.translationX = 0f
                leftDrawerOffset = 0f
                rightDrawerOffset = 0f
            }

            override fun onDrawerStateChanged(newState: Int) {}
        })
    }

    fun configureEditor() {
        val diagnosticListener = object : DiagnosticListener {
            override fun onDiagnosticStatusReceive(isError: Boolean) {
                handler.removeCallbacks(diagnosticTimeoutRunnable)
                
                if (isError) {
                    binding.diagnosticStatusImage.setBackgroundResource(R.drawable.ic_error_24)
                } else {
                    binding.diagnosticStatusImage.setBackgroundResource(R.drawable.ic_success_24)
                }
                binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
                binding.diagnosticStatusImage.visibility = View.VISIBLE
            }

            override fun onDiagnosticReceive(line: Int, positionStart: Int, positionEnd: Int, msg: String) {
                binding.codeEditor.addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg)
                onDiagnosticStatusReceive(true)
            }
        }

        val editorListener = object : EditorListener {
            override fun whenTyping() {
                binding.diagnosticStatusDotProgress.visibility = View.VISIBLE
                binding.diagnosticStatusImage.visibility = View.INVISIBLE
                
                handler.removeCallbacks(diagnosticTimeoutRunnable)
                handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
            }
        }

        binding.codeEditor.setDiagnosticListener(diagnosticListener)
        binding.codeEditor.setEditorListener(editorListener)

        binding.undo.setOnClickListener {
            binding.codeEditor.undo()
        }
        binding.redo.setOnClickListener {
            binding.codeEditor.redo()
        }
        handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val PROJECT_PATH = "arg_path"

        @JvmStatic
        fun newInstance(path: String): EditorFragment {
            return EditorFragment(MaterialSharedAxis.X).apply {
                arguments = Bundle().apply {
                    putString(PROJECT_PATH, path)
                }
            }
        }
    }
}
