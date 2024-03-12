package com.example.androidjetpackcomposepracticeprojects.models

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object Profile : Screen(route = "profile")
    data object QuotesHomeScreen : Screen(route = "quotesHomeScreen")
    data object QuotesProfileScreen : Screen(route = "quotesProfileScreen")
}