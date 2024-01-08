package com.example.androidjetpackcomposepracticeprojects.models

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidjetpackcomposepracticeprojects.HomeScreen
import com.example.androidjetpackcomposepracticeprojects.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route= Screen.Home.route){ HomeScreen (onNavigateToProfile = {
            navController.navigate(
                Screen.Profile.route
            )
        })}
        composable(route = Screen.Profile.route){
            ProfileScreen (onNavigateToHome = {navController.popBackStack()})
//            ProfileScreen {
//                navController.navigate(Screen.Home.route)
//            }
        }

    }
}