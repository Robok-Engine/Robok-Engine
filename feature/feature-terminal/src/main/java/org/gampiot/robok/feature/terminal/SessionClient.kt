package org.gampiot.robok.feature.terminal

import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import java.lang.Exception

class SessionClient : TerminalSessionClient {
  override fun onTextChanged(changedSession: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onTitleChanged(changedSession: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onSessionFinished(finishedSession: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onCopyTextToClipboard(session: TerminalSession?, text: String?) {
    TODO("Not yet implemented")
  }

  override fun onPasteTextFromClipboard(session: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onBell(session: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onColorsChanged(session: TerminalSession?) {
    TODO("Not yet implemented")
  }

  override fun onTerminalCursorStateChange(state: Boolean) {
    TODO("Not yet implemented")
  }

  override fun getTerminalCursorStyle(): Int {
    TODO("Not yet implemented")
  }

  override fun logError(tag: String?, message: String?) {
    TODO("Not yet implemented")
  }

  override fun logWarn(tag: String?, message: String?) {
    TODO("Not yet implemented")
  }

  override fun logInfo(tag: String?, message: String?) {
    TODO("Not yet implemented")
  }

  override fun logDebug(tag: String?, message: String?) {
    TODO("Not yet implemented")
  }

  override fun logVerbose(tag: String?, message: String?) {
    TODO("Not yet implemented")
  }

  override fun logStackTraceWithMessage(tag: String?, message: String?, e: Exception?) {
    TODO("Not yet implemented")
  }

  override fun logStackTrace(tag: String?, e: Exception?) {
    TODO("Not yet implemented")
  }
}