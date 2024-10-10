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
import com.termux.view.TerminalViewClient
import org.robok.engine.RobokApplication
import org.robok.engine.core.utils.KeyboardUtil

class RTerminalViewClient: TerminalViewClient {
    override fun onScale(scale: Float): Float {
        return 1f
    }

    override fun onSingleTapUp(e: MotionEvent) {
        val kUtil = KeyboardUtil(RobokApplication.instance)
        //kUtil.showSoftInput(binding.terminalView)
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
}