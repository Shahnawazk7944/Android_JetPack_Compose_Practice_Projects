package com.example.androidjetpackcomposepracticeprojects.presentation.NotesModels

import androidx.lifecycle.ViewModel
import com.example.androidjetpackcomposepracticeprojects.data.local.NoteDao

class NotesViewModel(
    private val dao: NoteDao
) : ViewModel() {

}