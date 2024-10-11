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
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import com.termux.view.TerminalView
import java.io.File
import org.robok.engine.RobokApplication
import org.robok.engine.core.utils.KeyboardUtil
import org.robok.engine.ui.activities.base.RobokActivity

class TerminalActivity : RobokActivity() {

    private var cwd: String? = null
    private var session: TerminalSession? = null

    private val backPressedCallback =
        object : OnBackPressedCallback(enabled = false) {
            override fun handleOnBackPressed() {
                if (session?.isRunning == false) {
                    isEnabled = true
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isEdgeToEdge = false

        onBackPressedDispatcher.addCallback(backPressedCallback)

        cwd = intent.getStringExtra("path")?.let { path ->
            if (File(path).exists()) path else filesDir.absolutePath
        } ?: filesDir.absolutePath

        setContent {
            TerminalScreen()
        }
    }

    @Composable
    private fun TerminalScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            AndroidView(
                factory = { context ->
                    TerminalView(context).apply {
                        setTextSize(24)
                        session = createSession()
                        attachSession(session)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                update = { terminalView ->
                    terminalView.onScreenUpdated()
                }
            )
        }
    }

    private fun createSession(): TerminalSession {
        val workingDir = cwd
        val tmpDir = File(filesDir.parentFile, "tmp")

        if (tmpDir.exists()) {
            tmpDir.deleteRecursively()
        }
        tmpDir.mkdirs()

        val env = arrayOf(
            "TMP_DIR=${tmpDir.absolutePath}",
            "HOME=${filesDir.absolutePath}",
            "PUBLIC_HOME=${getExternalFilesDir(null)?.absolutePath}",
            "COLORTERM=truecolor",
            "TERM=xterm-256color"
        )

        val shell = "/system/bin/sh"
        val sessionClient = RTerminalSessionClient(
            onTextChange = {
                // Aqui você pode implementar a lógica para atualizar a tela conforme necessário
            }
        )
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
        session?.close()
    }
}
