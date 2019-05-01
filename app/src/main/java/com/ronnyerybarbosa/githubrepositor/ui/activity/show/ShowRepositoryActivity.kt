package com.ronnyerybarbosa.githubrepositor.ui.activity.show

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.ronnyerybarbosa.githubrepositor.R
import com.ronnyerybarbosa.githubrepositor.data.repository.Repository
import com.ronnyerybarbosa.githubrepositor.utils.startIntroAnimation
import kotlinx.android.synthetic.main.activity_view_repository.*
import kotlinx.android.synthetic.main.activity_view_repository.txt_rating
import kotlinx.android.synthetic.main.item_repositor.*
import java.text.SimpleDateFormat

class ShowRepositoryActivity : AppCompatActivity(), ShowRepositoryView {



    lateinit var showPresenter: ShowRepositoryPresenter


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_repository)



        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = getString(R.string.repository)



        showPresenter = getPresenter()

        showPresenter.verifyParse()



        btn_go.setOnClickListener {

            showPresenter.performShowUrl()

        }




    }

    private fun getDate(s: String): String? {
        try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val outputFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = inputFormat.parse("2018-04-10T04:00:00.000Z")
            return  outputFormat.format(date)

        } catch (e: Exception) {
            return e.toString()
        }
    }


    fun getPresenter(): ShowRepositoryPresenter
    {
        return ShowRepositoryImpl( this)
    }

    override fun setInfo(data: Repository)
    {
        txt_title.text = data.name

        txt_date_create.text = getDate(data.create)

        txt_date_update.text = getDate(data.update)

        txt_description.text = data.description

        txt_rating.text = data.stars.toString()

        txt_languagem.text = data.language

        txt_owner.text = data.owner?.login

        Glide.with(this)
            .load(data.owner?.avatar)
            .into(imageView)

        startIntroAnimation(imageView,true,300)
        startIntroAnimation(txt_title,false,400)
        startIntroAnimation(txt_description,true,400)
        startIntroAnimation(constraintLayout2,true,500)
        startIntroAnimation(txt_rating,true,300)
        startIntroAnimation(btn_go,false,500)


    }

    override fun error()
    {
        txt_msg_error.visibility = View.GONE
        txt_msg_error.text = getString(R.string.error)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home)
        {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
