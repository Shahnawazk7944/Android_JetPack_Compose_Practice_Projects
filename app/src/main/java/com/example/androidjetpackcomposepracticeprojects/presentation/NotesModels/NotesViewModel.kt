package com.example.androidjetpackcomposepracticeprojects.presentation.NotesModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcomposepracticeprojects.data.local.NoteDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel(
    private val dao: NoteDao
) : ViewModel() {
    private val isSortedByDateAdded = MutableStateFlow(true)
    private var notes = isSortedByDateAdded.flatMapLatest { sort ->
        if(sort){
            dao.getNoteOrderdByDateAdded()
        }else{
            dao.getNoteOrderByTitle()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    dao.DeleteNote(event.note)
                }

            }

            is NoteEvent.SaveNote -> {

            }
            NoteEvent.SortNotes -> {
                isSortedByDateAdded.value = ! isSortedByDateAdded.value
            }
        }
    }
}