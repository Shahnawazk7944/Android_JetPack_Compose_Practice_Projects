package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation

import android.graphics.Bitmap
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import kotlinx.coroutines.flow.MutableStateFlow


data class QuotesScreenState(
    val isLoading : Boolean = false,
    val quotes: List<Quotes> = emptyList(),
    val error: String? = null,
//    var bitmap: Bitmap? = null,
//    var imageUri: String = "",
//    //var imageUri: MutableStateFlow<String> = MutableStateFlow(""),
)