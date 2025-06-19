package org.robok.engine.ui.core.components.image

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
