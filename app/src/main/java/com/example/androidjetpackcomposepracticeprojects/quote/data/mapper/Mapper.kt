package com.example.androidjetpackcomposepracticeprojects.quote.data.mapper

import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.QuotesApiError
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.QuotesApiNetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toQuotesNetworkError(): QuotesApiNetworkError {
    val error = when (this) {
        is IOException -> QuotesApiError.NetworkError
        is HttpException -> QuotesApiError.UnknownResponse
        else -> QuotesApiError.UnknownError
    }
    return QuotesApiNetworkError(
        error = error,
        t = this
    )
}