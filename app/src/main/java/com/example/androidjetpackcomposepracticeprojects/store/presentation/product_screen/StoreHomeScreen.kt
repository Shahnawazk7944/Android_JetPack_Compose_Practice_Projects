package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreNavGraph
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins

@Composable
fun StoreHomeScreen(
){
    val navController = rememberNavController()
    val productVM: StoreProductDetailsViewModel = hiltViewModel()
    val state by productVM.state.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = FSecondaryBackgroundWhite
            ) {
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
                                .size(30.dp).padding(2.dp)
                                .offset(y = (-4).dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Home",
                            fontFamily = poppins,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,

                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = FPrimaryGreen,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = FPrimaryGreen,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = FSecondaryBackgroundWhite
                    ),
                )

                NavigationBarItem(
                    selected = state.route == "favourite",
                    onClick = {
                        productVM.changeNavigationState("favourite")
                        navController.navigate(StoreScreen.StoreProfileScreen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp).padding(2.dp)
                                .offset(y = (-4).dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Favourite",
                            fontFamily = poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                            )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = FPrimaryGreen,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = FPrimaryGreen,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = FSecondaryBackgroundWhite
                    ),
                    )

                NavigationBarItem(
                    selected = state.route == "try",
                    onClick = {
                        productVM.changeNavigationState("try")
                        navController.navigate(StoreScreen.StoreProfileScreen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.trynow),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp).padding(2.dp)
                                .offset(y = (-4).dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Try Now",
                            fontFamily = poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,

                            )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = FPrimaryGreen,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = FPrimaryGreen,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = FSecondaryBackgroundWhite
                    ),
                    )

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
                                .size(30.dp).padding(2.dp)
                                .offset(y = (-4).dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Shopping",
                            fontFamily = poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,

                            )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = FPrimaryGreen,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = FPrimaryGreen,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = FSecondaryBackgroundWhite
                    ),
                    )

                NavigationBarItem(
                    selected = state.route == "profile",
                    onClick = {
                        productVM.changeNavigationState("profile")
                        navController.navigate(StoreScreen.StoreProfileScreen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.user2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp).padding(2.dp)
                                .offset(y = (-4).dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Profile",
                            fontFamily = poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,

                            )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = FPrimaryGreen,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = FPrimaryGreen,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = FSecondaryBackgroundWhite
                    ),
                    )

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