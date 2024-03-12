package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DisplayMode.Companion.Input
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.QuotesViewModel
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.util.components.QuotesTopAppBar
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun QuotesProfileScreen(
    navController: NavHostController,
) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent() ){it ->
            imageUri = it
        }
    bitmap = getImage(uri = imageUri.toString())
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            QuotesTopAppBar(
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
            Spacer(modifier = Modifier.height(40.dp))
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
        }
    }
}

@Composable
fun getImage(
    uri: String
): Bitmap? {
    val imageState: AsyncImagePainter.State = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(uri)
            .size(Size.ORIGINAL)
            .build()
    ).state

    if (imageState is AsyncImagePainter.State.Success) {
        return imageState.result.drawable.toBitmap()
    }

    return null
}