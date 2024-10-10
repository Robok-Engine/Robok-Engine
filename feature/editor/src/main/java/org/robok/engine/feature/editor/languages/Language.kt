package org.robok.engine.feature.editor.languages

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

import org.robok.antlr4.java.AntlrListener
import org.robok.engine.feature.editor.EditorListener

/*
 * A Interface base for Languages.
 * @extends Extends a Sora Editor Language.
 * @author Aquiles Trindade (trindadedev).
 */

interface Language : io.github.rosemoe.sora.lang.Language {
    /*
     * Set the listener of editor
     * @link EditorListener.kt
     */
    fun setEditorListener(editorListener: EditorListener)

    /*
     * Set the listener of editor
     * @link AntlrListener, module robok:robok:antlr4
     */
    fun setAntlrListener(antlrListener: AntlrListener)
}
