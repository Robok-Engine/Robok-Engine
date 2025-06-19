package org.robok.engine.feature.compiler.android

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

import android.content.Context
import java.io.OutputStream
import java.io.PrintStream
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.feature.compiler.android.logger.LoggerViewModel

object SystemLogPrinter {

  @JvmStatic
  fun start(glbContext: Context, logger: LoggerViewModel) {
    // Reset the log file
    FileUtil.writeFile("${glbContext.getExternalFilesDir(null)}/logs.txt", "")

    val ps =
      PrintStream(
        object : OutputStream() {
          private var cache: String? = null

          override fun write(b: Int) {
            if (cache == null) cache = ""

            if (b.toChar() == '\n') {
              // Write each line printed to the specified path
              logger.d("System.out", cache ?: "")
              cache = ""
            } else {
              cache += b.toChar()
            }
          }
        }
      )

    System.setOut(ps)
    System.setErr(ps)
  }
}
