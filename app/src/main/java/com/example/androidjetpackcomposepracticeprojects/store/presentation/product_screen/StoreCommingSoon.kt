package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins

@Composable
fun StoreCommingSoon(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Comming Soon......",
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = FPrimaryGreen,
            textAlign = TextAlign.Center
        )
    }
}