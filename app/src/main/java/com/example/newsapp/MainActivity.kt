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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.core.network.NetworkHelper
import com.example.newsapp.feature.favorite.FavoriteScreen
import com.example.newsapp.feature.home.data.NewsRepositoryImpl
import com.example.newsapp.feature.home.domain.usecase.GetNewsUseCase
import com.example.newsapp.feature.home.presentation.ui.HomeScreen
import com.example.newsapp.feature.home.presentation.navigation.NavigationBarScreen
import com.example.newsapp.feature.home.presentation.navigation.Screen
import com.example.newsapp.feature.home.presentation.navigation.TopBar
import com.example.newsapp.feature.home.presentation.viewmodel.HomeViewModel
import com.example.newsapp.feature.home.presentation.viewmodel.HomeViewModelFactory
import com.example.newsapp.feature.newsdetail.presentation.ui.DetailsScreen
import com.example.newsapp.feature.search.SearchScreen

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
                SearchScreen()
            }
            composable(Screen.Favourite.route) {
                FavoriteScreen()
            }
            composable(
                Screen.DetailScreen.route,
                arguments = listOf(
                    navArgument("title") { type = NavType.StringType },
                    navArgument("description") { type = NavType.StringType },
                    navArgument("authorName") { type = NavType.StringType },
                    navArgument("imageUrl") { type = NavType.StringType },
                    navArgument("content") { type = NavType.StringType },
                    navArgument("publishedAt") { type = NavType.StringType },
                    navArgument("url") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title")
                val description = backStackEntry.arguments?.getString("description")
                val authorName = backStackEntry.arguments?.getString("authorName")
                val imageUrl = backStackEntry.arguments?.getString("imageUrl")
                val publishedAt = backStackEntry.arguments?.getString("publishedAt")
                val content = backStackEntry.arguments?.getString("content")
                val url = backStackEntry.arguments?.getString("url")

                DetailsScreen(
                    title = title.toString(),
                    description = description.toString(),
                    imageUrl = imageUrl.toString(),
                    authorName = authorName.toString(),
                    content = content.toString(),
                    publishedAt = publishedAt.toString(),
                    url = url.toString()
                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}