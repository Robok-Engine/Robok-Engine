package org.robok.easyui.config

import java.io.Serializable

data class Config(val orientation: String, val style: String) : Serializable {
  companion object {
    fun getName(): String = "config"
  }

  fun convertStyleToFileName(style: String): String {
    return style.replace(Regex("([A-Z])"), "_$1").lowercase()
  }
}
