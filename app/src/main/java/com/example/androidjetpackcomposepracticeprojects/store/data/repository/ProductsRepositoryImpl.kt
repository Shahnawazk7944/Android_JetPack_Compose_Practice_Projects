package com.example.androidjetpackcomposepracticeprojects.store.data.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.quote.data.mapper.toNetworkError
import com.example.androidjetpackcomposepracticeprojects.quote.data.remote.ProductApi
import com.example.androidjetpackcomposepracticeprojects.quote.domain.model.NetworkError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.quote.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductsRepository {
    override suspend fun getProduct(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}