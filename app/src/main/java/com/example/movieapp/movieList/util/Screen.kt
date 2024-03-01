package com.example.movieapp.movieList.util

sealed class Screen(val route: String) {
    object Home : Screen("main")
    object PopularMoviesList : Screen("PopularMovie")
    object UpcomingMoviesList : Screen("upcomingMovie")
    object Details : Screen("details")
}