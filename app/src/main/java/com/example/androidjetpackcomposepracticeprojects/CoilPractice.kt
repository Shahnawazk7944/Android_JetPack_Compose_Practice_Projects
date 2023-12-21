package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CoilPractice() {
//    Box(
//        modifier = Modifier.size(200.dp),
//        contentAlignment = Alignment.Center
//    ) {
//
//        val painter =
//            rememberAsyncImagePainter(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPg2SEl7UdWrd9wg_W0CCEZbw6XVfXK3B8KaikkJg0eNfJjhOyEzWj-fTAhw_iXluVzOQ&usqp=CAU")
//                    .size(200).crossfade(3000) // Set the target size to load the image at.
//                ,
//            )
//        Image(painter = painter, contentDescription = null)
//        if (painter.state is AsyncImagePainter.State.Loading){
//            CircularProgressIndicator()
//        }
//    }


        Box(
            modifier = Modifier.size(200.dp),
            contentAlignment = Alignment.Center
        ) {
            SubcomposeAsyncImage(
                model = "https://www.freepnglogos.com/uploads/android-logo-png/android-logo-png-transparent-images-and-icons-9.png",
                contentDescription = null
            ) {
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading){
                    CircularProgressIndicator()
                }else if (state is AsyncImagePainter.State.Error){
                    Image(painter = painterResource(R.drawable.error), contentDescription = null)
                }else{
                    SubcomposeAsyncImageContent()
                }
            }
        }










//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data("https://www.freepnglogos.com/uploads/android-logo-png/android-logo-png-transparent-images-and-icons-9.png")
//                .error(R.drawable.error)
//                .crossfade(1000)
//                .build(),
//            placeholder = painterResource(R.drawable.avatar_placeholder),
//            contentDescription = null,
//        )
}


@Preview(showBackground = true)
@Composable
fun CoilPracticePreview() {
    CoilPractice()
}