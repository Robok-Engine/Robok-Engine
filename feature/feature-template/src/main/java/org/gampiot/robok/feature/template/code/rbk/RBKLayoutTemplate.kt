package org.gampiot.robok.feature.template.code.rbk

import android.os.Parcel
import org.gampiot.robok.feature.template.code.CodeTemplate

class RBKLayoutTemplate : CodeTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "RBK Layout File"
    }

    override fun configure() {
        content = """
            $CLASS_NAME {
                Button(
                    id = "shoot_button",
                    text = "Shoot",
                    width = px(20),
                    height = px(20)
                )
            }
        """.trimIndent()
    }

    override fun getExtension(): String {
        return ".rbk"
    }
}

