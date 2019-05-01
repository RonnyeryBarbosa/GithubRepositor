package com.ronnyerybarbosa.githubrepositor

import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.data.repository.DataRepository
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.network.ApiService
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositoriesPresenterImpl
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositoriesView
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


/**
 * Test the API Request
 *
 * @author [Ronnyery Barbosa](ronnyerybarbosa@gmail.com)
 *
 */
class RequesApiTest
{

    @Mock
    var apiService: ApiService=  RetrofitBuilder().createService(ApiService::class.java)

    @Mock
    lateinit var view: ListRepositoriesView

    @Before
    fun setup()
    {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline()}
    }

    @Test
    fun loadIntoViewSecesso()
    {
        val data = DataRepository(items = mutableListOf(Repository(),Repository()))


        `when`(apiService.request())
            .thenReturn(Observable.just(data))


        val mainPresenter = ListRepositoriesPresenterImpl(
            this.apiService,
            Schedulers.trampoline(),
            Schedulers.trampoline(),
            this.view
        )

        mainPresenter.loadData()

        val inOrder = Mockito.inOrder(view)
        inOrder.verify(view, times(1)).onDataStarted()
        inOrder.verify(view, times(1)).onDataCompleted()
        inOrder.verify(view, times(1)).onListRepositories(data.items)

    }

    @Test
    fun loadViewErro()
    {
        val exception: Exception = Exception()


        `when`(apiService.request())
            .thenReturn(Observable.error<DataRepository>(exception))

        val mainPresenter = ListRepositoriesPresenterImpl(
            this.apiService,
            Schedulers.trampoline(),
            Schedulers.trampoline(),
            this.view
        )

        mainPresenter.loadData()

        val inOrder = Mockito.inOrder(view)
        inOrder.verify(view, times(1)).onDataStarted()
        inOrder.verify(view, times(1)).onDataError(exception)
        verify(view, never()).onDataCompleted()

    }




}
