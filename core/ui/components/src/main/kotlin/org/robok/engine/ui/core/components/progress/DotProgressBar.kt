package org.robok.engine.ui.core.components.progress

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

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.LinearLayout
import org.robok.engine.ui.core.components.R

/*
 * A basic progress bar with points.
 * @author Sourabh  Gupta.
 */

class DotProgressBar : FrameLayout {

  private var margin: Int = 0
  private var dotRadius: Int = 0
  private var numberOfDots = 3
  private val animators = mutableListOf<Animator>()
  private var animationDuration = 1000L
  private var minScale = 0.5f
  private var maxScale = 1f
  private var primaryAnimator: ValueAnimator? = null
  private lateinit var dotProgressBar: LinearLayout
  private var dotBackground = R.drawable.ic_dot_24
  private var dotAnimator: ValueAnimator? = null

  constructor(context: Context) : super(context) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    initAttributes(context, attrs)
    init()
  }

  constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int,
  ) : super(context, attrs, defStyleAttr) {
    initAttributes(context, attrs)
    init()
  }

  private fun initAttributes(context: Context, attrs: AttributeSet) {
    val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.DotProgressBar, 0, 0)

    try {
      dotRadius =
        typedArray.getDimensionPixelSize(
          R.styleable.DotProgressBar_dotRadius,
          convertDpToPixel(8f, context),
        )
      numberOfDots = typedArray.getInt(R.styleable.DotProgressBar_numberOfDots, 3)
      animationDuration =
        typedArray.getInt(R.styleable.DotProgressBar_animationDuration, 1000).toLong()
      minScale = typedArray.getFloat(R.styleable.DotProgressBar_minScale, 0.5f)
      maxScale = typedArray.getFloat(R.styleable.DotProgressBar_maxScale, 1f)
      dotBackground =
        typedArray.getResourceId(R.styleable.DotProgressBar_dotBackground, R.drawable.ic_dot_24)
      margin =
        typedArray.getDimensionPixelSize(
          R.styleable.DotProgressBar_margin,
          convertDpToPixel(4f, context),
        )
    } finally {
      typedArray.recycle()
    }
  }

  private fun init() {
    clipChildren = false
    clipToPadding = false
    dotProgressBar = LinearLayout(context)
    val progressBarLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    progressBarLayoutParams.gravity = Gravity.CENTER
    dotProgressBar.layoutParams = progressBarLayoutParams
    dotProgressBar.clipChildren = false
    dotProgressBar.clipToPadding = false
    addView(dotProgressBar)
    animators.clear()
    for (i in 0 until numberOfDots) {
      val dot = View(context)
      val layoutParams = LayoutParams(dotRadius * 2, dotRadius * 2)
      layoutParams.setMargins(margin, margin, margin, margin)
      dot.layoutParams = layoutParams
      dot.scaleX = minScale
      dot.scaleY = minScale
      dot.setBackgroundResource(dotBackground)
      dotProgressBar.addView(dot)
      val animator = getScaleAnimator(dot)
      animators.add(animator)
    }
    primaryAnimator?.cancel()
    primaryAnimator = ValueAnimator.ofInt(0, numberOfDots)
    primaryAnimator?.addUpdateListener {
      if (it.animatedValue != numberOfDots) animators[it.animatedValue as Int].start()
    }
    primaryAnimator?.repeatMode = ValueAnimator.RESTART
    primaryAnimator?.repeatCount = ValueAnimator.INFINITE
    primaryAnimator?.duration = animationDuration
    primaryAnimator?.interpolator = LinearInterpolator()
  }

  private fun getScaleAnimator(view: View): Animator {
    if (dotAnimator != null) return dotAnimator as ValueAnimator
    val animator = ValueAnimator.ofFloat(minScale, maxScale)
    animator.addUpdateListener {
      view.scaleX = it.animatedValue as Float
      view.scaleY = it.animatedValue as Float
    }
    animator.duration = animationDuration / numberOfDots
    animator.repeatCount = 1
    animator.repeatMode = ValueAnimator.REVERSE
    animator.interpolator = LinearInterpolator()
    return animator
  }

  fun stopAnimation() {
    primaryAnimator?.cancel()
  }

  fun startAnimation() {
    primaryAnimator?.start()
  }

  fun isAnimationRunning(): Boolean {
    return primaryAnimator?.isRunning == true
  }

  override fun setVisibility(visibility: Int) {
    if (visibility == View.VISIBLE) startAnimation() else stopAnimation()
    super.setVisibility(visibility)
  }

  class Builder {
    private var margin = 4
    private var dotRadius = 8
    private var numberOfDots = 3
    private var animationDuration = 1000L
    private var minScale = 0.5f
    private var maxScale = 1f
    private var primaryAnimator: ValueAnimator? = null
    private var dotBackground = R.drawable.ic_dot_24

    fun build(context: Context): DotProgressBar {
      val dotProgressBar = DotProgressBar(context)
      dotProgressBar.maxScale = maxScale
      dotProgressBar.minScale = minScale
      dotProgressBar.numberOfDots = numberOfDots
      dotProgressBar.animationDuration = animationDuration
      dotProgressBar.margin = convertDpToPixel(margin.toFloat(), context)
      dotProgressBar.dotRadius = convertDpToPixel(dotRadius.toFloat(), context)
      dotProgressBar.primaryAnimator = primaryAnimator
      dotProgressBar.dotBackground = dotBackground
      dotProgressBar.init()
      return dotProgressBar
    }

    fun setMargin(margin: Int): Builder {
      this.margin = margin
      return this
    }

    fun setDotRadius(dotRadius: Int): Builder {
      this.dotRadius = dotRadius
      return this
    }

    fun setNumberOfDots(numberOfDots: Int): Builder {
      this.numberOfDots = numberOfDots
      return this
    }

    fun setMaxScale(maxScale: Float): Builder {
      this.maxScale = maxScale
      return this
    }

    fun setMinScale(minScale: Float): Builder {
      this.minScale = minScale
      return this
    }

    fun setAnimationDuration(duration: Long): Builder {
      this.animationDuration = duration
      return this
    }

    fun setDotBackground(dotBackground: Int): Builder {
      this.dotBackground = dotBackground
      return this
    }
  }

  companion object {
    fun convertDpToPixel(dp: Float, context: Context): Int {
      return (dp *
          (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
        .toInt()
    }
  }
}
