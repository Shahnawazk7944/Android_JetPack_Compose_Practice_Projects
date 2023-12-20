package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme

@Composable
fun GoogleLoginButton() {

    var clicked by remember {
        mutableStateOf(false)
    }
    var authType = "Sign Up with Google"
    Surface(
        onClick = { clicked = !clicked },
        shape = ShapeDefaults.Medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(40.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier.padding(
                start = 16.dp, end = 24.dp
            ).animateContentSize(animationSpec = tween(
                durationMillis = 300, easing = LinearOutSlowInEasing,
            ))
        ){

            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "google Icon",
                modifier = Modifier
                    .size(18.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) "Sign Up in Progress" else authType)
            Spacer(modifier = Modifier.width(8.dp))
            if(clicked){
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp), strokeWidth = 1.dp, color = MaterialTheme.colorScheme.primary
                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun googleLogingButtonPreview() {
    GoogleLoginButton()
}