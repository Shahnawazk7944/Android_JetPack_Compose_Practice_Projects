package com.example.androidjetpackcomposepracticeprojects.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun UpsertNote(note: Note)

    @Delete
    suspend fun DeleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNoteOrderdByDateAdded(): Flow<List<Note>>

    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNoteOrderByTitle(): Flow<List<Note>>
}