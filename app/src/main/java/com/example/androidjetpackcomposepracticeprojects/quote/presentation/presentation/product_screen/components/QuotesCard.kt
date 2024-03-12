package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components.ProductCard
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik

@Composable
fun QuotesCard(
    modifier: Modifier = Modifier,
    quotes: Quotes
) {
    Box(
        modifier = modifier
            .background(Color.Black)
            .clip(RoundedCornerShape(20.dp)),
//            .shadow(elevation = 2.dp,
//                shape = RoundedCornerShape(2.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp)
            //.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                //.background(Color(0x407D7986)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quotes.quote.quote.replaceFirstChar { it.uppercase() },
                    fontFamily = rubik,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
                Text(
                    text = quotes.quote.author.replaceFirstChar { it.uppercase() },
                    fontFamily = rubik,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                //Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.heart),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(18.dp),
                    )
                    Text(
                        text = "Save",
                        fontFamily = rubik,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        color = Color.Black,
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.downloads),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(18.dp),
                    )
                    Text(
                        text = "Download",
                        fontFamily = rubik,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        color = Color.Black,
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.share),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(18.dp),
                    )
                    Text(
                        text = "Share",
                        fontFamily = rubik,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        color = Color.Black,
                    )
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