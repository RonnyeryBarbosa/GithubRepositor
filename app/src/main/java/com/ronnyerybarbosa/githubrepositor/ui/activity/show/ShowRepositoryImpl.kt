package com.ronnyerybarbosa.githubrepositor.ui.activity.show

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository

class ShowRepositoryImpl(val showView:ShowRepositoryView): ShowRepositoryPresenter
{


    val data = (showView as AppCompatActivity).intent.getParcelableExtra<Repository>(Repository.PARSE)

    override fun verifyParse()
    {
        if(data == null)
        {
            showView.error()
        }
        else
        {
            showView.setInfo(data)
        }
    }

    override fun performShowUrl()
    {
        val openURL = Intent(Intent.ACTION_VIEW)

        openURL.data = Uri.parse(data.url)

        (showView as AppCompatActivity).startActivity(openURL)
    }
}