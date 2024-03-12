package com.example.androidjetpackcomposepracticeprojects

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.models.NavGraph
import com.example.androidjetpackcomposepracticeprojects.models.Screen
import com.example.androidjetpackcomposepracticeprojects.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import com.example.androidjetpackcomposepracticeprojects.util.Event
import com.example.androidjetpackcomposepracticeprojects.util.EventBus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //private lateinit var navController: NavHostController
    private val viewModal by viewModels<ViewModal>()
    @SuppressLint("ShowToast", "UnusedMaterial3ScaffoldPaddingParameter",
        "StateFlowValueCalledInComposition"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val lifecyclleOwner = LocalLifecycleOwner.current.lifecycle
            LaunchedEffect(key1 = lifecyclleOwner) {
                lifecyclleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    EventBus.event.collect { event ->
                        when (event) {
                            is Event.Toast -> {
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
            }

            AndroidJetPackComposePracticeProjectsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
//                    var checkedState by remember { mutableStateOf(false) }
//                    Column(
//                        Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        RoundedCornerCheckbox(
//                            label = "Remember Me",
//                            labelSize = 25.sp,
//                            labelColor = Color.Black,
//                            checkedColor = Color(0xFF00CDBD),
//                            uncheckedColor = Color(0xFFf0ffff),
//                            isChecked = checkedState,
//                            size = 40f,
//                            onValueChange = { checkedState = it },
//                            modifier = Modifier.padding(10.dp)
//                        )
//                    }
                    val navController = rememberNavController()
                    var selectedItem by rememberSaveable {
                        mutableStateOf("home")
                    }
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = selectedItem == "home",
                                    onClick = {
                                        selectedItem = "home"
                                        navController.navigate(Screen.QuotesHomeScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.home),
                                            contentDescription = null,
                                            modifier = Modifier.size(35.dp).padding(4.dp)
                                        )
                                    })

                                NavigationBarItem(
                                    selected = selectedItem == "profile",
                                    onClick = {
                                        selectedItem = "profile"
                                        navController.navigate(Screen.QuotesProfileScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.profile),
                                            contentDescription = null,
                                            modifier = Modifier.size(35.dp).padding(4.dp)
                                        )
                                    })

                            }

                        }
                    ) {
                        NavGraph(navController = navController,
                            )
                    }

                    //QuotesScreen()
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