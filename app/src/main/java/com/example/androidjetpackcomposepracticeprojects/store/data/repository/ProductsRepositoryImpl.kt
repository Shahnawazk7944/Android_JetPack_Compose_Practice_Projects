package com.example.androidjetpackcomposepracticeprojects.store.data.repository

import arrow.core.Either
import com.example.androidjetpackcomposepracticeprojects.store.data.mapper.toNetworkError
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductApi
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductDetailApi
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.NetworkError
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductDetailsRepository
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
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
    override suspend fun getProductDetails(productId: String): Either<NetworkError, Product> {
        delay(5000)
        return try {
            val product = withContext(Dispatchers.IO) {
                async { productDetailApi.getProductDetails(productId = productId) }.await()
            }
            return Either.Right(product)
        } catch (e: Exception) {
            Either.Left(e.toNetworkError())
        }


    }

}