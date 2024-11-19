package org.robok.engine.core.utils

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

import android.util.Log

object RobokLog {
  private val logs: MutableList<String> = mutableListOf()

  @JvmStatic
  fun d(tag: String = "RobokLog", message: String) {
    val logMessage = "DEBUG: [$tag] $message"
    logs.add(logMessage)
    Log.d(tag, message)
  }

  @JvmStatic
  fun e(tag: String = "RobokLog", message: String) {
    val logMessage = "ERROR: [$tag] $message"
    logs.add(logMessage)
    Log.e(tag, message)
  }

  @JvmStatic
  fun i(tag: String = "RobokLog", message: String) {
    val logMessage = "INFO: [$tag] $message"
    logs.add(logMessage)
    Log.i(tag, message)
  }

  @JvmStatic fun getLogs(): List<String> = logs
}
