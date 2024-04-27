package com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    eventText: String,
    leadingIconComposable: @Composable () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp).padding(horizontal = 10.dp),
        //.clip(RoundedCornerShape(50.dp))
        shape = RoundedCornerShape(15.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 3.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = FPrimaryGreen,
            contentColor = FSecondaryBackgroundWhite,
        )
    ) {
        Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

//                Icon(
//                    painter = leadingIcon,
//                    contentDescription = "leading icon",
//                    tint = Color.White,
//                    modifier = Modifier.size(18.dp),
//                )

//            Icon(
//                imageVector = Icons.Rounded.ShoppingCart,
//                contentDescription = "leading icon",
//                modifier = Modifier.size(30.dp),
//                tint = FSecondaryBackgroundWhite
//            )

            leadingIconComposable()
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                    eventText,
                    fontFamily = poppins,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )

            }
    }
}