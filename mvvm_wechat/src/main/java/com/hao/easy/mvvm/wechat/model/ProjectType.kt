package com.hao.easy.mvvm.wechat.model

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Yang Shihao
 * @date 2018/12/2
 */
data class ProjectType(var id: Int,
                       var name: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProjectType> {
        override fun createFromParcel(parcel: Parcel): ProjectType {
            return ProjectType(parcel)
        }

        override fun newArray(size: Int): Array<ProjectType?> {
            return arrayOfNulls(size)
        }
    }
}