package org.robok.engine.ui.animations.navigation

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

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object NavigationAnimationTransitions {

    val enterTransition = fadeIn(tween(250)) + slideInHorizontally { it / 2 }

    val exitTransition = fadeOut(tween(200)) + slideOutHorizontally { -it / 2 }

    val popEnterTransition = fadeIn(tween(250)) + slideInHorizontally { -it / 2 }

    val popExitTransition = fadeOut(tween(200)) + slideOutHorizontally { it / 2 }
}
