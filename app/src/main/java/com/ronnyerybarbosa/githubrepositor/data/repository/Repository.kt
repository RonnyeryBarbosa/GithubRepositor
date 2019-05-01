package com.ronnyerybarbosa.githubrepositor.data.repository

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ronnyerybarbosa.githubrepositor.data.owner.Owner

/**
 * @author ronnyeybarbosa on 30,April,2019
 */
class Repository(

    val name: String = "",

    val description: String = "",

    val language: String = "",

    @SerializedName("created_at")
    val create: String = "",

    @SerializedName("updated_at")
    val update: String = "",

    val private: Boolean = false,

    @SerializedName("html_url")
    val url: String = "",

    @SerializedName("stargazers_count")
    val stars: Int = 0,

    val owner: Owner? = null
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        1 == source.readInt(),
        source.readString(),
        source.readInt(),
        source.readParcelable<Owner>(Owner::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(description)
        writeString(language)
        writeString(create)
        writeString(update)
        writeInt((if (private) 1 else 0))
        writeString(url)
        writeInt(stars)
        writeParcelable(owner, 0)
    }

    companion object {

        val PARSE = "parse"

        @JvmField
        val CREATOR: Parcelable.Creator<Repository> = object : Parcelable.Creator<Repository> {
            override fun createFromParcel(source: Parcel): Repository = Repository(source)
            override fun newArray(size: Int): Array<Repository?> = arrayOfNulls(size)
        }
    }
}