package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.AuthScreen

@Composable
fun StoreSignUp(
    authNavController: NavHostController,
) {
    StoreSignUpContent(authNavController = authNavController)
}


@Composable
fun StoreSignUpContent(
    authNavController: NavHostController,
) {
    Scaffold(

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                authNavController.navigate(AuthScreen.StoreHomeScreen.route)
            }) {
                Text(text = "Click to Home Screen")
            }
        }
    }
}