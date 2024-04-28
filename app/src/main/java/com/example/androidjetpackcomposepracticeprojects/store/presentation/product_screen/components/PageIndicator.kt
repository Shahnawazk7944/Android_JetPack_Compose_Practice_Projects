package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen

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
    val width = animateDpAsState(targetValue = if (isSelected) 30.dp else 10.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) FPrimaryGreen else Color(0x4A0C8A7B))
    )
}