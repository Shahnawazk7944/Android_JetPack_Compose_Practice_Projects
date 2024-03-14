package com.example.androidjetpackcomposepracticeprojects.store.di

import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductApi
import com.example.androidjetpackcomposepracticeprojects.store.data.remote.ProductDetailApi
import com.example.androidjetpackcomposepracticeprojects.store.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideProductApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)

    }
    @Singleton
    @Provides
    fun provideProductDetailApi(): ProductDetailApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductDetailApi::class.java)

    }



}