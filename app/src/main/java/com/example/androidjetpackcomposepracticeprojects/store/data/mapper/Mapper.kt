package com.example.androidjetpackcomposepracticeprojects.store.data.mapper

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.ApiError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.NetworkError
import java.io.IOException

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun Throwable.toNetworkError(): NetworkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}