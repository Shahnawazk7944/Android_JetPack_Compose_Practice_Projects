package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrice
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBlack
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = Modifier
            //.height(500.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(FSecondaryBackgroundWhite),
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .background(FSecondaryBackgroundWhite),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
                .background(FSecondaryBackgroundWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Row {
                    Text(
                        text = product.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = FPrimaryBlack  ,
                                modifier = Modifier
                            .weight(2f),
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    IconButton(
                        modifier = Modifier
                            .scale(1.5f)
                            .weight(1f),
                        onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.bag),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .weight(4f),
                            tint = Color.Unspecified
                        )
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = product.category.replaceFirstChar { it.uppercase() },
                    fontFamily = rubik,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$ ${product.price}",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = FPrice
                )
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