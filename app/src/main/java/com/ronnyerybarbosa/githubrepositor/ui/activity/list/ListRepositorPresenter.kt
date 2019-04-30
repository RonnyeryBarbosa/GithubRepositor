package com.ronnyerybarbosa.githubrepositor.ui.activity.list

interface ListRepositorPresenter
{

    fun loadData()

    fun subscribe()

    fun unsubscribe()

    fun onDestroy()
}