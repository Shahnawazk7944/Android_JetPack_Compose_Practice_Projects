package com.example.androidjetpackcomposepracticeprojects


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.androidjetpackcomposepracticeprojects.data.local.NoteDatabase
import com.example.androidjetpackcomposepracticeprojects.presentation.noteUI.AddNotesScreen
import com.example.androidjetpackcomposepracticeprojects.presentation.noteUI.NotesScreen
import com.example.androidjetpackcomposepracticeprojects.presentation.notesModels.NotesViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    //private val viewModal by viewModels<ViewModal>()

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "notes.db"
        ).build()
    }

    private val viewModel by viewModels<NotesViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NotesViewModel(database.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetPackComposePracticeProjectsTheme {

                // ------------------ViewModel With NoteApp Practice code-------------
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {

                    val state by viewModel.state.collectAsState()
                    navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "NotesScreen") {
                        composable(
                            route = "NotesScreen"
                        ) {
                            NotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                        composable(
                            route = "AddNotesScreen"

                        ) {
                            AddNotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                    }


                    // ------------------ViewModel Practice code-------------
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJetPackComposePracticeProjectsTheme {

    }
}