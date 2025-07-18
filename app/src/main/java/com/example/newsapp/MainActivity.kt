package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.core.network.NetworkHelper
import com.example.newsapp.feature.home.data.NewsRepositoryImpl
import com.example.newsapp.feature.home.domain.usecase.GetNewsUseCase
import com.example.newsapp.feature.home.presentation.ui.HomeScreen
import com.example.newsapp.feature.home.presentation.navigation.NavigationBarScreen
import com.example.newsapp.feature.home.presentation.navigation.Screen
import com.example.newsapp.feature.home.presentation.navigation.TopBar
import com.example.newsapp.feature.home.presentation.viewmodel.HomeViewModel
import com.example.newsapp.feature.home.presentation.viewmodel.HomeViewModelFactory
import com.example.newsapp.feature.newsdetail.presentation.components.ArticleViewerScreen
import com.example.newsapp.feature.newsdetail.presentation.ui.DetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}

@Composable
fun MainScreen() {
    val repository = NewsRepositoryImpl(NetworkHelper.api)
    val useCase = GetNewsUseCase(repository)
    val viewModelFactory = HomeViewModelFactory(useCase)
    val navController = rememberNavController()
    val viewModel: HomeViewModel = viewModel(factory = viewModelFactory)


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        },
        bottomBar = {
            NavigationBarScreen(navController)
        }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController, viewModel)
            }
            composable(Screen.Search.route) {
                // SearchScreen()
            }
            composable(Screen.Favourite.route) {
                //  FavoriteScreen()
            }
            composable(Screen.DetailScreen.route) {
                DetailsScreen(navController)
            }
            composable(Screen.ArticleViewer.route) {
                ArticleViewerScreen(navController)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}