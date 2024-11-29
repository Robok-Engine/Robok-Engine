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

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.FileProvider
import androidx.core.util.forEach
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion
import java.io.File
import java.util.concurrent.CompletableFuture
import kotlinx.coroutines.Runnable
import org.koin.android.ext.android.getKoin
import org.robok.easyui.GUIBuilder
import org.robok.easyui.compiler.GUICompiler
import org.robok.engine.Drawables
import org.robok.engine.Ids
import org.robok.engine.core.antlr4.java.AntlrListener
import org.robok.engine.core.components.dialog.sheet.list.RecyclerViewBottomSheet
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.core.utils.UniqueNameBuilder
import org.robok.engine.databinding.ActivityEditorBinding
import org.robok.engine.feature.compiler.android.CompilerTask
import org.robok.engine.feature.editor.EditorListener
import org.robok.engine.feature.editor.RobokCodeEditor
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.base.RobokActivity
import org.robok.engine.ui.activities.editor.drawer.filetree.FileTreeDrawer
import org.robok.engine.ui.activities.editor.drawer.info.ProjectInfoDrawer
import org.robok.engine.ui.activities.editor.drawer.info.ProjectInfoDrawerIndexs
import org.robok.engine.ui.activities.editor.drawer.info.ProjectInfoDrawerViewModel
import org.robok.engine.ui.activities.editor.event.EditorEvent
import org.robok.engine.ui.activities.editor.viewmodel.EditorViewModel
import org.robok.engine.ui.activities.modeling.ModelingActivity
import org.robok.engine.ui.activities.project.settings.build.ProjectBuildSettingsActivity
import org.robok.engine.ui.activities.xmlviewer.XMLViewerActivity
import org.robok.engine.ui.theme.RobokTheme

class EditorActivity :
  RobokActivity(), TabLayout.OnTabSelectedListener, CompilerTask.OnCompileResult {

  companion object {
    const val GUI_COMPILER_TAG = "GUICompiler"
  }

  private var projectPath: String? = null
  private var _binding: ActivityEditorBinding? = null
  private val binding
    get() = _binding!!

  private lateinit var projectManager: ProjectManager
  private lateinit var antlrListener: AntlrListener
  private lateinit var editorViewModel: EditorViewModel
  private lateinit var buildTerminal: RecyclerViewBottomSheet
  private lateinit var projectInfoViewModel: ProjectInfoDrawerViewModel

  private val handler = Handler(Looper.getMainLooper())
  private val diagnosticStandTime: Long = 800
  private val diagnosticTimeoutRunnable = Runnable {
    binding.diagnosticStatusImage.setBackgroundResource(Drawables.ic_success_24)
    binding.diagnosticStatusDotProgress.visibility = View.INVISIBLE
    binding.diagnosticStatusImage.visibility = View.VISIBLE
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = ActivityEditorBinding.inflate(layoutInflater)
    setContentView(binding.root)

    editorViewModel = getKoin().get()
    projectInfoViewModel = getKoin().get()

    val extras = intent.extras
    if (extras != null) {
      projectPath = extras.getString(ExtraKeys.Project.PATH)
      projectManager = ProjectManager(this@EditorActivity)
      projectPath?.let { projectManager.projectPath = File(it) }
    }

    configureScreen()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  // TODO: use new onBackPressedDispatcher
  override fun onBackPressed() {
    if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
      binding.drawerLayout.closeDrawer(GravityCompat.START)
      return
    }
    if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
      binding.drawerLayout.closeDrawer(GravityCompat.END)
      return
    }
    MaterialAlertDialogBuilder(this)
      .setTitle(getString(Strings.warning_exit_project_title))
      .setMessage(getString(Strings.warning_exit_project_message))
      .setPositiveButton(getString(Strings.common_word_confirm)) { d, w ->
        editorViewModel.saveAllFiles()
        super.onBackPressed()
      }
      .setNeutralButton(getString(Strings.text_exit_without_save)) { d, w -> super.onBackPressed() }
      .setNegativeButton(getString(Strings.common_word_cancel)) { d, w -> d.dismiss() }
      .show()
  }

  override fun onTabReselected(tab: TabLayout.Tab) {
    val pm = PopupMenu(this, tab.view)
    pm.menu.add(0, 0, 0, Strings.common_word_close)
    pm.menu.add(0, 1, 0, Strings.common_word_close_others)
    pm.menu.add(0, 2, 0, Strings.common_word_close_all)

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

  override fun onCompileSuccess(signApk: File) {
    buildTerminal.setCancelable(true)
    val apkUri: Uri =
      FileProvider.getUriForFile(this@EditorActivity, "${packageName}.provider", signApk)
    val intent =
      Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(apkUri, "application/vnd.android.package-archive")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
      }
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    } else {
      Toast.makeText(
          this@EditorActivity,
          getString(Strings.warning_project_installer_not_found),
          Toast.LENGTH_SHORT,
        )
        .show()
    }
  }

  override fun onCompileError(error: String) {
    buildTerminal.setCancelable(true)
  }

  private fun configureScreen() {
    configureToolbar()
    configureDrawer()
    configureEditor()
    configureFileTree()
    configureButtons()
    updateUndoRedo()
    configureMoreOptions()
  }

  private fun configureButtons() {
    buildTerminal = RecyclerViewBottomSheet(this)
    binding.runButton.setOnClickListener {
      editorViewModel.saveAllFiles()
      projectManager.build(buildTerminal, this)
    }

    binding.openFilesButton.setOnClickListener {
      binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    binding.save.setOnClickListener { editorViewModel.saveFile() }
  }

  private fun configureToolbar() {
    binding.diagnosticStatusDotProgress.startAnimation()
    binding.toolbar.setTitle(projectManager.getProjectName())
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
      projectInfoViewModel.setCurrentTabIndex(ProjectInfoDrawerIndexs.DIAGNOSTIC)
    }
  }

  private fun configureDrawer() {
    binding.drawerLayout.setScrimColor(Color.TRANSPARENT)
    binding.drawerLayout.setDrawerElevation(0f)
    binding.drawerLayout.addDrawerListener(
      object : DrawerLayout.DrawerListener {
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
      }
    )

    binding.drawerEditorRightComposeView.setContent {
      RobokTheme(isActivity = false) { ProjectInfoDrawer(viewModel = projectInfoViewModel) }
    }
  }

  private fun configureEditor() {
    binding.tabs.addOnTabSelectedListener(this)
    observeViewModel()

    binding.undo.setOnClickListener {
      getCurrentEditor()?.undo()
      updateUndoRedo()
    }
    binding.redo.setOnClickListener {
      getCurrentEditor()?.redo()
      updateUndoRedo()
    }
  }

  private fun configureFileTree() {
    binding.drawerEditorLeftComposeView.setContent {
      RobokTheme(isActivity = false) {
        FileTreeDrawer(
          path = projectPath!!,
          onClick = { node ->
            if (node.value.isDirectory()) {} else {
              handleNodeFileName(node)
            }
          },
        )
      }
    }
  }

  private fun handleNodeFileName(node: Node<FileObject>) {
    val name = node.value.getName()
    when (name) {
      "config.json" -> {
        val intent =
          Intent(this, ProjectBuildSettingsActivity::class.java).apply {
            putExtras(
              Bundle().apply {
                putString(ExtraKeys.Project.PATH, projectManager.projectPath.absolutePath)
              }
            )
          }
        startActivity(intent)
      }
      else -> handleNodeFileExtension(node)
    }
  }
  
  private fun handleNodeFileExtension(node: Node<FileObject>) {
    val fileExtension = node.value.getName().substringAfterLast(".")
    val fileToOpen = File(node.value.getAbsolutePath())
    when (fileExtension) {
      "obj" ->
        startActivity(
          Intent(this, ModelingActivity::class.java)
        ) // open 3d modeling (todo: send args)
      else -> editorViewModel.openFile(fileToOpen) // open file on editor
    }
  }

  private fun File.getFileExtension(): String = this.getName().substringAfterLast(".")

  private fun updateUndoRedo() {
    getCurrentEditor()?.let { editor ->
      binding.redo.isEnabled = editor.isCanRedo
      binding.undo.isEnabled = editor.isCanUndo
    }
      ?: run {
        binding.redo.isEnabled = false
        binding.undo.isEnabled = false
      }
  }

  private fun configureEditorListeners(editor: RobokCodeEditor) {
    val antlrListener =
      object : AntlrListener {
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

        override fun onDiagnosticReceive(
          line: Int,
          positionStart: Int,
          positionEnd: Int,
          msg: String,
        ) {
          editor.addDiagnosticInEditor(
            positionStart,
            positionEnd,
            DiagnosticRegion.SEVERITY_ERROR,
            msg,
          )
          onDiagnosticStatusReceive(true)
        }
      }
    val editorListener =
      object : EditorListener {
        override fun onEditorTextChange() {
          updateUndoRedo()
          with(binding) {
            if ((getCurrentFileExtension() ?: "java") == "java") {
              if (relativeLayoutDiagnostics.visibility == View.GONE) {
                relativeLayoutDiagnostics.visibility = View.VISIBLE
              }
            }
          }
          binding.diagnosticStatusDotProgress.visibility = View.VISIBLE
          binding.diagnosticStatusImage.visibility = View.INVISIBLE

          handler.removeCallbacks(diagnosticTimeoutRunnable)
          handler.postDelayed(diagnosticTimeoutRunnable, diagnosticStandTime)
        }
      }
    if ((getCurrentFileExtension() ?: "java") == "java") {
      editor.setAntlrListener(antlrListener)
      editor.setEditorListener(editorListener)
      editor.reloadListeners()
    }
  }

  private fun configureMoreOptions() {
    binding.moreOptions.setOnClickListener {
      val popm = PopupMenu(this, binding.moreOptions)

      when (getCurrentFileExtension() ?: "java") {
        "gui" -> popm.menu.add(0, 0, 0, Strings.text_view_layout)
      }

      popm.setOnMenuItemClickListener { item ->
        when (item.itemId) {
          0 -> {
            getCurrentEditor()?.let { editor ->
              editorViewModel.saveFile()
              compileGuiCode(
                code = editor.getText().toString(),
                fileName = editor.getFile().nameWithoutExtension,
              )
            }
          }
        }
        true
      }
      popm.show()
    }
  }

  private fun compileGuiCode(code: String, fileName: String) {
    val guiBuilder =
      GUIBuilder(
        context = this,
        codeComments = false,
        onGenerateCode = { code, config ->
          val intent =
            Intent(this, XMLViewerActivity::class.java).apply {
              putExtra(ExtraKeys.Gui.CODE, code)
              putExtra(ExtraKeys.Gui.CONFIG, config)
            }
          startActivity(intent)
          Log.d(GUI_COMPILER_TAG, code)
          saveGuiResultXmlCode(code = code, fileName = fileName)
        },
        onError = { Log.e(GUI_COMPILER_TAG, it) },
      )
    val guiCompiler = GUICompiler(guiBuilder = guiBuilder, code = code)
  }

  private fun saveGuiResultXmlCode(code: String, fileName: String) {
    FileUtil.writeFile(
      projectManager.getAndroidResPath().absolutePath + "/layout/${fileName}.xml",
      code,
    )
    Toast.makeText(this, getString(Strings.text_saved), Toast.LENGTH_SHORT).show()
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
        is EditorEvent.SaveFile -> saveFile()
        is EditorEvent.SaveAllFiles -> saveAllFiles()
      }
    }

    editorViewModel.files.observe(this) { openedFiles ->
      val hasOpenedFiles = openedFiles.isNotEmpty()
      binding.apply {
        tabs.isVisible = hasOpenedFiles
        noContentLayout.isVisible = !hasOpenedFiles
        save.isVisible = hasOpenedFiles
        moreOptions.isVisible = hasOpenedFiles
        undo.isVisible = hasOpenedFiles
        redo.isVisible = hasOpenedFiles
      }
    }
  }

  private fun getCurrentFileExtension(): String? {
    getCurrentEditor()?.let { editor ->
      return editor.getFile().getName().substringAfterLast(".")
    }
    return null
  }

  private fun openFile(file: File) {
    val openedFileIndex = editorViewModel.indexOfFile(file)
    if (openedFileIndex >= 0) {
      editorViewModel.setCurrentFile(openedFileIndex)
      return
    }

    val index = editorViewModel.fileCount
    val editor = RobokCodeEditor(this, file)

    editorViewModel.addFile(file)
    binding.apply {
      editorContainer.addView(editor)
      tabs.addTab(tabs.newTab())
      drawerLayout.closeDrawer(GravityCompat.START)
    }
    editorViewModel.setCurrentFile(index)
    configureEditorListeners(editor)
    updateTabs()
  }

  private fun closeFile(index: Int) {
    if (index >= 0 && index < editorViewModel.fileCount) {
      getEditorAtIndex(index)?.release()
      editorViewModel.removeFile(index)
      binding.apply {
        tabs.removeTabAt(index)
        editorContainer.removeViewAt(index)
      }
      updateTabs()
    }
  }

  private fun closeOthers() {
    if (editorViewModel.currentFileIndex >= 0) {
      val file = editorViewModel.currentFile!!
      var index: Int = 0
      while (editorViewModel.fileCount > 1) {
        val editor = getEditorAtIndex(index) ?: continue

        if (file != editor.file) {
          closeFile(index)
        } else {
          index = 1
        }
      }
      editorViewModel.setCurrentFile(editorViewModel.indexOfFile(file))
    }
  }

  private fun closeAll() {
    for (i in 0 until editorViewModel.fileCount) {
      getEditorAtIndex(i)?.release()
    }

    editorViewModel.removeAllFiles()
    binding.apply {
      tabs.removeAllTabs()
      tabs.requestLayout()
      editorContainer.removeAllViews()
    }
  }

  private fun saveFile() {
    getCurrentEditor()?.let { editor ->
      FileUtil.writeFile(editor.getFile().absolutePath, editor.getText().toString())
      Toast.makeText(this, getString(Strings.text_saved), Toast.LENGTH_SHORT).show()
    }
  }

  private fun saveAllFiles() {
    for (i in 0 until editorViewModel.fileCount) {
      val editor = getEditorAtIndex(i)
      editor?.let {
        val file = it.getFile()
        val text = it.getText().toString()
        FileUtil.writeFile(file.absolutePath, text)
      }
    }
    Toast.makeText(this, getString(Strings.text_saved_all), Toast.LENGTH_SHORT).show()
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
      })
      .whenComplete { result, error ->
        if (result == null || error != null) {
          return@whenComplete
        }

        runOnUiThread {
          result.forEach { index, name -> binding.tabs.getTabAt(index)?.text = name }
        }
      }
  }
}
