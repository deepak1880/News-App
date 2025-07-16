package com.example.newsapp.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.newsapp.*


object NetworkHelper {

   // val baseUrl = BuildConfig.BASE_URL

    //Configuration should be in either DI/core layer
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}


