package com.example.newsapp.feature.home.presentation

import com.example.newsapp.feature.home.domain.model.Article

data class NewsUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)