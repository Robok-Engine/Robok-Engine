package org.robok.engine.core.components.terminal

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
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.robok.engine.core.components.databinding.LayoutBottomsheetTerminalBinding
import org.robok.engine.core.components.log.Log

/*
 * A Basic BottomSheet for Logs.
 * @author Aquiles Trindade (trindadedev).
 */

open class RobokTerminal(context: Context) : BottomSheetDialog(context) {

  val binding: LayoutBottomsheetTerminalBinding =
    LayoutBottomsheetTerminalBinding.inflate(LayoutInflater.from(context))

  val terminal = binding.terminal
  val terminalTitle = binding.terminalTitle

  init {
    setContentView(binding.root)
    setCancelable(true)
  }

  open fun addLog(value: String) {
    val log = Log(context, value)
    terminal.addView(log)
  }

  open fun setTerminalTitle(title: String) {
    terminalTitle.text = title
  }

  open fun getTerminalTitle(): String {
    return terminalTitle.text.toString()
  }
}
