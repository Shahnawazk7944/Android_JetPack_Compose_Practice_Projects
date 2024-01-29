package com.example.androidjetpackcomposepracticeprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.androidjetpackcomposepracticeprojects.data.local.NoteDatabase
import com.example.androidjetpackcomposepracticeprojects.presentation.models.ViewModal
import com.example.androidjetpackcomposepracticeprojects.presentation.noteUI.AddNotesScreen
import com.example.androidjetpackcomposepracticeprojects.presentation.noteUI.NotesScreen
import com.example.androidjetpackcomposepracticeprojects.presentation.notesModels.NotesViewModel
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AndroidJetPackComposePracticeProjectsTheme
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_31
import com.example.androidjetpackcomposepracticeprojects.ui.theme.gradient_32

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    //private val viewModal by viewModels<ViewModal>()

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            name = "notes.db"
        ).build()
    }

    private val viewModal by viewModels<NotesViewModel>(
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state by viewModal.state.collectAsState()
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "NotesScreen") {
                        composable(
                            route = "NotesScreen"
                        ) {
                            NotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModal::onEvent
                            )
                        }
                        composable(
                            route = "AddNotesScreen"

                        ) {
                            AddNotesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModal::onEvent
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