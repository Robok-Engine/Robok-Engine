package org.robok.engine.feature.settings

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES.S

object DefaultValues {
    const val INSTALLED_RDK_VERSION = "RDK-1"
    const val IS_USE_MONET = if (VERSION.SDK_INT >= VERSION_CODES.S) true else false
    const val EDITOR_THEME = 0
    const val EDITOR_TYPEFACE = 0
    const val EDITOR_IS_USE_WORD_WRAP = false
}