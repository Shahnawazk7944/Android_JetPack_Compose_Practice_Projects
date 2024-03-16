package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AzureMist
import com.example.androidjetpackcomposepracticeprojects.ui.theme.DarkBrown
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
        state = state, navController = navController, viewModel = viewModel
    )

}

@Composable
fun ProductDetailsContent(
    state: ProductDetailsScreenState,
    navController: NavHostController, viewModel: StoreProductDetailsViewModel
) {
    Log.d("enter in product details", "nothing")
    var count by rememberSaveable {
        mutableIntStateOf(1)
    }
    var dialogState by remember {
        mutableStateOf(false)
    }
    if (!state.isLoading) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                StoreTopAppBar(
                    title = {
                        Text(
                            "Product Details",
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
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.LightGray),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(15.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = state.productDetails.image,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .padding(30.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                        .padding(15.dp, 0.dp, 15.dp, 15.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFcf5c7b))
                        .verticalScroll(rememberScrollState())

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp, start = 0.dp, end = 5.dp, bottom = 5.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp)
                        ) {
                            Text(
                                text = state.productDetails.category.replaceFirstChar { it.uppercase() },
                                fontFamily = rubik,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.LightGray,
                                modifier = Modifier.weight(2f)
                            )
                            RatingBar(
                                modifier = Modifier.size(20.dp),
                                rating = state.productDetails.rating.rate,
                                starColor = gradient_32
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "${state.productDetails.rating.count}",
                                fontFamily = ubuntu,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.White,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = state.productDetails.title,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = AzureMist,
                            modifier = Modifier
                                .padding(start = 20.dp)

                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(120.dp)
                                    .clip(RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
                                    .background(Color.White),
                                // .align(Alignment.Start),
                                contentAlignment = Alignment.Center

                            ) {
                                Text(
                                    text = "${state.productDetails.price}",
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp,
                                    color = Color(0xFFcf5c7b),
                                    modifier = Modifier
                                        .padding(8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(60.dp))
                            Box(
                                modifier = Modifier
                                    .width(140.dp)
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(DarkBrown),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    IconButton(onClick = {
                                        if (count != 1) {
                                            count--
                                        }
                                    }) {
                                        Icon(
                                            painter = painterResource(R.drawable.decrease),
                                            contentDescription = "null",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .weight(1f)
                                        )
                                    }
                                    Text(
                                        text = "$count",
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 20.sp,
                                        color = AzureMist,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.weight(2f)
                                    )
                                    IconButton(onClick = {
                                        if (count >= 1) {
                                            count++
                                        }
                                    }) {
                                        Icon(
                                            painter = painterResource(R.drawable.increase),
                                            contentDescription = "null",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .weight(1f)
                                        )
                                    }
                                }
                            }

                        }

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = state.productDetails.description,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = AzureMist,
                            modifier = Modifier
                                .padding(start = 20.dp)

                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                viewModel.updateCart(state.productDetails, quantity = count)
                                dialogState = true
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                //.height(380.dp)
                                .padding(15.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = DarkBrown
                            )

                        ) {
                            Text(
                                text = "Added To Cart",
                                fontFamily = poppins,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = AzureMist,
                                modifier = Modifier
                                    .padding(start = 20.dp)

                            )

                        }

                    }
                }
//                Spacer(modifier = Modifier.height(5.dp))

                if (dialogState) {
                    AlertDialog(
                        icon = {
                            Icon(
                            imageVector = Icons.Outlined.AddTask,
                            contentDescription = "Example Icon",
                            tint = AzureMist,
                            modifier = Modifier.size(50.dp)
                        )},
                        title = {
                            Text(
                                text = "Your Product Is Added To Cart",
                                fontFamily = poppins,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                color = AzureMist,
                               textAlign = TextAlign.Center
                            )
                        },
                        onDismissRequest = {
                            dialogState = false
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    dialogState = false
                                }
                            ) {
                                Text("Navigate to Cart")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                   dialogState = false

                                }
                            ) {
                                Text("Cancel")
                            }
                        }


                    )
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
        viewModel = hiltViewModel(),
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