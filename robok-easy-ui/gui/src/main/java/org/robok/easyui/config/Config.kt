package org.robok.easyui.config

import java.io.Serializable;

data class Config(val orientation: String, val style: String): Serializable {
    companion object {
        fun getName(): String = "config"
    }
}
