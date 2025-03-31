package org.robok.engine.feature.compiler.android.logger

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

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

class Logger {

  var logs = emptyList<Log>()

  fun d(tag: String, message: String) {
    val log = Log(SpannableString(""), SpannableString(message))
    addLog(log)
  }

  fun e(tagg: String, message: String) {
    val tag = "" // "[$tagg]"
    val messageSpan =
      SpannableString(message).apply {
        setSpan(
          ForegroundColorSpan(0xffff0000.toInt()),
          0,
          message.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    val tagSpan =
      SpannableString(tag).apply {
        setSpan(
          ForegroundColorSpan(0xffff0000.toInt()),
          0,
          tag.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    addLog(Log(tagSpan, messageSpan))
  }

  fun w(tagg: String, message: String) {
    val tag = ""
    val messageSpan =
      SpannableString(message).apply {
        setSpan(
          ForegroundColorSpan(0xffff7043.toInt()),
          0,
          message.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    val tagSpan =
      SpannableString(tag).apply {
        setSpan(
          ForegroundColorSpan(0xffff7043.toInt()),
          0,
          tag.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
      }

    addLog(Log(tagSpan, messageSpan))
  }

  private fun addLog(log: Log) {
    val mLogs = logs.toMutableList()
    mLogs.add(log)
    logs = mLogs.toList()
  }
}
