package org.gampiot.robok.feature.terminal

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

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import com.termux.view.TerminalViewClient
import org.gampiot.robok.feature.res.R
import org.gampiot.robok.feature.terminal.databinding.ActivityTerminalBinding
import org.gampiot.robok.feature.terminal.databinding.LayoutDialogInputBinding
import org.gampiot.robok.feature.util.KeyboardUtil
import org.gampiot.robok.feature.util.base.RobokActivity
import java.io.File

class TerminalActivity : RobokActivity(), TerminalSessionClient, TerminalViewClient {
  private var binding: ActivityTerminalBinding? = null
  private var cwd: String? = null
  private var session: TerminalSession? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityTerminalBinding.inflate(
      layoutInflater
    )
    setContentView(binding!!.getRoot())

    cwd = if (intent.hasExtra("path")) {
      val path = intent.getStringExtra("path")
      if (File(path.toString()).exists().not()){
        filesDir.absolutePath
      }else{
        path
      }
    } else {
      filesDir.absolutePath
    }

    binding!!.terminalView.setTextSize(28)
    session = createSession()
    binding!!.terminalView.attachSession(session)
    binding!!.terminalView.setTerminalViewClient(this)
    configureFabs()
  }

  fun configureFabs() {
    setOptionsVisibility(true)
    binding!!.terminalOptionsButton.setOnClickListener { view: View? -> setOptionsVisibility(false) }
    binding!!.closeButton.setOnClickListener { view: View? -> setOptionsVisibility(true) }
    binding!!.installPackageButton.setOnClickListener { v: View? ->
      showInstallPackageDialog()
      setOptionsVisibility(true)
    }
    binding!!.updatePackagesButton.setOnClickListener { v: View? ->
      showUpdatePackagesDialog()
      setOptionsVisibility(true)
    }
  }

  private fun createSession(): TerminalSession {
    val workingDir = cwd
    val tmpDir = File(filesDir.parentFile, "tmp")

    if (tmpDir.exists()) {
      tmpDir.deleteRecursively()
      tmpDir.mkdirs()
    } else {
      tmpDir.mkdirs()
    }

    val env = arrayOf(
      "TMP_DIR=${tmpDir.absolutePath}",
      "HOME=" + filesDir.absolutePath,
      "PUBLIC_HOME=" + getExternalFilesDir(null)?.absolutePath,
      "COLORTERM=truecolor",
      "TERM=xterm-256color"
    )

    val shell = "/system/bin/sh"

    return TerminalSession(
      shell,
      workingDir,
      arrayOf(""),
      env,
      TerminalEmulator.DEFAULT_TERMINAL_TRANSCRIPT_ROWS,
      this,
    )
  }

  fun setOptionsVisibility(isHide: Boolean) {
    binding!!.terminalOptionsLayout.animate()
      .translationY((if (isHide) 300 else 0).toFloat())
      .alpha((if (isHide) 0 else 1).toFloat())
      .setInterpolator(OvershootInterpolator())

    binding!!.terminalOptionsButton.animate()
      .translationY((if (isHide) 0 else 300).toFloat())
      .alpha((if (isHide) 1 else 0).toFloat())
      .setInterpolator(OvershootInterpolator())
  }

  fun showInstallPackageDialog() {
    val dialogBinding = LayoutDialogInputBinding.inflate(
      layoutInflater
    )
    val textField = dialogBinding.dialogEdittext
    textField.hint = getString(R.string.terminal_install_package_hint)
    textField.setCornerRadius(15f)

    val dialog = MaterialAlertDialogBuilder(this)
      .setView(dialogBinding.root)
      .setTitle(getString(R.string.terminal_install_package))
      .setMessage(getString(R.string.terminal_install_package_hint))
      .setPositiveButton("Install", null)
      .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
      .create()

    dialog.setOnShowListener { dialogInterface: DialogInterface ->
      val positiveButton =
        (dialogInterface as AlertDialog).getButton(DialogInterface.BUTTON_POSITIVE)
      positiveButton.setOnClickListener { view: View? ->
        val packageName = textField.text.toString().trim { it <= ' ' }
        if (packageName.isEmpty()) {
          Toast.makeText(this, getString(R.string.error_invalid_name), 4000).show()
        } else {
          installPackage(packageName)
        }
        dialogInterface.dismiss()
      }
    }
    dialog.setView(dialogBinding.root)
    dialog.show()
    dialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
    textField.requestFocus()
  }

  fun showUpdatePackagesDialog() {
    val dialog = MaterialAlertDialogBuilder(this)
      .setTitle(getString(R.string.terminal_update_packages))
      .setMessage(getString(R.string.terminal_warning_update_packages))
      .setPositiveButton("Update") { dialogInterface: DialogInterface?, i: Int -> }
      .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
      .create()
    dialog.show()
  }

  fun installPackage(packageName: String?) {
    // TO-DO : logic to install package 
  }

  override fun onDestroy() {
    super.onDestroy()
    binding = null
  }

  override fun onScale(scale: Float): Float {
    return 1f
  }

  override fun onSingleTapUp(e: MotionEvent) {
    val kUtil = KeyboardUtil()
    kUtil.showSoftInput(binding!!.terminalView)
  }

  override fun shouldBackButtonBeMappedToEscape(): Boolean {
    return false
  }

  override fun shouldEnforceCharBasedInput(): Boolean {
    return true
  }

  override fun shouldUseCtrlSpaceWorkaround(): Boolean {
    return false
  }

  override fun isTerminalViewSelected(): Boolean {
    return true
  }

  override fun copyModeChanged(copyMode: Boolean) {}

  override fun onKeyDown(keyCode: Int, e: KeyEvent, session: TerminalSession): Boolean {
    if (!session.isRunning) {
      if (e.keyCode == KeyEvent.KEYCODE_ENTER) {
        finish()
      }
    }
    return false
  }


  override fun onKeyUp(keyCode: Int, e: KeyEvent?): Boolean {
    return false
  }

  override fun onLongPress(event: MotionEvent): Boolean {
    return false
  }

  override fun readControlKey(): Boolean {
    return false
  }

  override fun readAltKey(): Boolean {
    return false
  }

  override fun readFnKey(): Boolean {
    return false
  }

  override fun readShiftKey(): Boolean {
    return false
  }

  override fun onCodePoint(codePoint: Int, ctrlDown: Boolean, session: TerminalSession): Boolean {
    return false
  }

  override fun onEmulatorSet() {}

  override fun logError(tag: String, message: String) {}

  override fun logWarn(tag: String, message: String) {}

  override fun logInfo(tag: String, message: String) {}

  override fun logDebug(tag: String, message: String) {}

  override fun logVerbose(tag: String, message: String) {}

  override fun logStackTraceWithMessage(tag: String, message: String, e: Exception) {}

  override fun logStackTrace(tag: String, e: Exception) {}

  override fun onTextChanged(changedSession: TerminalSession) {
    binding!!.terminalView.onScreenUpdated()
  }

  override fun onTitleChanged(changedSession: TerminalSession) {}

  override fun onSessionFinished(finishedSession: TerminalSession) {}

  override fun onBell(session: TerminalSession) {}

  override fun onColorsChanged(session: TerminalSession) {}

  override fun onTerminalCursorStateChange(state: Boolean) {}

  override fun getTerminalCursorStyle(): Int {
    return TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE
  }

  override fun onCopyTextToClipboard(arg0: TerminalSession, arg1: String) {}

  override fun onPasteTextFromClipboard(session: TerminalSession?) {
  }

  @MainThread
  override fun onBackPressed() {
    if (!session!!.isRunning) {
      super.onBackPressed()
    }
  }
}
