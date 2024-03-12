package com.example.androidjetpackcomposepracticeprojects.splitify.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidjetpackcomposepracticeprojects.splitify.presentation.screens.SplitifyHistoyScreen
import com.example.androidjetpackcomposepracticeprojects.splitify.presentation.screens.SplitifyHomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.SplitifyHomeScreen.route) {
        composable(route = Screen.SplitifyHomeScreen.route) {
            SplitifyHomeScreen(navController = navController)
        }

        composable(route = Screen.SplitifyHistoryScreen.route) {
            SplitifyHistoyScreen(
                navController = navController,
                )
        }

    }
}

sealed class Screen(val route: String) {
    data object SplitifyHomeScreen : Screen(route = "splitifysHomeScreen")
    data object SplitifyHistoryScreen : Screen(route = "splitifyHistoryScreen")
}