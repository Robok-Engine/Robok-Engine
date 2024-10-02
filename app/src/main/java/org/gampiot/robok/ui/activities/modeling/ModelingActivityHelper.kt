package org.gampiot.robok.ui.activities.modeling

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

import androidx.compose.ui.platform.ComposeView

import org.gampiot.robok.ui.theme.RobokTheme
import org.gampiot.robok.ui.screens.modeling.ModelingScreen

/*
* Class to create ComposeView in 3D Modeling.
* @author Aquiles Trindade (trindadedev).
*/

class ModelingActivityHelper(
   private val context: Context 
) {
    fun createComposeView(): ComposeView {
        return ComposeView(context).apply {
            setContent {
                 RobokTheme {
                     ModelingScreen()
                 }
            }
        }
    }
}