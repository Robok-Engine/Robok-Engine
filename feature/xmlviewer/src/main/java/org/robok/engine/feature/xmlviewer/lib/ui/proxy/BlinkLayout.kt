package org.robok.engine.feature.xmlviewer.lib.ui.proxy

/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.widget.FrameLayout

class BlinkLayout @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

  private val mHandler: Handler
  private var mBlink = false
  private var mBlinkState = false

  init {
    mHandler = Handler(Looper.getMainLooper(), Handler.Callback { msg ->
      if (msg.what == MESSAGE_BLINK) {
        if (mBlink) {
          mBlinkState = !mBlinkState
          makeBlink()
        }
        invalidate()
        true
      } else {
        false
      }
    })
  }

  private fun makeBlink() {
    val message = mHandler.obtainMessage(MESSAGE_BLINK)
    mHandler.sendMessageDelayed(message, BLINK_DELAY.toLong())
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    mBlink = true
    mBlinkState = true
    makeBlink()
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    mBlink = false
    mBlinkState = true
    mHandler.removeMessages(MESSAGE_BLINK)
  }

  override fun dispatchDraw(canvas: Canvas) {
    if (mBlinkState) {
      super.dispatchDraw(canvas)
    }
  }

  companion object {
    private const val MESSAGE_BLINK = 0x42
    private const val BLINK_DELAY = 500
  }
}