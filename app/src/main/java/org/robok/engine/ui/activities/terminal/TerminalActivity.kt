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

import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.OnBackPressedCallback
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSessio
import java.io.File
import org.robok.engine.core.utils.base.RobokActivity
import org.robok.engine.databinding.ActivityTerminalBinding

/*
 * TO-DO: Refactor with Compose.
 */

class TerminalActivity : RobokActivity() {

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
        //binding.terminalView.setTerminalViewClient(this)
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
        val sessionClient = RTerminalSessionClient()
        return TerminalSession(
            shell,
            workingDir,
            arrayOf(""),
            env,
            TerminalEmulator.DEFAULT_TERMINAL_TRANSCRIPT_ROWS,
            sessionClient
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
