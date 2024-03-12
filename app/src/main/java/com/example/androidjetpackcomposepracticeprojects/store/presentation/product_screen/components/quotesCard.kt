package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Box(
        modifier = modifier
            .background(Color.White)
            .clip(RoundedCornerShape(20.dp)),

//            .shadow(elevation = 2.dp,
//                shape = RoundedCornerShape(2.dp))
    ) {
        Column(
            modifier = Modifier.padding(0.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
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
                        text = product.category.replaceFirstChar { it.uppercase() },
                        fontFamily = rubik,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Gray

                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = product.title,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = ChocolateBrown

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$ ${product.price}",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = gradient_32
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
//                        Text(
//                            text = "${ product.rating.rate }",
//                            fontFamily = ubuntu,
//                            fontWeight = FontWeight.Medium,
//                            fontSize = 14.sp,
//                            color = gradient_32
//                        )
                        RatingBar(
                            modifier = Modifier.size(15.dp),
                            rating = product.rating.rate
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "${product.rating.count} Reviews",
                            fontFamily = ubuntu,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = Color(0xFF0A533F)
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductContentPreview() {
    ProductCard(
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
    )
}