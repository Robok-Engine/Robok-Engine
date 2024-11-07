package org.robok.engine.feature.xmlviewer.lib.ui

/**
 * Copyright (C) 2020 Coyamo
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.util.TypedValue
import android.widget.FrameLayout

class DefaultView(context: Context) : FrameLayout(context) {

  private var text: String = "null"
  private val paint: Paint
  private val minSize: Int

  init {
    setWillNotDraw(false)

    val padding =
      TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5f, context.resources.displayMetrics)
        .toInt()
    setPadding(padding, padding, padding, padding)

    paint =
      Paint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = Typeface.MONOSPACE
        color = Color.GRAY
        textSize =
          TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            18f,
            context.resources.displayMetrics,
          )
      }

    minSize =
      TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, context.resources.displayMetrics)
        .toInt()
  }

  fun setDisplayText(cs: CharSequence?) {
    text = cs?.toString() ?: "null"
    invalidate()
  }

  override fun onDraw(canvas: Canvas) {
    val fontMetrics = paint.fontMetricsInt
    val dy = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
    val baseLineY = height / 2 + dy
    val baseLineX = (width - Math.min(width, paint.measureText(text).toInt())) / 2
    canvas.drawText(text, baseLineX.toFloat(), baseLineY.toFloat(), paint)
  }

  override fun dispatchDraw(canvas: Canvas) {
    // Não chama o método super para não desenhar os filhos
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    val widthMode = MeasureSpec.getMode(widthMeasureSpec)
    val heightMode = MeasureSpec.getMode(heightMeasureSpec)

    var width = MeasureSpec.getSize(widthMeasureSpec)
    var height = MeasureSpec.getSize(heightMeasureSpec)

    val bounds = Rect()
    paint.getTextBounds(text, 0, text.length, bounds)

    if (widthMode == MeasureSpec.AT_MOST) {
      width = Math.max(minSize, bounds.width() + paddingLeft + paddingRight)
    }
    if (heightMode == MeasureSpec.AT_MOST) {
      height = Math.max(minSize, bounds.height() + paddingTop + paddingBottom)
    }

    setMeasuredDimension(width, height)
  }
}
