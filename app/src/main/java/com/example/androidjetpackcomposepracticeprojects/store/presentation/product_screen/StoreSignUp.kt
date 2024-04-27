package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.AuthScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.PrimaryButton
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite

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
           PrimaryButton(
               onClick = {authNavController.navigate(AuthScreen.StoreHomeScreen.route) },
               eventText = "Click to Home Screen" ,
               leadingIconComposable = {},
               modifier = Modifier
           )
        }
    }
}