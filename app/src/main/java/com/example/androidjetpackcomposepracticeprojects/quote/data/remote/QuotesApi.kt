package com.example.androidjetpackcomposepracticeprojects.quote.data.remote

import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import retrofit2.http.GET

interface QuotesApi {
    @GET("api/quotes")
    suspend fun getQuotes(): List<Quotes>
}