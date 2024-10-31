package org.robok.engine.ui.screens.terminal

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

import android.app.Activity
import android.graphics.Color as AndroidColor
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import com.termux.view.TerminalView
import java.io.File
import org.robok.engine.RobokApplication
import org.robok.engine.core.utils.KeyboardUtil

private var cwd: String? = null
private var session: TerminalSession? = null
private var terminalView: TerminalView? = null

@Composable
fun TerminalScreen(path: String? = null) {
    cwd =
        path?.let { path ->
            if (File(path).exists()) path else RobokApplication.instance.filesDir.absolutePath
        } ?: RobokApplication.instance.filesDir.absolutePath
    LaunchedEffect(Unit){
        PhoneBars(AndroidColor.BLACK)
    }
    BackHandler {
        PhoneBars(AndroidColor.TRANSPARENT)
    }
    Column(Modifier.padding(top = 40.dp).background(Color.Black)) { TerminalView() }
}

@Composable
private fun PhoneBars(color: Int) {
    val activity = LocalContext.current as? Activity
    activity?.let {
        it.window.setNavigationBarColor(color)
        it.window.setStatusBarColor(color)
    }
}

@Composable
private fun TerminalView(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            TerminalView(context, null).apply {
                setTextSize(24)
                session = createSession()
                attachSession(session)
                val viewClient =
                    RTerminalViewClient(
                        onSingleTap = {
                            val kUtil = KeyboardUtil(RobokApplication.instance)
                            kUtil.showSoftInput(this)
                        },
                        onKeyEventEnter = {
                            // finish()
                        },
                    )
                setTerminalViewClient(viewClient)
                terminalView = this
            }
        },
        modifier = modifier,
        update = { terminalView -> onScreenChanged() },
    )
}

private fun onScreenChanged() {
    terminalView?.onScreenUpdated()
}

private fun createSession(): TerminalSession {
    val workingDir = cwd
    val tmpDir = File(RobokApplication.instance.filesDir.parentFile, "tmp")

    if (tmpDir.exists()) {
        tmpDir.deleteRecursively()
    }
    tmpDir.mkdirs()

    val env =
        arrayOf(
            "TMP_DIR=${tmpDir.absolutePath}",
            "HOME=${RobokApplication.instance.filesDir.absolutePath}",
            "PUBLIC_HOME=${RobokApplication.instance.getExternalFilesDir(null)?.absolutePath}",
            "COLORTERM=truecolor",
            "TERM=xterm-256color",
        )

    val shell = "/system/bin/sh"
    val sessionClient = RTerminalSessionClient(onTextChange = { onScreenChanged() })
    return TerminalSession(
        shell,
        workingDir,
        arrayOf(""),
        env,
        TerminalEmulator.DEFAULT_TERMINAL_TRANSCRIPT_ROWS,
        sessionClient,
    )
}
