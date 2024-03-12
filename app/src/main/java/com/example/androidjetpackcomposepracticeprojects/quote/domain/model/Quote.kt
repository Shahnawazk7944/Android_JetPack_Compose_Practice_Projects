package com.example.androidjetpackcomposepracticeprojects.quote.domain.model

data class Quotes(
    val quote: Quote
)

data class Quote(
    val id: Int,
    val quote: String,
    val author: String,
)