package com.ronnyerybarbosa.githubrepositor.ui.activity.list

import com.ronnyerybarbosa.githubrepositor.data.repository.Repository

interface ListRepositorView
{
    fun onDataStarted()

    fun onDataCompleted()

    fun onListRepositories(repositories: List<Repository>)
//
//    fun onDataError(e: Throwable)
}