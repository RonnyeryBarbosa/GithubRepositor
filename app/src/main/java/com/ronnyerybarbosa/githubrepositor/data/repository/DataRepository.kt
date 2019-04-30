package com.ronnyerybarbosa.githubrepositor.data.repository

import com.google.gson.annotations.SerializedName

/**
 * @author ronnyeybarbosa on 30,April,2019
 */
class DataRepository(
    val items: List<Repository> = listOf(),

    @SerializedName("incomplete_results")
    val incopleteResults: Boolean = false,

    @SerializedName("total_count")
    val totalCount: Int = 0)
{}
