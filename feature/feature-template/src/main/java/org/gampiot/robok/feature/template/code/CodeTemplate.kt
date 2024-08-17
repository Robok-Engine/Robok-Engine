package org.gampiot.robok.feature.template.code

import android.os.Parcel
import android.os.Parcelable

open class CodeTemplate() : Parcelable {

    var PACKAGE_NAME: String? = null
    var CLASS_NAME: String? = null
    var codeContent: String? = null

    constructor(parcel: Parcel) : this() {
        codeContent = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codeContent)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun get(): String? {
        configure()
        return codeContent
    }

    fun setContent(contents: String) {
        codeContent = contents
    }

    fun configure() {}

    fun getName(): String {
        throw IllegalStateException("getName() is not subclassed")
    }

    fun getExtension(): String {
        throw IllegalStateException("getExtension() is not subclassed")
    }

    override fun toString(): String {
        return getName()
    }

    companion object CREATOR : Parcelable.Creator<CodeTemplate> {
        override fun createFromParcel(parcel: Parcel): CodeTemplate {
            return CodeTemplate(parcel)
        }

        override fun newArray(size: Int): Array<CodeTemplate?> {
            return arrayOfNulls(size)
        }
    }
}

