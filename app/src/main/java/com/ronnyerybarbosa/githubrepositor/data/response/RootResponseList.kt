package com.ronnyerybarbosa.githubrepositor.data.response

import com.google.gson.annotations.SerializedName


/**
 * Created by RonnyeryDev on 12/03/2018.
 */
class RootResponseList<T>(

    @SerializedName("items")
    val data: List<T>? = null,

    @SerializedName("incomplete_results")
    val incopleteResults: Boolean,

    @SerializedName("total_count")
    val totalCount: Int)



