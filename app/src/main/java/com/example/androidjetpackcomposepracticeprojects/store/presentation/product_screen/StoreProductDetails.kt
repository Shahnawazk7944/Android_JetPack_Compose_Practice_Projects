package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.RatingBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.LoadingDialog
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductDetailsScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AzureMist
import com.example.androidjetpackcomposepracticeprojects.ui.theme.DarkBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrice
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBackground
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBlack
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FRating
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
fun StoreProductDetails(
    viewModel: StoreProductDetailsViewModel, navController: NavHostController, index: String
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getProductDetails(productId = index)
    }


    ProductDetailsContent(state = state,
        navController = navController,
        changeRoute = { viewModel.changeNavigationState(it) },
        addToCart = { product, quantity ->
            viewModel.updateCart(product, quantity)
        })

}

@Composable
fun ProductDetailsContent(
    state: ProductDetailsScreenState,
    navController: NavHostController,
    changeRoute: (String) -> Unit,
    addToCart: (Product, Int) -> Unit
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
            containerColor = FPrimaryBackground,
            //Top App bar
            topBar = {
                StoreTopAppBar(title = {},
                    appBarLeadingIcon = painterResource(R.drawable.back),
                    onClick = {
                        changeRoute("home")
                        navController.navigateUp()
                    },
                    action = {
                        IconButton(modifier = Modifier.scale(1f), onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.heart),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .weight(4f),
                                tint = Color.Unspecified
                            )
                        }
                    })
            },
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(FPrimaryBackground),
            ) {
                //Product image Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(horizontal = 10.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = state.productDetails.image,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(10.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Fit
                    )
                }


                Spacer(modifier = Modifier.height(5.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                        .background(FPrimaryBackground)
                ) {
                    // ------------------- Product Title and Price
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = state.productDetails.title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp,
                            color = FPrimaryBlack,
                            modifier = Modifier
                                .weight(4f)
                                .align(Alignment.CenterVertically)
                        )
                        Box(
                            modifier = Modifier
                                .weight(2f)
                                .padding(start = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$ ${state.productDetails.price}",
                                fontFamily = poppins,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = FPrice,
                            )
                        }
                    }


                    // ------------------- Product View,Like and Peoples
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(modifier = Modifier.scale(1.5f), onClick = {}) {
                                    Icon(
                                        painter = painterResource(R.drawable.user2),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = Color.Gray
                                    )
                                }
                                Text(
                                    text = "${state.productDetails.rating.count + 23} Seen",
                                    fontFamily = ubuntu,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 18.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.padding(end = 10.dp)
                                )
                                IconButton(modifier = Modifier.scale(1.5f), onClick = {}) {
                                    Icon(
                                        painter = painterResource(R.drawable.heart),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = Color.Gray
                                    )
                                }
                                Text(
                                    text = "${state.productDetails.rating.count} Liked",
                                    fontFamily = ubuntu,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 18.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.padding(end = 10.dp)
                                )

                            }

                            //--------------------Rating Start
                            Spacer(modifier = Modifier.height(10.dp))
                            RatingBar(
                                modifier = Modifier.size(30.dp),
                                rating = state.productDetails.rating.rate,
                                starColor = FRating
                            )
                        }

                        //--------------------Rating Images
                        Box(
                            modifier = Modifier
                        ) {

                            Box(
                                modifier = Modifier.scale(1.5f)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.tem_profile),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(5.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, FSecondaryBackgroundWhite, CircleShape),
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center,
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .scale(1.5f)
                                    .padding(start = 15.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.tem_profile2),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(5.dp)
                                        .clip(CircleShape)
                                        .border(1.dp, FSecondaryBackgroundWhite, CircleShape),
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center,
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 35.dp)
                                    .size(35.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, FSecondaryBackgroundWhite, CircleShape)
                                    .background(FPrimaryGreen),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "+${state.productDetails.rating.count - 2}",
                                    fontFamily = ubuntu,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    color = FSecondaryBackgroundWhite,
                                )
                            }


                        }

                    }



                    Text(
                        text = "Description",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        color = FPrimaryBlack,
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = state.productDetails.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = FPrimaryBlack,
                        modifier = Modifier.padding(start = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            addToCart(state.productDetails, count)
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
                            modifier = Modifier.padding(start = 20.dp)

                        )

                    }

                }
//                Spacer(modifier = Modifier.height(5.dp))
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Spacer(modifier = Modifier.height(10.dp))
//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Spacer(modifier = Modifier.width(60.dp))
//                    Box(
//                        modifier = Modifier
//                            .width(140.dp)
//                            .height(45.dp)
//                            .clip(RoundedCornerShape(20.dp))
//                            .background(DarkBrown),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//
//                            IconButton(onClick = {
//                                if (count != 1) {
//                                    count--
//                                }
//                            }) {
//                                Icon(
//                                    painter = painterResource(R.drawable.decrease),
//                                    contentDescription = "null",
//                                    modifier = Modifier
//                                        .size(25.dp)
//                                        .weight(1f)
//                                )
//                            }
//                            Text(
//                                text = "$count",
//                                fontFamily = poppins,
//                                fontWeight = FontWeight.Normal,
//                                fontSize = 20.sp,
//                                color = AzureMist,
//                                textAlign = TextAlign.Center,
//                                modifier = Modifier.weight(2f)
//                            )
//                            IconButton(onClick = {
//                                if (count >= 1) {
//                                    count++
//                                }
//                            }) {
//                                Icon(
//                                    painter = painterResource(R.drawable.increase),
//                                    contentDescription = "null",
//                                    modifier = Modifier
//                                        .size(25.dp)
//                                        .weight(1f)
//                                )
//                            }
//                        }
//                    }
//
//                }

                if (dialogState) {
                    AlertDialog(icon = {
                        Icon(
                            imageVector = Icons.Outlined.AddTask,
                            contentDescription = "Example Icon",
                            tint = AzureMist,
                            modifier = Modifier.size(50.dp)
                        )
                    }, title = {
                        Text(
                            text = "Your Product Is Added To Cart",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = AzureMist,
                            textAlign = TextAlign.Center
                        )
                    }, onDismissRequest = {
                        dialogState = false
                        count = 1
                    }, confirmButton = {
                        TextButton(onClick = {
                            changeRoute("cart")
                            navController.navigate(StoreScreen.StoreProductCart.route)
                            count = 1
                            dialogState = false
                        }) {
                            Text("Navigate to Cart")
                        }
                    }, dismissButton = {
                        TextButton(onClick = {
                            dialogState = false
                            count = 1

                        }) {
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
    ProductDetailsContent(state = ProductDetailsScreenState(
        productDetails = Product(
            id = 1,
            title = "Green Card",
            description = "dshjhdjs kljfdksfj dklfjkldsf",
            price = 54.65,
            category = "Eelectronics",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPg2SEl7UdWrd9wg_W0CCEZbw6XVfXK3B8KaikkJg0eNfJjhOyEzWj-fTAhw_iXluVzOQ&usqp=CAU",
            rating = Rating(
                rate = 4.2, count = 564
            )
        )
    ), navController = rememberNavController(), changeRoute = {}, addToCart = { product, i -> }
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