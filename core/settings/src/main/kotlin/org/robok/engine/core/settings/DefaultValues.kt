package org.robok.engine.core.settings

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES

object DefaultValues {

  object App {
    val USE_MONET = VERSION.SDK_INT >= VERSION_CODES.S
    const val USE_AMOLED = false
    const val USE_BLUR = false
  }

  object Editor {
    const val THEME = 0
    const val TYPEFACE = 0
    const val USE_WORD_WRAP = false
    const val FONT = 0
  }
}
