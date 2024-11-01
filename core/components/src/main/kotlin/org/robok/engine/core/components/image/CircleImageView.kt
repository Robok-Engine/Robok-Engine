package org.robok.engine.core.components.image

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

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class CircleImageView
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = -1) :
  ShapeableImageView(context, attrs, defStyleAttr) {

  private var shapeDrawableAnimator: ValueAnimator? = null

  init {
    val shapeAppearanceModel =
      ShapeAppearanceModel.builder()
        .setAllCornerSizes(
          object : CornerSize {
            override fun getCornerSize(bounds: RectF): Float {
              return bounds.height() / 2
            }
          }
        )
        .build()
    background = MaterialShapeDrawable(shapeAppearanceModel)
  }

  override fun setBackgroundColor(color: Int) {
    (background as MaterialShapeDrawable).setFillColor(ColorStateList.valueOf(color))
  }

  fun setBackgroundColorRes(@ColorRes color: Int) {
    setBackgroundColor(ResourcesCompat.getColor(resources, color, context.theme))
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, widthMeasureSpec)
  }

  @SuppressLint("ClickableViewAccessibility")
  override fun onTouchEvent(event: MotionEvent): Boolean {
    when (event.action) {
      MotionEvent.ACTION_DOWN -> {
        shapeDrawableAnimator =
          ValueAnimator.ofFloat(2f, 4f).apply {
            addUpdateListener { animation ->
              (background as MaterialShapeDrawable).setCornerSize(
                object : CornerSize {
                  override fun getCornerSize(bounds: RectF): Float {
                    return bounds.height() / animation.animatedValue as Float
                  }
                }
              )
            }
            start()
          }
      }
      MotionEvent.ACTION_CANCEL,
      MotionEvent.ACTION_UP -> {
        shapeDrawableAnimator?.reverse()
      }
    }
    return super.onTouchEvent(event)
  }
}
