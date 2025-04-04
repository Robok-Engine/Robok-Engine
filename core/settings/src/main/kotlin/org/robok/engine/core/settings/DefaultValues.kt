package org.robok.engine.core.settings

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES

object DefaultValues {
  val IS_USE_MONET = VERSION.SDK_INT >= VERSION_CODES.S
  const val IS_USE_AMOLED = false
  const val APP_THEME_SEED_COLOR = 0xFF4C662B
  const val APP_THEME_PALETTE_STYLE_INDEX = 0
  const val EDITOR_THEME = 0
  const val EDITOR_TYPEFACE = 0
  const val EDITOR_IS_USE_WORD_WRAP = false
  const val EDITOR_FONT = 0
}
