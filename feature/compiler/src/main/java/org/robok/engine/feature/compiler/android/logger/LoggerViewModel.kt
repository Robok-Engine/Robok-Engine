package org.robok.engine.feature.compiler.android.logger

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoggerViewModel : ViewModel() {

  private var _logs by mutableStateOf<List<Log>>(emptyList())
  val logs: List<Log>
    get() = _logs

  fun d(tag: String, message: String) {
    val log = Log(SpannableString(""), SpannableString(message))
    addLog(log)
  }

  fun e(tag: String, message: String) {
    val tagSpan =
      SpannableString("[$tag]").apply {
        setSpan(ForegroundColorSpan(Color.RED), 0, tag.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      }

    val messageSpan =
      SpannableString(message).apply {
        setSpan(
          ForegroundColorSpan(Color.RED), // Red color for error
          0,
          message.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    addLog(Log(tagSpan, messageSpan))
  }

  fun w(tag: String, message: String) {
    val tagSpan =
      SpannableString("[$tag]").apply {
        setSpan(
          ForegroundColorSpan(0xffff7043.toInt()), // orange
          0,
          tag.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    val messageSpan =
      SpannableString(message).apply {
        setSpan(
          ForegroundColorSpan(0xffff7043.toInt()), // Orange color for warning
          0,
          message.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    addLog(Log(tagSpan, messageSpan))
  }

  private fun addLog(log: Log) {
    val updatedLogs = _logs.toMutableList().apply { add(log) }
    _logs = updatedLogs.toList()
  }
}
