package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreNavGraph
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel

@Composable
fun StoreHomeScreen(
){
    val navController = rememberNavController()
    val productVM: StoreProductDetailsViewModel = hiltViewModel()
    val state by productVM.state.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = state.route == "home",
                    onClick = {
                        productVM.changeNavigationState("home")
                        navController.navigate(StoreScreen.StoreHomeScreenContent.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.home),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .padding(4.dp)
                        )
                    })
                NavigationBarItem(
                    selected = state.route == "cart",

                    onClick = {
                        productVM.changeNavigationState("cart")
                        navController.navigate(StoreScreen.StoreProductCart.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.cart),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(4.dp)
                        )
                    })

                NavigationBarItem(
                    selected = state.route == "profile",
                    onClick = {
                        productVM.changeNavigationState("profile")
                        navController.navigate(StoreScreen.StoreProfileScreen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .padding(4.dp)
                        )
                    })

            }

        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            StoreNavGraph(
                navController = navController,
                viewModel = productVM
            )
        }
    }
}