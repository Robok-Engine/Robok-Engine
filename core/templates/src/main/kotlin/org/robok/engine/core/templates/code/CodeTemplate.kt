package org.robok.engine.core.templates.code

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

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

    open fun setCodeClassName(value: String) {
        className = value
    }

    open fun setCodeClassPackageName(value: String) {
        classPackageName = value
    }

    open fun getCodeClassContent() : String? {
        return classCodeContent
    }

    open fun getCodeClassName () : String? {
        return className
    }

    open fun getCodeClassPackageName () : String? {
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
