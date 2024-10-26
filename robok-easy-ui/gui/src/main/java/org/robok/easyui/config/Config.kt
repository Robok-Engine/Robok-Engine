package org.robok.easyui.config

data class Config(
    val orientation: String, 
    val style: String
) {
    companion object {
        fun getName(): String = "config"
    }
}