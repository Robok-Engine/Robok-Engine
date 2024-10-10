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

import android.view.KeyEvent
import android.view.MotionEvent
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import org.robok.engine.RobokApplication
import org.robok.engine.core.utils.KeyboardUtil

class RTerminalSessionClient: TerminalSessionClient {

    private var cwd: String? = null
    
    

    

    override fun onEmulatorSet() {}

    override fun logError(tag: String, message: String) {}

    override fun logWarn(tag: String, message: String) {}

    override fun logInfo(tag: String, message: String) {}

    override fun logDebug(tag: String, message: String) {}

    override fun logVerbose(tag: String, message: String) {}

    override fun logStackTraceWithMessage(tag: String, message: String, e: Exception) {}

    override fun logStackTrace(tag: String, e: Exception) {}

    override fun onTextChanged(changedSession: TerminalSession) {
        //binding.terminalView.onScreenUpdated()
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
