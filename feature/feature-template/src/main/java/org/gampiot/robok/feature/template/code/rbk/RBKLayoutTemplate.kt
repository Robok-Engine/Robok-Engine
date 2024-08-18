package org.gampiot.robok.feature.template.code.rbk

import android.os.Parcel
import org.gampiot.robok.feature.template.code.CodeTemplate

open class RBKLayoutTemplate : CodeTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "RBK Layout File"
    }

    override fun configure() {
        setContent("""
            ${getClassName()} {
                Button(
                    id = "shoot_button",
                    text = "Shoot",
                    width = px(20),
                    height = px(20)
                )
            }
        """.trimIndent()
        )
    }

    override fun getExtension(): String {
        return ".rbk"
    }
}

