package com.example.newsapp

data class NewsResponse(
    val articles: List<Article>
)

data class Article(
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val author: String,
    val url: String,
    val publishedAt: String,
    val content: String
)
