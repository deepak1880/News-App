package com.example.newsapp.feature.home.domain.repository

import com.example.newsapp.feature.home.domain.model.Article

interface NewsRepository {
    suspend fun getNews(): List<Article>
}