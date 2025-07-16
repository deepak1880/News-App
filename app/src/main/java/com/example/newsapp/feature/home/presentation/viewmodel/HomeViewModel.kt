package com.example.newsapp.feature.home.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Article
import com.example.newsapp.core.network.NetworkHelper
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    //Use Flows here
    var newList by mutableStateOf<List<Article>>(emptyList())
        private set

    //Use Flows here
    var isLoading by mutableStateOf(true)
        private set

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                isLoading = true
                val response = NetworkHelper.api.getNews()
                newList = response.articles
                Log.e("DATA", "fetchNews: ${newList}")
            } catch (e: Exception) {
                //Need handling here
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}