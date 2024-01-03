package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.RootBeer

@Composable
fun Counter() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        var number by remember {
            mutableIntStateOf(0)
        }
        Text(text = "Counter is : $number", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(
                onClick = { number++ },
                modifier = Modifier
                    .height(60.dp)
                    .width(130.dp),
                colors = ButtonDefaults.buttonColors(ChocolateBrown),
                shape = ShapeDefaults.Small
            ) {
                Text(text = "Increase", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { if (number >= 1) number-- },
                modifier = Modifier
                    .height(60.dp)
                    .width(130.dp),
                colors = ButtonDefaults.buttonColors(RootBeer),
                shape = ShapeDefaults.Small
            ) {
                Text(text = "Decrease", fontSize = 18.sp)
            }
        }

    }
}