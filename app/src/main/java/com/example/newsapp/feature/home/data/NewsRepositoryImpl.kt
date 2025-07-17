package com.example.newsapp.feature.home.data

import com.example.newsapp.core.network.ApiService
import com.example.newsapp.feature.home.domain.model.Article
import com.example.newsapp.feature.home.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val apiService: ApiService
) : NewsRepository {

    override suspend fun getNews(): List<Article> {
        return apiService.getNews().articles
    }
}