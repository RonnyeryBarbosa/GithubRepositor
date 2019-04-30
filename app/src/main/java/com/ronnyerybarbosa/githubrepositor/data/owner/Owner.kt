package com.ronnyerybarbosa.githubrepositor.data.owner

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


)
{

}