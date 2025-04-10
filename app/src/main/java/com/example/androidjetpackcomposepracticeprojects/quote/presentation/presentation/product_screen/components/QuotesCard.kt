package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import com.example.androidjetpackcomposepracticeprojects.ui.theme.PaleYellow
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik

@Composable
fun QuotesCard(
    modifier: Modifier = Modifier,
    quotes: Quotes
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Black)
            .padding(0.dp),
        //.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 20.dp),
            //.background(Color(0x407D7986)),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = quotes.q.replaceFirstChar { it.uppercase() },
                fontFamily = rubik,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center).padding(horizontal = 4.dp)
            )
            Text(
                text = quotes.a.replaceFirstChar { it.uppercase() },
                fontFamily = rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = PaleYellow,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            //Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.padding(vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                modifier = Modifier.padding(vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                modifier = Modifier.padding(vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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

@Preview
@Composable
fun ProductContentPreview() {
    QuotesCard(
        quotes = Quotes(
            q = "dshjhdjs kljfdksfj dklfjkldsf",
            a = "Green Card",
            c = "dshjhdjs kljfdksfj dklfjkldsf",
            h = "Green Card"
        ),
    )
}