package org.robok.engine.feature.settings

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES

object DefaultValues {
    const val INSTALLED_RDK_VERSION = "RDK-1"
    val IS_USE_MONET = VERSION.SDK_INT >= VERSION_CODES.S
    const val EDITOR_THEME = 0
    const val EDITOR_TYPEFACE = 0
    const val EDITOR_IS_USE_WORD_WRAP = false
}
