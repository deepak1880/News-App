package com.example.newsapp.feature.home.domain.model

data class Article(
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val author: String,
    val url: String,
    val publishedAt: String,
    val content: String
)