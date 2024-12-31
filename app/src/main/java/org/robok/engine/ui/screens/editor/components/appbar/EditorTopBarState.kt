package org.robok.engine.ui.screens.editor.components.appbar

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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable fun rememberEditorTopBarState() = remember { EditorTopBarState() }

data class EditorTopBarState(
  val title: String = "Robok",
  val onNavigationIconClick: () -> Unit = {},
  val actions: List<EditorTopBarAction> = emptyList(),
  val menuItems: List<EditorTopBarMenuItem> = emptyList(),
)
