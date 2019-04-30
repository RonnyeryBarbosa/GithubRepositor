package com.ronnyerybarbosa.githubrepositor

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.service.rxjava.RxBus
import com.ronnyerybarbosa.githubrepositor.service.rxjava.RxEvent
import com.ronnyerybarbosa.githubrepositor.ui.list.ListRepositorPresenter
import com.ronnyerybarbosa.githubrepositor.ui.list.ListRepositorPresenterImpl
import com.ronnyerybarbosa.githubrepositor.ui.list.ListRepositorView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), ListRepositorView {

    lateinit var listRepositorPresenterImpl: ListRepositorPresenter

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listRepositorPresenterImpl = getPresenter()

        listRepositorPresenterImpl.loadData()


//        val service = RetrofitBuilder().createService(ApiService::class.java)
//
//
//
//
//        val response = service.request()
//
//
//        response.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//
//                        response ->
//
//
//
//
//                    Log.d("result", response.response)
//
//
//
//                },
//                { e ->
//                    Log.e("error", "erro ao conectar com a internet. info: ${e.message!!}")
//
//
//                }
//
//            )


    }

    fun getPresenter(): ListRepositorPresenter
    {
        return ListRepositorPresenterImpl( RetrofitBuilder().createService(ApiService::class.java),null,null,this)
    }

}
