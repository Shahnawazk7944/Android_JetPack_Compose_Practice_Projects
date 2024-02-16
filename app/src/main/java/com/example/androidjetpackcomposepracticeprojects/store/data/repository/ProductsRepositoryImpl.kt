package com.example.androidjetpackcomposepracticeprojects.store.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.store.data.mapper.toNetworkError
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductApi
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.NetworkError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductsRepository

class ProductsRepositoryImpl constructor(
    private val productApi: ProductApi
) : ProductsRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProduct(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}