package org.robok.engine.ui.screens.terminal.client

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
import com.termux.terminal.TerminalSession

class TerminalViewClient(
  private val onSingleTap: () -> Unit,
  private val onKeyEventEnter: () -> Unit,
) : com.termux.view.TerminalViewClient {
  override fun onScale(scale: Float): Float {
    return 1f
  }

  override fun onSingleTapUp(e: MotionEvent) {
    onSingleTap()
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
        onKeyEventEnter()
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
}
