package org.robok.engine.ui.activities.terminal

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
 *   along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import com.termux.view.TerminalViewClient
import java.io.File
import org.robok.engine.RobokApplication
import org.robok.engine.core.utils.KeyboardUtil
import org.robok.engine.core.utils.base.RobokActivity
import org.robok.engine.databinding.ActivityTerminalBinding
import org.robok.engine.databinding.LayoutDialogInputBinding
import org.robok.engine.strings.Strings

/*
 * TO-DO: Refactor with Compose.
 */

class TerminalActivity : RobokActivity(), TerminalSessionClient, TerminalViewClient {

    private var _binding: ActivityTerminalBinding? = null
    private val binding
        get() = _binding!!

    private var cwd: String? = null
    private var session: TerminalSession? = null

    private val backPressedCallback =
        object : OnBackPressedCallback(enabled = false) {
            override fun handleOnBackPressed() {
                if (!session!!.isRunning) {
                    isEnabled = true
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        isEdgeToEdge = false
        super.onCreate(savedInstanceState)

        onBackPressedDispatcher.addCallback(backPressedCallback)

        _binding = ActivityTerminalBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        
        cwd =
            if (intent.hasExtra("path")) {
                val path = intent.getStringExtra("path")
                if (File(path.toString()).exists().not()) {
                    filesDir.absolutePath
                } else {
                    path
                }
            } else {
                filesDir.absolutePath
            }

        binding.terminalView.setTextSize(24)
        session = createSession()
        binding.terminalView.attachSession(session)
        binding.terminalView.setTerminalViewClient(this)
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

        val env =
            arrayOf(
                "TMP_DIR=${tmpDir.absolutePath}",
                "HOME=" + filesDir.absolutePath,
                "PUBLIC_HOME=" + getExternalFilesDir(null)?.absolutePath,
                "COLORTERM=truecolor",
                "TERM=xterm-256color",
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onScale(scale: Float): Float {
        return 1f
    }

    override fun onSingleTapUp(e: MotionEvent) {
        val kUtil = KeyboardUtil(RobokApplication.instance)
        kUtil.showSoftInput(binding.terminalView)
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
        binding.terminalView.onScreenUpdated()
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

    override fun onPasteTextFromClipboard(session: TerminalSession?) {}
}
