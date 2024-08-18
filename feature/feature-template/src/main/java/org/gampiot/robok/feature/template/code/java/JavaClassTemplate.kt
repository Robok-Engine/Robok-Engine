package org.gampiot.robok.feature.template.code.java

import android.os.Parcel

import org.gampiot.robok.feature.template.code.CodeTemplate

open class JavaClassTemplate : CodeTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "Kotlin class"
    }

    override fun configure() {
        setContent(
            """
            package ${getClassPackageName()}

            class ${getClassName()} {

            }
            """.trimIndent()
        )
    }

    override fun getExtension(): String {
        return ".kt"
    }
}

