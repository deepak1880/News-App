package com.example.newsapp.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.feature.home.domain.usecase.GetNewsUseCase

class HomeViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(getNewsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
