package com.ronnyerybarbosa.githubrepositor.utils

import com.google.gson.Gson
import com.ronnyerybarbosa.githubrepositor.data.response.RootResponseList
import java.lang.reflect.Type

/**
 * @author ronnyeybarbosa on 30,April,2019
 */


fun <T> convertJsonInObject(stringJson: String, type: Type?): RootResponseList<T>
{

    val data: RootResponseList<T> = Gson().fromJson(stringJson, type)

    return data
}
