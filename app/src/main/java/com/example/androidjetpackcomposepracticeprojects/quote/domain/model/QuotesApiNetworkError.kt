package com.example.androidjetpackcomposepracticeprojects.quote.domain.model

data class QuotesApiNetworkError(
    val error: QuotesApiError,
    val t: Throwable? = null
)
enum class QuotesApiError(val message:String){
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}