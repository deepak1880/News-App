package com.example.newsapp.core.network

import com.example.newsapp.BuildConfig
import com.example.newsapp.feature.home.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("domains") domain: String = "wsj.com",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): NewsResponse
}