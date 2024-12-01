package org.robok.engine.ui.activities.editor.drawer.info.diagnostic.viewmodel

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
 
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.robok.engine.ui.activities.editor.drawer.info.diagnostic.models.Diagnostic

class DiagnosticViewModel: ViewModel() {
  private var _diagnostics = mutableStateListOf<Diagnostic>()
  val diagnostics: List<Diagnostic>
    get() = _diagnostics.toList()
    
  fun addDiagnostic(diagnostic: Diagnostic) {
    _diagnostics.add(diagnostic)
  }
  
  fun removeDiagnostic(diagnostic: Diagnostic) {
    _diagnostics.remove(diagnostic)
  }
  
  fun removeDiagnosticAt(index: Int) {
    _diagnostics.removeAt(index)
  }
  
  fun clearDiagnostics() {
    _diagnostics.clear()
  }
}