package com.ronnyerybarbosa.githubrepositor.ui.activity.profile

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ronnyerybarbosa.githubrepositor.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileView {


    lateinit var profilePresenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(toolbar2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = getString(R.string.profile)

        profilePresenter = getPresenter()

        Glide.with(this)
            .load(R.mipmap.user)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)

        btn_linkedin.setOnClickListener {

            profilePresenter.openUrl(false)

        }

        btn_git.setOnClickListener{

            profilePresenter.openUrl(true)
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item!!.itemId == android.R.id.home)
        {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    fun getPresenter(): ProfilePresenter
    {
        return ProfilePresenterImpl(this)
    }

    override fun openUrl(intent: Intent)
    {
        startActivity(intent)
    }
}
