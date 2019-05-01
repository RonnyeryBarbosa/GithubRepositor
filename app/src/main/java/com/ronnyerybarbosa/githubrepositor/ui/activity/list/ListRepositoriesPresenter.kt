package com.ronnyerybarbosa.githubrepositor.ui.activity.list

interface ListRepositoriesPresenter
{

    fun loadData()

    fun unsubscribe()

    fun onDestroy()

}