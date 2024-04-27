package com.example.androidjetpackcomposepracticeprojects.store.NavGraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.ProductCart
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreHomeScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProductDetails
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProductScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProfileScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreSignIn
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreSignUp
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel

@Composable
fun AuthNavGraph(
    authNavController: NavHostController,
) {
    NavHost(navController = authNavController, startDestination = AuthScreen.StoreSignUp.route) {

        composable(route = AuthScreen.StoreSignUp.route) {
            StoreSignUp(authNavController = authNavController, )
        }
        composable(route = AuthScreen.StoreSignIn.route) {
            StoreSignIn(authNavController = authNavController, )
        }


        composable(route = AuthScreen.StoreHomeScreen.route) {
           StoreHomeScreen()
        }

    }
}

sealed class AuthScreen(val route: String) {
    data object StoreSignUp : AuthScreen(route = "storeSignUp")
    data object StoreSignIn : AuthScreen(route = "storeSignIn")
    data object StoreHomeScreen : AuthScreen(route = "storeHomeScreen")
}