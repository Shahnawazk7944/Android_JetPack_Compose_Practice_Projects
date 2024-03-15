package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.presentation.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.ProductCard
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.LoadingDialog
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
internal fun StoreProductScreen(
    viewModel: ProductsViewModel = hiltViewModel(), navController: NavHostController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductContent(state = state, navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductContent(
    state: ProductScreenState, navController: NavHostController
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StoreTopAppBar(
                title = {
                    Text(
                        "Products",
                        fontFamily = ubuntu,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                appBarLeadingIcon = painterResource(R.drawable.menu),
                onClick = {
                    navController.navigateUp()
                },
                action = {

                }
            )
        }
    ) { padding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(padding),
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 5.dp
        ) {

            items(state.product.size) { index ->
                val product = state.product[index]
                Box(Modifier.clickable {
                    navController.navigate(StoreScreen.StoreProductDetails.passToProductDetailsScree(index+1)) // Navigate with index
                }) {
                    ProductCard(product = product)
                }

            }
        }
    }
}