package com.example.androidjetpackcomposepracticeprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_21
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_22
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_31
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetPackComposePracticeProjectsTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PasswordField()


                    Spacer(modifier = Modifier.height(10.dp))
                    Row {


                        Gradient_Button(
                            text = "Back",
                            textColor = Color.White,
                            gradient = Brush.horizontalGradient(
                                colors = listOf(
                                    gradient_31, gradient_32
                                )
                            )
                        ) {

                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Gradient_Button(
                            text = "Proceed",
                            textColor = Color.White,
                            gradient = Brush.horizontalGradient(
                                colors = listOf(
                                    gradient_21, gradient_22,
                                )
                            )
                        ) {

                        }
                    }


                    //              CoilPractice()
//                    CoilPractice2()
//                    CoilPractice3()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJetPackComposePracticeProjectsTheme {

    }
}