package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.PageIndicator
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.ProductCard
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.LoadingDialog
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductsViewModel
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBackground
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBlack
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
internal fun StoreProductScreen(
    viewModel: ProductsViewModel = hiltViewModel(),
    navController: NavHostController,
    productViewModel: StoreProductDetailsViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductContent(state = state, navController = navController) {
        productViewModel.changeNavigationState("")
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ProductContent(
    state: ProductScreenState, navController: NavHostController, onClick: (String) -> Unit
) {
    val specialOfferImages = listOf(
        painterResource(id = R.drawable.sp0),
        painterResource(id = R.drawable.sp1),
        painterResource(id = R.drawable.sp2),
        painterResource(id = R.drawable.sp3),
        painterResource(id = R.drawable.sp4),
    )
    val specialOfferDiscounts = listOf(
        "45% Discount",
        "30% Discount",
        "65% Discount",
        "40% Discount",
        "25% Discount",
    )
    val pagerState = rememberPagerState(
        pageCount = { specialOfferDiscounts.size },
    )


    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        containerColor = FPrimaryBackground,
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            FProfileSection()
            FSearchbar()

            Text(
                text = "Special Offers",
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = FPrimaryBlack,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))
            HorizontalPager(
                modifier = Modifier,
                contentPadding = PaddingValues(horizontal = 20.dp),
                state = pagerState,
                pageSize = PageSize.Fixed(300.dp),
                pageSpacing = 20.dp,
                verticalAlignment = Alignment.Bottom,
            ) { page ->
                FSpecialOffer(
                    discount = specialOfferDiscounts[page],
                    painter = specialOfferImages[page]
                )

            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                PageIndicator(
                    pageCount = specialOfferImages.size,
                    currentPage = pagerState.currentPage,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            LazyRow(
                //modifier = Modifier.padding(padding),
                contentPadding = PaddingValues(5.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp),
            ) {

                items(state.product.size) { index ->
                    val product = state.product[index]
                    Box(Modifier.clickable {
                        onClick("")
                        navController.navigate(
                            StoreScreen.StoreProductDetails.passToProductDetailsScree(
                                index + 1
                            )
                        ) // Navigate with index
                    }) {
                        ProductCard(product = product)
                    }

                }
            }
        }

    }
}

@Composable
fun FProfileSection(
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = FPrimaryBackground
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
//                .width(144.dp)
                    .height(48.dp)
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .weight(.5f)
                        .scale(1.5f), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tem_profile2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(5.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }



                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .weight(3f),
                ) {
                    Text(
                        text = "Welcome,",
                        fontFamily = ubuntu,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Shahnawaz Khan",
                        fontFamily = poppins,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = FPrimaryBlack
                    )

                }




                IconButton(
                    modifier = Modifier
                        .scale(1.5f)
                        .weight(1f),
                    onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .weight(4f),
                        tint = Color.Unspecified
                    )
                }

            }
        }

    }
}

@Composable
fun FSearchbar() {
    var searchText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .padding(horizontal = 10.dp)
    ) {
        Spacer(modifier = Modifier.height(0.dp))
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            textStyle = TextStyle(
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                //color = AppTheme.colors.secondary
            ),

            placeholder = {
                Text(
                    text = "Search Products",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    //color = AppTheme.colors.onError
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = FPrimaryGreen,
                unfocusedTextColor = FPrimaryBlack,
                focusedContainerColor = FSecondaryBackgroundWhite,
                unfocusedContainerColor = FSecondaryBackgroundWhite,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = FPrimaryGreen,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray,
                focusedLeadingIconColor = FPrimaryGreen,
                unfocusedLeadingIconColor = Color.Gray,
                focusedTrailingIconColor = FPrimaryGreen,
                unfocusedTrailingIconColor = Color.Gray
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search icon",
                    modifier = Modifier.size(30.dp)
                )
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.filt),
                        contentDescription = "filter icon",
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

    }
}

@Composable
fun FSpecialOffer(
    discount: String,
    painter: Painter
) {
    Card(
        modifier = Modifier
            .width(320.dp)
            .height(150.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            //contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .align(Alignment.TopStart)
            ) {

                Text(
                    text = discount,
                    fontFamily = poppins,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = FSecondaryBackgroundWhite
                )
                Text(
                    text = "For a cozy yellow set!",
                    fontFamily = ubuntu,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = FSecondaryBackgroundWhite
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(0.dp),
                    shape = RoundedCornerShape(18.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = FPrimaryGreen,
                        contentColor = FSecondaryBackgroundWhite,
                    )
                ) {
                    Text(
                        "Buy Now",
                        fontFamily = poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun Previews() {
    FSpecialOffer(
        painter = painterResource(id = R.drawable.sp0),
        discount = "25% Discount"
    )
}