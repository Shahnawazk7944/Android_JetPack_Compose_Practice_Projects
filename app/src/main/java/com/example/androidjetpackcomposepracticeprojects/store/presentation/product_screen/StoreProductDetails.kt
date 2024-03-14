package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components.ProfileDetailsRowComp
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.util.components.QuotesTopAppBar
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun StoreProductDetails(
    navController: NavHostController,index:String
) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { it ->
            imageUri = it
        }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StoreTopAppBar(
                title = {
                    Text(
                        "Profile",
                        fontFamily = ubuntu,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                appBarLeadingIcon = painterResource(R.drawable.back),
                onClick = {
                    navController.navigateUp()
                },
                action = {

                }
            )
        },

        ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            if (imageUri != null) {
                bitmap?.let {
                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(bottom = 2.dp)
                            .padding(horizontal = 10.dp)
                            .clip(CircleShape)
                            .clickable {
                                launcher.launch("image/*")
                            },
                        contentDescription = "null",
                        contentScale = ContentScale.Crop,
                        bitmap = it.asImageBitmap()
                    )
                }
            } else {
                Icon(painter = painterResource(R.drawable.blank_profile),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            launcher.launch("image/*")
//
                        }
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Shahnawaz Khan",
                fontFamily = rubik,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "shahnawazkhan238200@gmail.com",
                fontFamily = rubik,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)
                    .padding(4.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 0.dp
                ),
                border = BorderStroke(1.dp, color = Color.LightGray),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFE403),
                    //contentColor = SecondaryFontColor
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Edit Profile",
                        fontFamily = rubik,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            ProfileDetailsRowComp(
                onClick = {},
                rowTitle = "Settings  $index",
                leadingIcon = R.drawable.setting
            )
            ProfileDetailsRowComp(
                onClick = {},
                rowTitle = "Billing Details",
                leadingIcon = R.drawable.wallet

            )
            ProfileDetailsRowComp(
                onClick = {},
                rowTitle = "User Management",
                leadingIcon = R.drawable.terms

            )
            ProfileDetailsRowComp(
                onClick = {},
                rowTitle = "Information",
                leadingIcon = R.drawable.information

            )
            ProfileDetailsRowComp(
                onClick = {},
                rowTitle = "Logout",
                rowTitleColor = Color.Red,
                trailingIconState = false,
                leadingIcon = R.drawable.logoutt

            )


        }
    }
}
