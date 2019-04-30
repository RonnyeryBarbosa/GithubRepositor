package com.ronnyerybarbosa.githubrepositor.data.repository

import com.google.gson.annotations.SerializedName
import com.ronnyerybarbosa.githubrepositor.data.owner.Owner

/**
 * @author ronnyeybarbosa on 30,April,2019
 */
class Repository(

    val name: String                            = "",

    val description: String                     = "",

    val language: String                        = "",

    @SerializedName("created_at")
    val create: String                          = "",

    @SerializedName("updated_at")
    val update: String                          = "",

    val private: Boolean                        = false,

    @SerializedName("html_url")
    val url: String                             = "",

    @SerializedName("stargazers_count")
    val stars: Int                              = 0,

    val owner: Owner?                           = null
)
{
}