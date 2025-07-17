package com.example.newsapp.feature.home.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(val title: String, val icon: ImageVector, val route: String)

val navigationBarItem = listOf(
    NavigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = Screen.Home.route
    ),
    NavigationItem(
        title = "Favourite",
        icon = Icons.Default.Favorite,
        route = Screen.Favourite.route
    ),
    NavigationItem(
        title = "Search",
        icon = Icons.Default.Search,
        route = Screen.Search.route
    )
)
