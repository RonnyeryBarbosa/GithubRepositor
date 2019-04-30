package com.ronnyerybarbosa.githubrepositor

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositorPresenter
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositorPresenterImpl
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositorView
import com.ronnyerybarbosa.githubrepositor.ui.adapters.RepositorItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListRepositorView {


    override fun onDataStarted()
    {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDataCompleted()
    {
        progressBar.visibility = View.GONE

    }


    override fun onListRepositories(repositories: List<Repository>)
    {
        list_repo.layoutManager = LinearLayoutManager(this)
        list_repo.adapter = RepositorItemAdapter(repositories, this)

    }


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
