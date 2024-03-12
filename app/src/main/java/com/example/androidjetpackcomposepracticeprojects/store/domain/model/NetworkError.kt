package com.example.androidjetpackcomposepracticeprojects.store.domain.model

data class NetworkError(
    val error: com.example.androidjetpackcomposepracticeprojects.quote.domain.model.ApiError,
    val t: Throwable? = null
)
enum class ApiError(val message:String){
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}