package org.robok.engine.ui.animations.navigation

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

import android.graphics.Path
import android.view.animation.PathInterpolator
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.IntOffset

object NavigationAnimationTransitions {
  object ScaleFadeSlide {
    val enterTransition =
      scaleIn(animationSpec = tween(250), initialScale = 0.7f) +
        fadeIn(animationSpec = tween(250)) +
        slideInHorizontally { it / 2 }

    val exitTransition =
      scaleOut(animationSpec = tween(200), targetScale = 0.7f) +
        fadeOut(animationSpec = tween(200)) +
        slideOutHorizontally { -it / 2 }

    val popEnterTransition =
      scaleIn(animationSpec = tween(250), initialScale = 0.7f) +
        fadeIn(animationSpec = tween(250)) +
        slideInHorizontally { -it / 2 }

    val popExitTransition =
      scaleOut(animationSpec = tween(200), targetScale = 0.7f) +
        fadeOut(animationSpec = tween(200)) +
        slideOutHorizontally { it / 2 }
  }

  object FadeSlide {
    val enterTransition = fadeIn(tween(250)) + slideInHorizontally { it / 2 }

    val exitTransition = fadeOut(tween(200)) + slideOutHorizontally { -it / 2 }

    val popEnterTransition = fadeIn(tween(250)) + slideInHorizontally { -it / 2 }

    val popExitTransition = fadeOut(tween(200)) + slideOutHorizontally { it / 2 }
  }

  object SlideFade {
    private val easing = Easing { f ->
      PathInterpolator(
          Path().apply {
            moveTo(0f, 0f)
            cubicTo(0.04F, 0F, 0.1F, 0.05F, 0.2F, 0.5F)
            cubicTo(0.20F, 0.8F, 0.2F, 1F, 1F, 1F)
          }
        )
        .getInterpolation(f)
    }

    private const val tweenDuration = 350
    private const val initialOffset = 0.10f

    private val enterTween = tween<IntOffset>(durationMillis = tweenDuration, easing = easing)
    private val exitTween = tween<IntOffset>(durationMillis = tweenDuration, easing = easing)
    private val fadeTween = tween<Float>(durationMillis = 150)
    private val slidePositiveOffset: (fullWidth: Int) -> Int = { (it * initialOffset).toInt() }
    private val slideNegativeOffset: (fullWidth: Int) -> Int = { -(it * initialOffset).toInt() }

    public val enterTransition =
      slideInHorizontally(enterTween, slidePositiveOffset) + fadeIn(fadeTween)

    public val exitTransition =
      slideOutHorizontally(exitTween, slideNegativeOffset) + fadeOut(fadeTween)

    public val popEnterTransition =
      slideInHorizontally(enterTween, slideNegativeOffset) + fadeIn(fadeTween)

    public val popExitTransition =
      slideOutHorizontally(exitTween, slidePositiveOffset) + fadeOut(fadeTween)
  }
}
