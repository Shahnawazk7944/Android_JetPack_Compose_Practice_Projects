package com.example.androidjetpackcomposepracticeprojects.presentation.notesModels

import com.example.androidjetpackcomposepracticeprojects.data.local.Note

sealed interface NoteEvent {
    object SortNotes : NoteEvent
    data class DeleteNote(val note: Note) : NoteEvent
    data class SaveNote(
        val title: String,
        val description: String
    ) : NoteEvent
}