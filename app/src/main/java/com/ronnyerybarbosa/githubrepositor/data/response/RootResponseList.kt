package com.ronnyerybarbosa.githubrepositor.data.response

import com.google.gson.annotations.SerializedName


/**
 * Created by RonnyeryDev on 12/03/2018.
 */
class RootResponseList<T>(

    @SerializedName("item")
    val data: T? = null,

    @SerializedName("incomplete_results")
    val incopleteResults: Boolean,

    @SerializedName("total_count")
    val totalCount: Int)



