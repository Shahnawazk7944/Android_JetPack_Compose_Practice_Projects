package com.example.androidjetpackcomposepracticeprojects.store.data.mapper

import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.ApiError
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.NetworkError
import java.io.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}