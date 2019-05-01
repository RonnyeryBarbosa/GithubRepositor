package com.ronnyerybarbosa.githubrepositor.ui.activity.list

import com.ronnyerybarbosa.githubrepositor.data.repository.Repository

interface ListRepositoriesView
{
    fun onDataStarted()

    fun onDataCompleted()

    fun onListRepositories(repositories: MutableList<Repository>)

    fun onDataError(e: Throwable)
}