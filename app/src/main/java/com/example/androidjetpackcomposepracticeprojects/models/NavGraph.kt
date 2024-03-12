package com.example.androidjetpackcomposepracticeprojects.models

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.QuotesProfileScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.QuotesScreen
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.QuotesHomeScreen.route) {
//        composable(route= Screen.Home.route){
//            HomeScreen (onNavigateToProfile = {
//            navController.navigate(
//                Screen.Profile.route
//            )
//        })}
//        composable(route = Screen.Profile.route){
//            ProfileScreen (onNavigateToHome = {navController.popBackStack()})
////            ProfileScreen {
////                navController.navigate(Screen.Home.route)
////            }
//        }
        composable(route = Screen.QuotesHomeScreen.route) {
            QuotesScreen(navController = navController)
        }
        composable(
            route = Screen.QuotesProfileScreen.route) {
            QuotesProfileScreen(navController = navController ,

            )
        }

    }
}