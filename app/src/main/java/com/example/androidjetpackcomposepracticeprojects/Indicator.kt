package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AzureMist
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Indicator() {

    val welcomeDescription = listOf(
        "Welcome to Zeru, a great friend to chat with you",
        "If you are confused about what to do, just open Zeru",
        "Zeru will be ready to chat and make you happy"
    )
    val pagerState = rememberPagerState(pageCount = {
        welcomeDescription.size
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzureMist),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                Modifier
                    //.wrapContentSize()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                //Spacer(modifier = Modifier.height(20.dp))
                Text(
                    welcomeDescription[page],
                    fontFamily = ubuntu,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 40.sp,
                    color = ChocolateBrown,
                    textAlign = TextAlign.Center
                )


            }

        }

        PageIndicator(
            pageCount = welcomeDescription.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.padding(60.dp)
        )
    }

}

@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDot(isSelected = it == currentPage)
        }
    }


}

@Composable
fun IndicatorDot(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(15.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) ChocolateBrown else Color.Gray)
    )
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    Indicator()
}