package com.example.androidjetpackcomposepracticeprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_21
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetPackComposePracticeProjectsTheme {
                // A surface container using the 'background' color from the theme


                Column(
                    modifier = Modifier
                        .fillMaxSize(),
//                        .background(gradient_31),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var counter by remember {
                        mutableIntStateOf(0)
                    }
                    Counter(counter) {
                        counter++
                    }
                    Counter(counter) {
                        counter++
                    }
//                    val color = remember {
//                        mutableStateOf(gradient_22)
//                    }
//                    ColorBox(
//                        Modifier.weight(1f).fillMaxSize()
//                    ) {
//                        color.value = it
//                    }
//                    Box(
//                        modifier = Modifier
//                            .background(color.value)
//                            .weight(1f).fillMaxSize()
//                    )
                }
            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier, updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(gradient_21)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    ColorBox()
}