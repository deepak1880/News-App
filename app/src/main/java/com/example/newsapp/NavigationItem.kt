package com.example.newsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class navigationItem(val title: String, val icon: ImageVector, val route: String)

val navigationBarItem = listOf(
    navigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = Screen.Home.route
    ),
    navigationItem(
        title = "Favourite",
        icon = Icons.Default.Favorite,
        route = Screen.Favourite.route
    ),
    navigationItem(
        title = "Search",
        icon = Icons.Default.Search,
        route = Screen.Search.route
    )
)

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Favourite : Screen("favourite_screen")
    data object Search : Screen("search_screen")
    data object DetailScreen : Screen("details_screen/{title}/{description}/{authorName}/{imageUrl}/{content}/{publishedAt}/{url}")
}