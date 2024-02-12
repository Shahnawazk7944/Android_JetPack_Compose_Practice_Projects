package com.example.androidjetpackcomposepracticeprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    private val viewModal by viewModels<ViewModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetPackComposePracticeProjectsTheme {
                SplashScreen()
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