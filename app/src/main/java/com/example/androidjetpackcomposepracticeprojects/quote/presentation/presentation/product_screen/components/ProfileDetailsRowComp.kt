package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik

@Composable
fun ProfileDetailsRowComp(
    onClick: () -> Unit,
    rowTitle:String,
    rowTitleColor:Color = MaterialTheme.colorScheme.onBackground,
    leadingIconColor: Color = Color(0xFFFFE403),
    trailingIconState: Boolean = true,
    leadingIcon:Int

) {
    Row(
        modifier = Modifier
            .clickable { onClick }
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(leadingIcon),
            contentDescription = "",
            tint = leadingIconColor,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(30.dp))
                //.background(Color.DarkGray)
                .weight(1f)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = rowTitle,
            fontFamily = rubik,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = rowTitleColor,
            modifier = Modifier.weight(4f)
        )
        if (trailingIconState){
        Icon(
            painter = painterResource(R.drawable.nexttt),
            contentDescription = "",
            tint = Color.Gray,
            modifier = Modifier
                .size(30.dp)
                .weight(1f)
                .clickable {
                    onClick
                }
        )
        }

    }
}