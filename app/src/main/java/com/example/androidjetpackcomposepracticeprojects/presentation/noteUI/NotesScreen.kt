package com.example.androidjetpackcomposepracticeprojects.presentation.noteUI


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidjetpackcomposepracticeprojects.presentation.notesModels.NoteEvent
import com.example.androidjetpackcomposepracticeprojects.presentation.notesModels.NoteState

@Composable
fun NotesScreen(
    state: NoteState,
    navController: NavController,
    onEvent: (NoteEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    //.fillMaxSize()
                    .height(55.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notes App",
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                IconButton(onClick = { onEvent(NoteEvent.SortNotes) }) {
                    Icon(
                        imageVector = Icons.Rounded.Sort, contentDescription = "Sort Icon",
                        modifier = Modifier.size(35.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    state.title.value = ""
                    state.description.value = ""
                    navController.navigate("AddNotesScreen")
                }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Notes")
            }
        }

    )
    { paddingValues ->

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(150.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 10.dp,

            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            //verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Log.d("check", "working")
            Log.d("check", state.notes.size.toString())
            items(state.notes.size) { index ->
                Log.d("title", state.notes[index].title)
                Log.d("descrip", state.notes[index].description)
                NoteItem(state = state, index = index, onEvent = onEvent)
            }
            Log.d("check", "not working")
        }

    }
}
