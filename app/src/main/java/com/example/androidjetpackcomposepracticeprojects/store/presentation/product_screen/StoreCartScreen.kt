package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.RatingBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.CartItem
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.ProductDetailsScreenState
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu
import kotlin.time.times

@Composable
fun ProductCart(
    viewModel: StoreProductDetailsViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductCartContent(state = state, navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductCartContent(
    state: ProductDetailsScreenState,
    navController: NavHostController,
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
                },
                action = {

                }
            )
        },
    ) {
//        Log.d("check in cart screen", state.cartItems[2].product.title)
//        Log.d("check in cart screen", state.cartItems[1].product.title)
//        Log.d("check in cart screen", state.cartItems[0].product.title)
        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(count = state.cartItems.size){index ->
                StoreCartItem(cartItem = state.cartItems[index], index = index)
            }
//            items(itstate.cartItems) { cartItem ->
//                StoreCartItem(cartItem = state.cartItems[cartItem])
//            }
        }
    }
}

@Composable
fun StoreCartItem(
    cartItem: CartItem,
    index:Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(5.dp)
                //.height(150.dp)
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
            Row {
                Column(
                    modifier = Modifier
                        //.fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = cartItem.product.category.replaceFirstChar { it.uppercase() },
                        fontFamily = rubik,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Gray

                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = cartItem.product.title,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = ChocolateBrown

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$ ${cartItem.product.price}",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = gradient_32
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text ="Quantity : ${cartItem.quantity}",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = ChocolateBrown

                    )

                }

                Column(
                    modifier = Modifier
                        //.fillMaxSize()
                        .padding(8.dp)
                ) {

                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Total Price ",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = ChocolateBrown

                    )g
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "\$ ${cartItem.product.price * cartItem.quantity }",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = gradient_32
                    )

                }
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
        index = 4
    )
}
