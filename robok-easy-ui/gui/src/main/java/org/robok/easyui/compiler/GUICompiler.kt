package org.robok.easyui.compiler

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

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.robok.easyui.GUIBuilder
import org.robok.easyui.antlr4.GUILexer
import org.robok.easyui.antlr4.GUIParser
import org.robok.easyui.compiler.listener.GUIParserListener

/*
 * Class that uses ANTLR4 to compile the Code and use { @link GUIParserListener }.
 * @author Thiarley Rocha (ThDev-only).
 */

class GUICompiler(guiBuilder: GUIBuilder, code: String) {

    init {
        val th = Thread {
            try {
                val input = CharStreams.fromString(code)
                val lexer = GUILexer(input)
                val tokens = CommonTokenStream(lexer)
                val parser = GUIParser(tokens)

                parser.interpreter.predictionMode = PredictionMode.SLL

                val compilationUnitContext = parser.guiFile()

                val compiler = GUIParserListener(guiBuilder)
                val walker = ParseTreeWalker.DEFAULT
                walker.walk(compiler, compilationUnitContext)
            } catch (e: Exception) {
                guiBuilder.onError(e.toString())
            }
        }
        th.priority = Thread.MIN_PRIORITY
        th.start()
    }
}
