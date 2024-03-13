package com.example.androidjetpackcomposepracticeprojects.quote.data.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.quote.data.mapper.toQuotesNetworkError
import com.example.androidjetpackcomposepracticeprojects.quote.data.remote.QuotesApi
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.Quotes
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.QuotesApiNetworkError
import com.example.androidjetpackcomposepracticeprojects.quote.domain.repository.QuotesRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val quotesApi: QuotesApi
) : QuotesRepository {
    override suspend fun getQuotes(): Either<QuotesApiNetworkError, List<Quotes>> {
        delay(3000)
        return Either.catch {
            quotesApi.getQuotes()
        }.mapLeft { it.toQuotesNetworkError() }
    }
}