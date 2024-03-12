package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation

import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes


data class QuotesScreenState(
    val isLoading : Boolean = false,
    val quotes: List<Quotes> = emptyList(),
    val error: String? = null
)