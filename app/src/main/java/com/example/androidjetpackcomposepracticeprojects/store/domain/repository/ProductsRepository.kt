package com.example.androidjetpackcomposepracticeprojects.store.domain.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.NetworkError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product

interface ProductsRepository {
    suspend fun getProduct():Either<NetworkError, List<Product>>
}