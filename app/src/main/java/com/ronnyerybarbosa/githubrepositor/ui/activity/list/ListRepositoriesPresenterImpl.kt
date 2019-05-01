package com.ronnyerybarbosa.githubrepositor.ui.activity.list

import android.annotation.SuppressLint
import com.google.gson.reflect.TypeToken
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.data.response.RootResponseList
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ListRepositoriesPresenterImpl(val apiService: ApiService,
                                    var view: ListRepositoriesView?) : ListRepositoriesPresenter
{

    val compositeDisposable = CompositeDisposable()


    @SuppressLint("CheckResult")
    override fun loadData()
    {
        compositeDisposable.clear()

        view?.onDataStarted()


        val a =  apiService
            .request()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->


                    view?.onDataCompleted()


                    System.out.println("sucesso");

                    System.out.println("${response.items.size}");

                    view?.onListRepositories(response.items)


                },
                { e ->

                    view?.onDataError(e)

                    System.out.println("error");


                }

            )



        compositeDisposable.add(a)
    }

    override fun unsubscribe()
    {
        compositeDisposable.clear()
    }

    override fun onDestroy()
    {
        this.view = null
    }





}