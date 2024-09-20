package org.gampiot.robok.ui.activites.editor

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.drawable.Drawable
import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract

import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.annotation.IdRes 

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion

import org.gampiot.robok.app.Ids
import org.gampiot.robok.app.Drawables
import org.gampiot.robok.databinding.FragmentEditorBinding
import org.gampiot.robok.ui.fragments.build.output.OutputFragment
import org.gampiot.robok.ui.activites.editor.logs.LogsFragment
import org.gampiot.robok.ui.activites.editor.diagnostic.DiagnosticFragment
import org.gampiot.robok.ui.activites.editor.diagnostic.models.DiagnosticItem
import org.gampiot.robok.ui.fragments.project.create.util.ProjectManager
import org.gampiot.robok.feature.util.base.RobokActivity
import org.gampiot.robok.feature.treeview.v2.provider.file
import org.gampiot.robok.feature.treeview.v2.provider.DefaultFileIconProvider
import org.gampiot.robok.feature.treeview.v2.interfaces.FileObject
import org.gampiot.robok.feature.treeview.v2.model.Node
import org.gampiot.robok.feature.treeview.v2.interfaces.FileClickListener
import org.gampiot.robok.feature.editor.EditorListener
import org.gampiot.robok.feature.component.terminal.RobokTerminal
import org.gampiot.robok.feature.res.Strings

import org.robok.model3d.launcher.AndroidLauncher
import org.robok.diagnostic.logic.DiagnosticListener

import java.io.File

class EditorActivity(
    private val projectManager: ProjectManager = ProjectManager(),
    private val projectURI: Uri
) : RobokActivity() {

    private var _binding: ActivityEditorBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private val diagnosticTimeoutRunnable = object : Runnable {
        override fun run() {
            binding.diagnosticStatusImage.setBackgroundResource(Drawables.ic_success_24)
            binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
            binding.diagnosticStatusImage.visibility = View.VISIBLE
        }
    }

    private var diagnosticsList: MutableList<DiagnosticItem> = mutableListOf()
    private val diagnosticStandTime: Long = 800

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureScreen()
    }

    private fun configureScreen() {
        projectManager.setProjectPath(File(processUri(projectURI)))
        configureTabLayout()
        configureToolbar()
        configureDrawer()
        configureEditor()
        configureFileTree()
        configureButtons()
    }

    private fun configureButtons() {
        binding.runButton.setOnClickListener {
            projectManager.build()
        }
    }

    private fun configureTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.text) {
                        getString(Strings.text_logs) -> {
                            supportFragmentManager.beginTransaction()
                                .replace(Ids.drawer_editor_right_fragment_container, LogsFragment())
                                .commit()
                        }
                        getString(Strings.text_diagnostic) -> {
                            supportFragmentManager.beginTransaction()
                                .replace(Ids.drawer_editor_right_fragment_container, DiagnosticFragment(diagnosticsList))
                                .commit()
                        }
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun configureToolbar() {
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

    private fun configureDrawer() {
        binding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            var leftDrawerOffset = 0f
            var rightDrawerOffset = 0f

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val drawerWidth = drawerView.width
                when (drawerView.id) {
                    Ids.navigation_view_left -> {
                        leftDrawerOffset = drawerWidth * slideOffset
                        binding.content.translationX = leftDrawerOffset
                    }
                    Ids.navigation_view_right -> {
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

    private fun configureEditor() {
        val diagnosticListener = object : DiagnosticListener {
            override fun onDiagnosticStatusReceive(isError: Boolean) {
                handler.removeCallbacks(diagnosticTimeoutRunnable)

                if (isError) {
                    binding.diagnosticStatusImage.setBackgroundResource(Drawables.ic_error_24)
                } else {
                    binding.diagnosticStatusImage.setBackgroundResource(Drawables.ic_success_24)
                }
                binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
                binding.diagnosticStatusImage.visibility = View.VISIBLE
            }

            override fun onDiagnosticReceive(line: Int, positionStart: Int, positionEnd: Int, msg: String) {
                binding.codeEditor.addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg)
                diagnosticsList.add(
                    DiagnosticItem(
                        "Error",
                        msg,
                        1
                    )
                )
                onDiagnosticStatusReceive(true)
            }
        }

        val editorListener = object : EditorListener {
            override fun onEditorTextChange() {
                updateUndoRedo()
                binding.diagnosticStatusDotProgress.visibility = View.VISIBLE
                binding.diagnosticStatusImage.visibility = View.INVISIBLE

                handler.removeCallbacks(diagnosticTimeoutRunnable)
                handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
            }
        }

        binding.codeEditor.setDiagnosticListener(diagnosticListener)
        binding.codeEditor.setEditorListener(editorListener)
        binding.codeEditor.reload()
        binding.undo.setOnClickListener {
            binding.codeEditor.undo()
            updateUndoRedo()
        }
        binding.redo.setOnClickListener {
            binding.codeEditor.redo()
            updateUndoRedo()
        }
        handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
    }

    private fun configureFileTree() {
        val fileObject = file(File(processUri(projectURI)))
        binding.fileTree.loadFiles(fileObject)
        binding.fileTree.setOnFileClickListener(object : FileClickListener {
            override fun onClick(node: Node<FileObject>) {
                if (node.value.isDirectory()) {
                    return
                }
                val fileName = node.value.getName()

                if (fileName.endsWith(".obj")) {
                    // Open 3D modeling
                    startActivity(Intent(this@EditorActivity, AndroidLauncher::class.java))
                }
            }
        })
        binding.fileTree.setIconProvider(DefaultFileIconProvider(this))
    }
    
    private fun processUri(uri: Uri) String {
        contentResolver.takePersistableUriPermission(
            uri,
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
        )
        val documentId = DocumentsContract.getTreeDocumentId(uri)
        val folderUri = DocumentsContract.buildDocumentUriUsingTree(uri, documentId)
        val path = getPathFromUri(folderUri)
        
        if (path == null) return
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

    private fun updateUndoRedo() {
        binding.redo?.let {
            it.isEnabled = binding.codeEditor.isCanRedo()
        }
        binding.undo?.let {
            it.isEnabled = binding.codeEditor.isCanUndo()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}