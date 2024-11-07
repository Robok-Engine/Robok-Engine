package org.robok.engine.feature.xmlviewer.lib.utils

class XmlMessage {
  companion object {
    const val TYPE_DEBUG = 0
    const val TYPE_ERROR = 1
    const val TYPE_WARN = 2
  }

  var type: Int = TYPE_DEBUG
  var message: String? = null
}
