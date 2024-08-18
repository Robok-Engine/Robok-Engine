package org.gampiot.robok.feature.template.code

import android.os.Parcel
import android.os.Parcelable

open class CodeTemplate() : Parcelable {

    open public var classPackageName: String? = null
    open public var className: String? = null
    open public var classCodeContent: String? = null

    constructor(parcel: Parcel) : this() {
        classCodeContent = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(classCodeContent)
    }

    override fun describeContents(): Int {
        return 0
    }

    open fun get(): String? {
        configure()
        return classCodeContent
    }

    open fun setContent(value: String) {
        classCodeContent = value
    }
    
    open fun setClassName(value: String) {
        className = value
    }
    
    open fun setClassPackageName(value: String) {
        classPackageName = value
    }
    
    open fun getClassContent() : String? {
        return classCodeContent
    }
    
    open fun getClassName () : String? {
        return className
    }
    
    open fun getClassPackageName () : String? {
        return classPackageName
    }
    
    open fun configure() {}

    open fun getName(): String {
        throw IllegalStateException("getName() is not subclassed")
    }

    open fun getExtension(): String {
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

