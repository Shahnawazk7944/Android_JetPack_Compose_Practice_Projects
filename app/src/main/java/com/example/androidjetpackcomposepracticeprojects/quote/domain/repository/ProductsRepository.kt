package com.example.androidjetpackcomposepracticeprojects.quote.domain.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.QuotesApiNetworkError

interface QuotesRepository {
    suspend fun getQuotes():Either<QuotesApiNetworkError, List<Quotes>>
}