package com.ronnyerybarbosa.githubrepositor.network

import com.ronnyerybarbosa.githubrepositor.data.repository.DataRepository
import com.ronnyerybarbosa.githubrepositor.data.response.ResponseRequest
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by RonnyeryDev on 28/04/2019.
 * Control request API server@
 * @author Ronnyery Barbosa<ronnyerybarbosa@gmail.com>
 */
interface ApiService
{

    @GET("repositories?q=language:swift&sort=stars")
    fun request() : Observable<DataRepository>


}
