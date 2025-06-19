package org.robok.engine.core.utils

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.util.Log as AndroidLog

object Log {
  private val logs: MutableList<String> = mutableListOf()

  @JvmStatic
  fun d(tag: String = "Robok", message: String) {
    val logMessage = "DEBUG: [$tag] $message"
    logs.add(logMessage)
    AndroidLog.d(tag, message)
  }

  @JvmStatic
  fun e(tag: String = "Robok", message: String) {
    val logMessage = "ERROR: [$tag] $message"
    logs.add(logMessage)
    AndroidLog.e(tag, message)
  }

  @JvmStatic
  fun i(tag: String = "Robok", message: String) {
    val logMessage = "INFO: [$tag] $message"
    logs.add(logMessage)
    AndroidLog.i(tag, message)
  }

  @JvmStatic fun getLogs(): List<String> = logs
}
