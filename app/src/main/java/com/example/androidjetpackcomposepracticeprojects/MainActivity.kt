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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposepracticeprojects.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.splitify.presentation.NavGraph.NavGraph
import com.example.androidjetpackcomposepracticeprojects.splitify.presentation.NavGraph.Screen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen.ProductScreen
import com.example.androidjetpackcomposepracticeprojects.store.util.Event
import com.example.androidjetpackcomposepracticeprojects.store.util.EventBus
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    private val viewModal by viewModels<ViewModal>()

    @SuppressLint("ShowToast", "UnusedMaterial3ScaffoldPaddingParameter")
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

                    val navController = rememberNavController()
                    var selectedItem by rememberSaveable {
                        mutableStateOf("home")
                    }
                    Scaffold(
                        bottomBar = {
                            NavigationBar(

                            ) {

                                NavigationBarItem(
                                    selected = selectedItem == "home",
                                    onClick = {
                                        selectedItem = "home"
                                        navController.navigate(Screen.SplitifyHomeScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.home),
                                            contentDescription = null,
                                            modifier = Modifier.size(35.dp).padding(4.dp)
                                        )
                                    })

                                NavigationBarItem(
                                    selected = selectedItem == "history",
                                    onClick = {
                                        selectedItem = "history"
                                        navController.navigate(Screen.SplitifyHistoryScreen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.historry),
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
                }
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