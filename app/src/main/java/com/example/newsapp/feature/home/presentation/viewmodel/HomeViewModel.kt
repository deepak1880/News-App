package com.example.newsapp.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.core.utils.Resource
import com.example.newsapp.feature.home.domain.usecase.GetNewsUseCase
import com.example.newsapp.feature.home.presentation.NewsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            getNewsUseCase.invoke().collect { response ->
                when (response) {
                    is Resource.Loading ->
                        _uiState.value = NewsUiState(isLoading = true)

                    is Resource.Success ->
                        _uiState.value = NewsUiState(articles = response.data ?: emptyList(), isLoading = false)

                    is Resource.Error ->
                        _uiState.value = NewsUiState(errorMessage = response.message, isLoading = false)
                }

            }
        }
    }
}