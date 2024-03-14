package com.example.androidjetpackcomposepracticeprojects.store.data.remote

import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
interface ProductDetailApi {
    @GET("products/")
    suspend fun getProductDetails(): Product
}