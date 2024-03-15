package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components.ProfileDetailsRowComp
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.LoadingDialog
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductDetailsScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun StoreProductDetails(
    viewModel: StoreProductDetailsViewModel = hiltViewModel(),
    navController: NavHostController, index: String
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getProductDetails(productId = index)
    }
    ProductDetailsContent(
        state = state, navController = navController
    )

}

@Composable
fun ProductDetailsContent(
    state: ProductDetailsScreenState,
    navController: NavHostController,
) {
    if (!state.isLoading) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                StoreTopAppBar(
                    title = {
                        Text(
                            "Profile",
                            fontFamily = ubuntu,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    appBarLeadingIcon = painterResource(R.drawable.back),
                    onClick = {
                        navController.navigateUp()
                    },
                    action = {

                    }
                )
            },
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                ProfileDetailsRowComp(
                    onClick = {},
                    rowTitle = "Settings  ${state.productDetails?.price}",
                    leadingIcon = R.drawable.setting
                )
                ProfileDetailsRowComp(
                    onClick = {},
                    rowTitle = "Billing Details",
                    leadingIcon = R.drawable.wallet

                )
                ProfileDetailsRowComp(
                    onClick = {},
                    rowTitle = "User Management",
                    leadingIcon = R.drawable.terms

                )
                ProfileDetailsRowComp(
                    onClick = {},
                    rowTitle = "Information",
                    leadingIcon = R.drawable.information

                )
                ProfileDetailsRowComp(
                    onClick = {},
                    rowTitle = "Logout",
                    rowTitleColor = Color.Red,
                    trailingIconState = false,
                    leadingIcon = R.drawable.logoutt

                )


            }

        }
    } else {
        LoadingDialog(isLoading = true)
    }
}