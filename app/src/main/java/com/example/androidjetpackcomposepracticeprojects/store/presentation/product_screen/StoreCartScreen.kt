package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.presentation.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.CartItem
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductDetailsScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.RootBeer
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
fun ProductCart(
    viewModel: StoreProductDetailsViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductCartContent(state = state, navController = navController) {
        viewModel.deleteCartItem(it)
    }
}

@Composable
fun ProductCartContent(
    state: ProductDetailsScreenState,
    navController: NavHostController,
    onClick: (Int) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StoreTopAppBar(
                title = {
                    Text(
                        "Cart",
                        fontFamily = ubuntu,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                appBarLeadingIcon = painterResource(R.drawable.back),
                onClick = {
                    navController.navigateUp()
                   state.route = ""
                },
                action = {

                }
            )
        },
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize()) {
            if (state.cartItems.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.padding(paddingValues),
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(count = state.cartItems.size) { index ->
                        StoreCartItem(
                            cartItem = state.cartItems[index],
                            index = index,
                            onClick = onClick
                        )
                    }
                }
            } else {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.empty_content),
                        contentDescription = "empty cart",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(200.dp),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "No items in your cart yet.",
                        fontFamily = rubik,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Gray

                    )
                }

            }

        }

    }
}

@Composable
fun StoreCartItem(
    cartItem: CartItem,
    index: Int,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(5.dp)
                .width(150.dp)
                .background(Color.White)
        ) {
            AsyncImage(
                model = cartItem.product.image,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxHeight()
                    //.size(100.dp)
                    .padding(5.dp)

                    //.height(200.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                //.height(150.dp)
                .background(Color(0x407D7986))
        ) {
            Column(
                modifier = Modifier
                    .matchParentSize()
                    .padding(8.dp)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = cartItem.product.category.replaceFirstChar { it.uppercase() },
                    fontFamily = rubik,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Gray

                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = cartItem.product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = ChocolateBrown,

                    )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(RootBeer)) {
                            append("Price :       ")
                        }
                        withStyle(style = SpanStyle(color = gradient_32)) {
                            append("\$${cartItem.product.price}")
                        }
                    },
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(RootBeer)) {
                            append("Quantity :                   ")
                        }
                        withStyle(style = SpanStyle(color = gradient_32)) {
                            append("${cartItem.quantity}")
                        }
                    },
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Divider(thickness = 1.dp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(RootBeer)) {
                            append("Total Price :     ")
                        }
                        withStyle(style = SpanStyle(color = gradient_32)) {
                            append(
                                "\$ ${
                                    String.format(
                                        "%.2f",
                                        cartItem.product.price * cartItem.quantity.toDouble()
                                    )
                                }"
                            )
                        }
                    },
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.End)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(
                modifier = Modifier.align(Alignment.BottomStart),
                onClick = {
                    onClick(index)

                }) {
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "back Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp),
                )
            }

        }
    }
}

@Preview
@Composable
fun StoreCartItemPreview() {
    StoreCartItem(
        cartItem = CartItem(
            quantity = 4,
            product = Product(
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
        index = 4,
        onClick = {}
    )
}
