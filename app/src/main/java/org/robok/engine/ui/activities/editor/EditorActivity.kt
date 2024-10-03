package org.robok.engine.ui.activities.editor

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.drawable.Drawable
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import android.util.SparseArray

import androidx.activity.viewModels
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.FileProvider
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.util.forEach
import androidx.drawerlayout.widget.DrawerLayout
import androidx.annotation.IdRes 
import androidx.lifecycle.lifecycleScope

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion

import org.robok.engine.Ids
import org.robok.engine.Drawables
import org.robok.engine.strings.Strings
import org.robok.engine.databinding.ActivityEditorBinding
import org.robok.engine.ui.activities.modeling.ModelingActivity
import org.robok.engine.ui.activities.editor.logs.LogsFragment
import org.robok.engine.ui.activities.editor.diagnostic.DiagnosticFragment
import org.robok.engine.ui.activities.editor.diagnostic.models.DiagnosticItem
import org.robok.engine.ui.activities.editor.vm.EditorViewModel
import org.robok.engine.ui.activities.editor.vm.EditorViewModel.EditorEvent
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.core.utils.UniqueNameBuilder
import org.robok.engine.core.utils.base.RobokActivity
import org.robok.engine.feature.editor.EditorListener
import org.robok.engine.feature.editor.RobokCodeEditor
import org.robok.engine.core.components.terminal.RobokTerminal
import org.robok.engine.feature.treeview.provider.FileWrapper
import org.robok.engine.feature.treeview.provider.DefaultFileIconProvider
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.feature.treeview.interfaces.FileClickListener

import org.robok.antlr.logic.AntlrListener
import org.robok.aapt2.compiler.CompilerTask

import java.util.concurrent.CompletableFuture
import java.io.File

import kotlinx.coroutines.*

class EditorActivity : RobokActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var projectManager: ProjectManager
    private var projectPath: String? = null

    private var _binding: ActivityEditorBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private val diagnosticTimeoutRunnable = Runnable {
        binding.diagnosticStatusImage.setBackgroundResource(Drawables.ic_success_24)
        binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
        binding.diagnosticStatusImage.visibility = View.VISIBLE
    }

    private var diagnosticsList: MutableList<DiagnosticItem> = mutableListOf()
    private val diagnosticStandTime: Long = 800

    private lateinit var antlrListener: AntlrListener
    private val editorViewModel by viewModels<EditorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
         isEdgeToEdge = false
         super.onCreate(savedInstanceState)
         _binding = ActivityEditorBinding.inflate(layoutInflater)
         setContentView(binding.root)

         
         val extras = intent.extras
         if (extras != null) {
              projectPath = extras.getString("projectPath")
              projectManager = ProjectManager(this@EditorActivity)
              projectPath?.let {
                    projectManager.setProjectPath(File(it))
              }
         }

         configureScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onTabReselected(tab: TabLayout.Tab) {
        val pm = PopupMenu(this, tab.view)
        pm.menu.add(0, 0, 0, Strings.editor_close)
        pm.menu.add(0, 1, 0, Strings.editor_close_others)
        pm.menu.add(0, 2, 0, Strings.editor_close_all)

        pm.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                0 -> editorViewModel.closeFile(tab.position)
                1 -> editorViewModel.closeOthers()
                2 -> editorViewModel.closeAll()
            }
            true
        }
        pm.show()
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        editorViewModel.setCurrentFile(tab.position)
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {}

    private fun configureScreen() {
        configureTabLayout()
        configureToolbar()
        configureDrawer()
        configureEditor()
        configureFileTree()
        configureButtons()
        updateUndoRedo()
    }
    
    private fun configureButtons() {
        binding.runButton.setOnClickListener {
            projectManager.build(object : CompilerTask.onCompileResult{
                override fun onSuccess(signApk: File){
                    val context = this@EditorActivity
                    
                    val apkUri: Uri = FileProvider.getUriForFile(
                        context,
                        "${context.packageName}.provider",
                        signApk
                    )
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        setDataAndType(apkUri, "application/vnd.android.package-archive")
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
                    }

                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, getString(Strings.warning_project_installer_not_found), Toast.LENGTH_SHORT).show()
                    }
                }
                
                override fun onFailed(msg: String){
                    
                }
            })
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
        binding.tabs.addOnTabSelectedListener(this)
        observeViewModel()
        getCurrentEditor()?.let { currentEdior ->
            val antlrListener = object : AntlrListener {
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
                    currentEditor.addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg)
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
            currentEditor.setAntlrListener(antlrListener)
            currentEditor.setEditorListener(editorListener)
            currentEditor.reload()
            binding.undo.setOnClickListener {
                currentEditor.undo()
                updateUndoRedo()
            }
            binding.redo.setOnClickListener {
                currentEditor.redo()
                updateUndoRedo()
            }
            handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
        }
    }

    private fun configureFileTree() {
        val fileObject = FileWrapper(File(projectPath!!))
        binding.fileTree.loadFiles(fileObject)
        binding.fileTree.setOnFileClickListener(object : FileClickListener {
            override fun onClick(node: Node<FileObject>) {
                if (node.value.isDirectory()) {
                    return
                }

                val fileExtension = node.value.getName().substringAfterLast(".")
                
                when (fileExtension) {
                    "obj" -> startActivity(Intent(this@EditorActivity, ModelingActivity::class.java)) // Open 3D modeling
                    "java" -> editorViewModel.openFile(File(node.value.getAbsolutePath())) // Open file in editor
                    else -> {}

                }
            }
        })
        binding.fileTree.setIconProvider(DefaultFileIconProvider(this))
    }

    private fun updateUndoRedo() {
        getCurrentEditor()?.let { editor ->
            binding.redo?.isEnabled = editor.isCanRedo()
            binding.undo?.isEnabled = editor.isCanUndo()
        } ?: run {
            binding.redo?.isEnabled = false
            binding.undo?.isEnabled = false
        }
    }
    
    private fun observeViewModel() {
        editorViewModel.editorState.observe(this) { state ->
            val index = state.currentIndex
            binding.apply {
                val tab = tabs.getTabAt(index)
                if (tab != null && !tab.isSelected) {
                    tab.select()
                }
                binding.editorContainer.displayedChild = index
            }
        }
        
        editorViewModel.editorEvent.observe(this) { event ->
            when (event) {
                is EditorEvent.OpenFile -> openFile(event.file)
                is EditorEvent.CloseFile -> closeFile(event.index)
                is EditorEvent.CloseOthers -> closeOthers()
                is EditorEvent.CloseAll -> closeAll()
            }
        }
        
        editorViewModel.files.observe(this) { files ->
            
        }
    }
    
    private fun openFile(file: File) {
        val index = editorViewModel.fileCount
        val editor = RobokCodeEditor(this, file)

        editorViewModel.addFile(file)
        binding.apply {
            editorContainer.addView(editor)
            tabs.addTab(tabs.newTab())
        }
        editorViewModel.setCurrentFile(index)
        updateTabs()
    }
    
    private fun closeFile(index: Int) {}
    
    private fun closeOthers() {}
    
    private fun closeAll() {}
    
    private fun saveFile(index: Int) {
        /*lifecycleScope.launch {
            
        }*/
    }

    fun getCurrentEditor(): RobokCodeEditor? {
        return if (editorViewModel.currentFileIndex >= 0) {
            getEditorAtIndex(editorViewModel.currentFileIndex)
        } else null
    }

    private fun getEditorAtIndex(index: Int): RobokCodeEditor? {
        return binding.editorContainer.getChildAt(index) as? RobokCodeEditor
    }
    
    private fun updateTabs() {
        CompletableFuture.supplyAsync({
            val files = editorViewModel.openedFiles
            val dupliCount = mutableMapOf<String, Int>()
            val names = SparseArray<String>()
            val nameBuilder = UniqueNameBuilder<File>("", File.separator)

            files.forEach {
                dupliCount[it.name] = (dupliCount[it.name] ?: 0) + 1
                nameBuilder.addPath(it, it.path)
            }

            for (i in 0 until binding.tabs.tabCount) {
                val file = files[i]
                val count = dupliCount[file.name] ?: 0
                val isModified = getEditorAtIndex(i)?.isModified() ?: false
                val name = if (count > 1) nameBuilder.getShortPath(file) else file.name
                names[i] = if (isModified) "*$name" else name
            }
            names
        }).whenComplete { result, error ->
            if (result == null || error != null) {
                return@whenComplete
            }

            runOnUiThread {
                result.forEach { index, name -> binding.tabs.getTabAt(index)?.text = name }
            }
        }
    }
}
