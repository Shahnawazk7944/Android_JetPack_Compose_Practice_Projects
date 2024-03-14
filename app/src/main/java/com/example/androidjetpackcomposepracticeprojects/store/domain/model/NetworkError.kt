package com.example.androidjetpackcomposepracticeprojects.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)
enum class ApiError(val message:String){
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}