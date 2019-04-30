package com.ronnyerybarbosa.githubrepositor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.liketapp.network.RetrofitBuilder
import com.ronnyerybarbosa.githubrepositor.network.ApiService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service: ApiService = RetrofitBuilder().getRetrofit()




    }
}
