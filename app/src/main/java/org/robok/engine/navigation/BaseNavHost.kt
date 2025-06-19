package org.robok.engine.navigation

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

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType
import org.robok.engine.ui.animations.navigation.NavigationAnimationTransitions

/** The Transition used in NavHost. */
private val TransitionAnimation = NavigationAnimationTransitions.SlideFade

/**
 * Base NavHost for all NavHosts. with the animations already defined.
 *
 * @param navController the navController for this host
 * @param startDestination the route for the start destination
 * @param modifier The modifier to be applied to the layout.
 * @param contentAlignment The [Alignment] of the [AnimatedContent]
 * @param route the route for the graph
 * @param enterTransition callback to define enter transitions for destination in this host
 * @param exitTransition callback to define exit transitions for destination in this host
 * @param popEnterTransition callback to define popEnter transitions for destination in this host
 * @param popExitTransition callback to define popExit transitions for destination in this host
 * @param sizeTransform callback to define the size transform for destinations in this host
 * @param builder the builder used to construct the graph
 */
@Composable
public fun BaseNavHost(
  navController: NavHostController,
  startDestination: Any,
  modifier: Modifier = Modifier,
  contentAlignment: Alignment = Alignment.TopStart,
  route: KClass<*>? = null,
  typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
  enterTransition:
    (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
    {
      TransitionAnimation.enterTransition
    },
  exitTransition:
    (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
    {
      TransitionAnimation.exitTransition
    },
  popEnterTransition:
    (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
    {
      TransitionAnimation.popEnterTransition
    },
  popExitTransition:
    (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
    {
      TransitionAnimation.popExitTransition
    },
  sizeTransform:
    (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
    null,
  builder: NavGraphBuilder.() -> Unit,
) {
  NavHost(
    navController = navController,
    startDestination = startDestination,
    modifier = modifier,
    contentAlignment = contentAlignment,
    route = route,
    typeMap = typeMap,
    enterTransition = enterTransition,
    exitTransition = exitTransition,
    popEnterTransition = popEnterTransition,
    popExitTransition = popExitTransition,
    sizeTransform = sizeTransform,
    builder = builder,
  )
}
