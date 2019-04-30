package com.ronnyerybarbosa.githubrepositor.ui.list

import android.annotation.SuppressLint
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.logging.Logger


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



        val a =  apiService
            .request()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->

                    System.out.println("sucesso");


                },
                { e ->


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