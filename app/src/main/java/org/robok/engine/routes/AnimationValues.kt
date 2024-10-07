package org.robok.engine.routes

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

import androidx.navigation.NavBackStackEntry
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

import soup.compose.material.motion.animation.materialSharedAxisXIn
import soup.compose.material.motion.animation.materialSharedAxisXOut

object AnimationTransitions {

    val enterTransition: (NavBackStackEntry, NavBackStackEntry?) -> EnterTransition? = { _, _ ->
        materialSharedAxisXIn(forward = true, slideDistance = AnimationValues.SlideDistance, durationMillis = AnimationValues.SlideDuration)
    }

    val exitTransition: (NavBackStackEntry, NavBackStackEntry?) -> ExitTransition? = { _, _ ->
        materialSharedAxisXOut(forward = true, slideDistance = AnimationValues.SlideDistance, durationMillis = AnimationValues.SlideDuration)
    }

    val popEnterTransition: (NavBackStackEntry, NavBackStackEntry?) -> EnterTransition? = { _, _ ->
        materialSharedAxisXIn(forward = false, slideDistance = AnimationValues.SlideDistance, durationMillis = AnimationValues.SlideDuration)
    }

    val popExitTransition: (NavBackStackEntry, NavBackStackEntry?) -> ExitTransition? = { _, _ ->
        materialSharedAxisXOut(forward = false, slideDistance = AnimationValues.SlideDistance, durationMillis = AnimationValues.SlideDuration)
    }
}

object AnimationValues {
    const val SlideDistance: Int = 100
    const val SlideDuration: Int = 700
}