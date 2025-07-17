package com.example.newsapp.feature.home.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Favourite : Screen("favourite_screen")
    data object Search : Screen("search_screen")

    //    data object DetailsScreenX(
//        val authorName:String
//    )
    data object DetailScreen :
        Screen("details_screen/{title}/{description}/{authorName}/{imageUrl}/{content}/{publishedAt}/{url}")
}