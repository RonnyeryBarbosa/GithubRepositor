package com.ronnyerybarbosa.githubrepositor.data.repository

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author ronnyeybarbosa on 30,April,2019
 */
class DataRepository(
    val items: MutableList<Repository> = mutableListOf<Repository>(),

    @SerializedName("incomplete_results")
    val incopleteResults: Boolean = false,

    @SerializedName("total_count")
    val totalCount: Int = 0
) : Parcelable {
    constructor(source: Parcel) : this(
        source.createTypedArrayList(Repository.CREATOR),
        1 == source.readInt(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(items)
        writeInt((if (incopleteResults) 1 else 0))
        writeInt(totalCount)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<DataRepository> = object : Parcelable.Creator<DataRepository> {
            override fun createFromParcel(source: Parcel): DataRepository = DataRepository(source)
            override fun newArray(size: Int): Array<DataRepository?> = arrayOfNulls(size)
        }
    }
}
