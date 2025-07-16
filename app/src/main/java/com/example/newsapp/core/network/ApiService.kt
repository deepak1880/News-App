package com.example.newsapp.core.network

import com.example.newsapp.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("domains") domain: String = "wsj.com",
        @Query("apiKey") apiKey: String = "b2b4977236414666b636050a1e48dacf"
    ): NewsResponse
}