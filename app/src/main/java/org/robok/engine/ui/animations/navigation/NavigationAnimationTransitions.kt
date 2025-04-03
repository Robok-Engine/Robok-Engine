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
      PathInterpolator(Path().apply {
          moveTo(0f, 0f)
          cubicTo(0.04F, 0F, 0.1F, 0.05F, 0.2F, 0.5F)
          cubicTo(0.20F, 0.8F, 0.2F, 1F, 1F, 1F)
      }).getInterpolation(f)
    }

    private const val tweenDuration = 350
    private const val initialOffset = 0.10f

    private val enterTween = tween<IntOffset>(durationMillis = tweenDuration, easing = easing)
    private val exitTween = tween<IntOffset>(durationMillis = tweenDuration, easing = easing)
    private val fadeTween = tween<Float>(durationMillis = 150)
    private val slidePositiveOffset: (fullWidth: Int) -> Int = { (it * initialOffset).toInt() }
    private val slideNegativeOffset: (fullWidth: Int) -> Int = { -(it * initialOffset).toInt() }

    public val enterTransition = slideInHorizontally(enterTween, slidePositiveOffset) + fadeIn(fadeTween)

    public val exitTransition = slideOutHorizontally(exitTween, slideNegativeOffset) + fadeOut(fadeTween)

    public val popEnterTransition = slideInHorizontally(enterTween, slideNegativeOffset) + fadeIn(fadeTween)

    public val popExitTransition = slideOutHorizontally(exitTween, slidePositiveOffset) + fadeOut(fadeTween)
  }
}
