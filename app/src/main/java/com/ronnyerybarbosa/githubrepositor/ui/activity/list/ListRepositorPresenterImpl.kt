package com.ronnyerybarbosa.githubrepositor.ui.activity.list

import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.reflect.TypeToken
import com.ronnyerybarbosa.githubrepositor.data.repository.DataRepository
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.data.response.RootResponseList
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.utils.convertJsonInObject
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ListRepositorPresenterImpl(val apiService: ApiService,
                                 val backgroundScheduler: Scheduler?,
                                 val mainScheduler: Scheduler?,
                                 var view: ListRepositorView) : ListRepositorPresenter
{

    var v = view
    @SuppressLint("CheckResult")
    override fun loadData()
    {
        compositeDisposable.clear()

        view.onDataStarted()




        val a =  apiService
            .request()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->


                    view.onDataCompleted()

                  //  Log.d("repositories", response.totalCount.toString())


                    System.out.println("sucesso");

                    System.out.println("${response.items.size}");



                    val type = object : TypeToken<RootResponseList<Repository>>() {}.type

//                    val data = response.response?.let { convertJsonInObject<Repository>(it, type) }
//
//                    Log.d("repositories", "${data!!.incopleteResults}")
//
//                    Log.d("repositories", "${data?.data?.size}")
                    view.onListRepositories(response.items)


                },
                { e ->

                    view.onDataCompleted()

                    System.out.println("error");


                }

            )



        compositeDisposable.add(a)
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe()
    {
        compositeDisposable.clear()
    }

    override fun onDestroy()
    {
        //this.v = null
    }

    val compositeDisposable = CompositeDisposable()




}