package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.RatingBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.LoadingDialog
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductDetailsScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
fun StoreProductDetails(
    viewModel: StoreProductDetailsViewModel = hiltViewModel(),
    navController: NavHostController, index: String
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getProductDetails(productId = index)
    }

    Log.d("check in product details", index)



    ProductDetailsContent(
        state = state, navController = navController
    )

}

@Composable
fun ProductDetailsContent(
    state: ProductDetailsScreenState,
    navController: NavHostController,
) {
    Log.d("enter in product details", "nothing")

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
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    //.height(500.dp)
                    .padding(paddingValues)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(150.dp)

                        .background(Color.White)
                ) {
                    AsyncImage(
                        model = state.productDetails.image,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Fit
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(150.dp)
                        .background(Color(0x407D7986))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = state.productDetails.category,
                            fontFamily = rubik,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = state.productDetails.title,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = ChocolateBrown

                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "${state.productDetails.price}",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = gradient_32
                        )
                        Row(modifier = Modifier.fillMaxWidth()) {
                            RatingBar(
                                modifier = Modifier.size(15.dp),
                                rating = state.productDetails.rating.rate
                            )
                            Spacer(modifier = Modifier.width(10.dp))

//                            Text(
//                                text = "${state.productDetails?.rating!!.count} Reviews",
//                                fontFamily = ubuntu,
//                                fontWeight = FontWeight.Medium,
//                                fontSize = 14.sp,
//                                color = Color(0xFF0A533F)
//                            )

                        }
                    }
                }
            }

        }
    } else {
        LoadingDialog(isLoading = true)
    }
}

@Preview
@Composable
fun ProductDetailsPreview() {
    ProductDetailsContent(
        state = ProductDetailsScreenState(
            productDetails = Product(
                id = 1,
                title = "Green Card",
                description = "dshjhdjs kljfdksfj dklfjkldsf",
                price = 54.65,
                category = "Eelectronics",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPg2SEl7UdWrd9wg_W0CCEZbw6XVfXK3B8KaikkJg0eNfJjhOyEzWj-fTAhw_iXluVzOQ&usqp=CAU",
                rating = Rating(
                    rate = 4.2,
                    count = 564
                )
            )
        ),
        navController = rememberNavController(),
//        product = Product(
//            id = 1,
//            title = "Green Card",
//            description = "dshjhdjs kljfdksfj dklfjkldsf",
//            price = 54.65,
//            category = "Eelectronics",
//            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPg2SEl7UdWrd9wg_W0CCEZbw6XVfXK3B8KaikkJg0eNfJjhOyEzWj-fTAhw_iXluVzOQ&usqp=CAU",
//            rating = Rating(
//                rate = 4.2,
//                count = 564
//            )
//        )
    )
}