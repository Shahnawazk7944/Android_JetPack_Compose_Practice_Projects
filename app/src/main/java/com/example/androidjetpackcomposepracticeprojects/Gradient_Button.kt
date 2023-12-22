package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_21
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_22
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_31
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32

@Composable
fun Gradient_Button(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .height(40.dp)
                .background(gradient)
                .padding(horizontal = 24.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GradiantButtonPreview() {
    Gradient_Button(
        text = "Hover ME",
        textColor = Color.White,
        gradient = Brush.horizontalGradient(
            colors = listOf(
                gradient_31,
                gradient_32
            )
        )
    ) {

    }
}