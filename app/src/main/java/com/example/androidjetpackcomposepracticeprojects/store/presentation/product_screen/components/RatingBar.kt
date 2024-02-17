package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androidjetpackcomposepracticeprojects.ui.theme.Greenish

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    star: Int = 5,
    starColor: Color = Greenish,
    rating: Double = 0.0,
) {
    var isHalfStar = (rating % 1) != 0.0
    Row {
        for (index in 1..star) {
            Icon(
                modifier = modifier,
                imageVector = if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (isHalfStar) {
                        Icons.AutoMirrored.Rounded.StarHalf
                    } else {
                        Icons.Rounded.StarOutline
                    }
                },
                tint = starColor,
                contentDescription = "stars",
            )

        }
    }
}