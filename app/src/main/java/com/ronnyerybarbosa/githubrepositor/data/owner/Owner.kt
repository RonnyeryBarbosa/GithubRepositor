package com.ronnyerybarbosa.githubrepositor.data.owner

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author ronnyeybarbosa on 30,April,2019
 */
class Owner(

    @SerializedName("avatar_url")
    val avatar: String = "",

    val login: String = "",

    @SerializedName("followers_url")
    val followersUrl: String = ""


) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(avatar)
        writeString(login)
        writeString(followersUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Owner> = object : Parcelable.Creator<Owner> {
            override fun createFromParcel(source: Parcel): Owner = Owner(source)
            override fun newArray(size: Int): Array<Owner?> = arrayOfNulls(size)
        }
    }
}