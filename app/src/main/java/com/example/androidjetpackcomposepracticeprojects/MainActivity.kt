package com.example.androidjetpackcomposepracticeprojects

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.store.presentation.StoreNavGraph
import com.example.androidjetpackcomposepracticeprojects.store.presentation.StoreScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels.StoreProductDetailsViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import com.example.androidjetpackcomposepracticeprojects.util.Event
import com.example.androidjetpackcomposepracticeprojects.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //private lateinit var navController: NavHostController
    private val viewModal by viewModels<ViewModal>()
    private val productVM by viewModels<StoreProductDetailsViewModel>()

    @SuppressLint(
        "ShowToast", "UnusedMaterial3ScaffoldPaddingParameter",
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
                    val navController = rememberNavController()
//                    var selectedItem by rememberSaveable {
//                        mutableStateOf("home")
//                    }
                    val state by productVM.state.collectAsStateWithLifecycle()

                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = state.route == "home",
                                    onClick = {
                                        productVM.changeNavigationState("home")
                                        navController.navigate(StoreScreen.StoreHomeScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.home),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(35.dp)
                                                .padding(4.dp)
                                        )
                                    })
                                NavigationBarItem(
                                    selected = state.route == "cart",

                                    onClick = {
                                        productVM.changeNavigationState("cart")
                                        navController.navigate(StoreScreen.StoreProductCart.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.cart),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .padding(4.dp)
                                        )
                                    })

                                NavigationBarItem(
                                    selected = state.route == "profile",
                                    onClick = {
                                        productVM.changeNavigationState("profile")
                                        navController.navigate(StoreScreen.StoreProfileScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.profile),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(35.dp)
                                                .padding(4.dp)
                                        )
                                    })

                            }

                        }
                    ) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(it)) {
                           // val viewModel: StoreProductDetailsViewModel = hiltViewModel()
                            StoreNavGraph(
                                navController = navController,
                                viewModel = productVM
                            )
                        }
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