package com.example.androidjetpackcomposepracticeprojects.store.data.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.store.data.mapper.toNetworkError
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductApi
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductDetailApi
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.NetworkError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductDetailsRepository
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductsRepository {
    override suspend fun getProduct(): Either<NetworkError, List<Product>> {
        // delay(3000)
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }

}

class ProductDetailsRepositoryImpl @Inject constructor(
    private val productDetailApi: ProductDetailApi
) : ProductDetailsRepository {
    override suspend fun getProductDetails(): Either<NetworkError, Product> {
        // delay(3000)
        return Either.catch {
            productDetailApi.getProductDetails()
        }.mapLeft { it.toNetworkError() }

    }

}