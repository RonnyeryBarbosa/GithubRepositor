package com.ronnyerybarbosa.githubrepositor.ui.list

interface ListRepositorPresenter
{

    fun loadData()

    fun subscribe()

    fun unsubscribe()

    fun onDestroy()
}