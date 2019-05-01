package com.ronnyerybarbosa.githubrepositor.ui.activity.show

import com.ronnyerybarbosa.githubrepositor.data.repository.Repository

interface ShowRepositoryView
{
    fun setInfo(data:Repository)

    fun error()

}