package com.example.newsapp.feature.home.domain.usecase

import com.example.newsapp.core.utils.Resource
import com.example.newsapp.feature.home.domain.model.Article
import com.example.newsapp.feature.home.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            val data = repository.getNews()
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}