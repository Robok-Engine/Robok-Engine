package org.robok.engine.feature.compiler

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

import android.content.Context
import java.io.OutputStream
import java.io.PrintStream
import org.robok.engine.core.utils.FileUtil
import org.robok.engine.feature.compiler.logger.Logger

object SystemLogPrinter {

    @JvmStatic
    fun start(glbContext: Context, logger: Logger) {
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
