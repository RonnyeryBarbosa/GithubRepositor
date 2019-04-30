package com.ronnyerybarbosa.githubrepositor

import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.data.response.ResponseRequest
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.ui.list.ListRepositorPresenterImpl
import com.ronnyerybarbosa.githubrepositor.ui.list.ListRepositorView
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when`







/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RequesApiTest {

    @Mock
    var apiService: ApiService=  RetrofitBuilder().createService(ApiService::class.java)

    @Mock
    lateinit var view: ListRepositorView

    @Before
    fun setup()
    {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline()}

    }

    @Test
    fun fetchValidDataShouldLoadIntoView()
    {
        val d: ResponseRequest = ResponseRequest("")

//a
        `when`(apiService.request())
            .thenReturn(Observable.just(d))

        System.out.println(d.response);


        val mainPresenter = ListRepositorPresenterImpl(
            this.apiService,
            Schedulers.trampoline(),
            Schedulers.trampoline(),
            this.view
        )

        mainPresenter.loadData()

    }




}
