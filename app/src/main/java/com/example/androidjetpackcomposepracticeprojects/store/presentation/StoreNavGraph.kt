package com.example.androidjetpackcomposepracticeprojects.store.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.ProductCart
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProductDetails
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProductScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.StoreProfileScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel

@Composable
fun StoreNavGraph(
    viewModel: StoreProductDetailsViewModel,
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = StoreScreen.StoreHomeScreen.route) {

        composable(route = StoreScreen.StoreHomeScreen.route) {
            StoreProductScreen(navController = navController, productViewModel = viewModel)
        }

        composable(
            route = StoreScreen.StoreProductDetails.route,
            arguments = listOf(
                navArgument("productIndex") { type = NavType.StringType },
                )
        ) { navBackStackEntry ->
            val productIndex = navBackStackEntry.arguments?.getString("productIndex")
            if (productIndex != null) {
                StoreProductDetails(navController = navController, index = productIndex, viewModel = viewModel)
            }
        }

        composable(route = StoreScreen.StoreProfileScreen.route) {
            StoreProfileScreen(navController = navController,)
        }

        composable(route = StoreScreen.StoreProductCart.route) {
            ProductCart(navController = navController, viewModel = viewModel)
        }
    }
}

sealed class StoreScreen(val route: String) {
    data object StoreHomeScreen : StoreScreen(route = "storeHomeScreen")
    data object StoreProfileScreen : StoreScreen(route = "storeProfileScreen")
    data object StoreProductCart : StoreScreen(route = "storeProductCart")
    data object StoreProductDetails : StoreScreen(
        route = "storeProductDetails/{productIndex}"
    ) {
        fun passToProductDetailsScree(
            productIndex: Int,
        ): String {
            return "storeProductDetails/$productIndex"
        }
    }
}