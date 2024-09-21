package org.gampiot.robok.ui.fragments.project.create.util

import android.os.Parcel
import android.os.Parcelable

data class ProjectManagerWrapper(
    val projectPath: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(projectPath)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ProjectManagerWrapper> {
        override fun createFromParcel(parcel: Parcel): ProjectManagerWrapper {
            return ProjectManagerWrapper(parcel)
        }

        override fun newArray(size: Int): Array<ProjectManagerWrapper?> {
            return arrayOfNulls(size)
        }
    }
}