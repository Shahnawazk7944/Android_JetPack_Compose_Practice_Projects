package com.example.androidjetpackcomposepracticeprojects

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.ProductScreen
import com.example.androidjetpackcomposepracticeprojects.store.util.Event
import com.example.androidjetpackcomposepracticeprojects.store.util.EventBus
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    private val viewModal by viewModels<ViewModal>()

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            val lifecyclleOwner = LocalLifecycleOwner.current.lifecycle
//            LaunchedEffect(key1 = lifecyclleOwner) {
//                lifecyclleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                    EventBus.event.collect { event ->
//                        when (event) {
//                            is Event.Toast -> {
//                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//                        }
//                    }
//                }
//            }

            AndroidJetPackComposePracticeProjectsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var checkedState by remember { mutableStateOf(false) }
                    Column (
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        RoundedCornerCheckbox(
                            label = "Remember Me",
                            labelSize = 25.sp,
                            labelColor = Color.Black,
                            checkedColor = Color(0xFF00CDBD),
                            uncheckedColor = Color(0xFFf0ffff),
                            isChecked = checkedState,
                            size = 40f,
                            onValueChange = { checkedState = it },
                            modifier = Modifier.padding(10.dp)
                        )
                    }


                    //ProductScreen()
                }

//                Indicator()
                //SplashScreen()
//
//                // A surface container using the 'background' color from the theme
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(gradient_31),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
////                    navController = rememberNavController()
////                    NavGraph(navController = navController)
//
//                    var text by remember {
//                        mutableStateOf("")
//                    }
//                    val updatedText = viewModal.newText.collectAsState()
//                    Text(text = updatedText.value, fontSize = 25.sp, color = gradient_32)
//                    Spacer(modifier = Modifier.height(30.dp))
//                    TextField(value = updatedText.value, onValueChange = {
//                        viewModal.changeText(it)
//                    })

// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA
// will start tomorrow insA

                //its calling new text filed
//                    TextFields()

//                    val personData = PersonData()
//                    val getAllPersonData = personData.getAllPersonsData()
//                    LazyColumn(
//                        contentPadding = PaddingValues(all = 12.dp),
//                        verticalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        items(items = getAllPersonData) { person ->
//                            PersonDetails(person = person)
//                        }
//                    }


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