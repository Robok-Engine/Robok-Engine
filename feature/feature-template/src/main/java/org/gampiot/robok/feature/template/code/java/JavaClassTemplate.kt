package org.gampiot.robok.feature.template.code.kotlin

import android.os.Parcel

import org.gampiot.robok.feature.template.code.CodeTemplate

class KotlinClassTemplate : CodeTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "Kotlin class"
    }

    override fun configure() {
        setContent(
            """
            package $PACKAGE_NAME

            class $CLASS_NAME {

            }
            """.trimIndent()
        )
    }

    override fun getExtension(): String {
        return ".kt"
    }
}

