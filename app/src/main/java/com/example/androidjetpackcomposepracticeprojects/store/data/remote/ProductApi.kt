package com.example.androidjetpackcomposepracticeprojects.store.data.remote

import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
interface ProductDetailApi {
    @GET("products/{productId}")
    suspend fun getProductDetails(@Path(value = "productId") productId: String): Product
}