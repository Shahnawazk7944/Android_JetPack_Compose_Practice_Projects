package com.example.androidjetpackcomposepracticeprojects.presentation.NotesModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.androidjetpackcomposepracticeprojects.data.local.Note
import kotlinx.coroutines.flow.MutableStateFlow

data class NoteState(
    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf("")

)
