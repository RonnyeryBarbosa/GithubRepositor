package com.ronnyerybarbosa.githubrepositor.ui.activity.profile

import android.content.Intent
import android.net.Uri

class ProfilePresenterImpl(val profileView: ProfileView): ProfilePresenter
{
    override fun openUrl(isGit: Boolean)
    {
        val openURL = Intent(Intent.ACTION_VIEW)

        if (isGit)
        {
            openURL.data = Uri.parse("https://github.com/RonnyeryBarbosa/GithubRepositor")
        }
        else
        {
            openURL.data = Uri.parse("https://www.linkedin.com/in/ronnyery-barbosa-201964b1/")
        }

        profileView.openUrl(openURL)


    }
}