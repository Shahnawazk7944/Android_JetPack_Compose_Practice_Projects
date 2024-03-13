package com.example.androidjetpackcomposepracticeprojects.quote.di

import com.example.androidjetpackcomposepracticeprojects.quote.data.remote.QuotesApi
import com.example.androidjetpackcomposepracticeprojects.util.Constant.QUOTES_URL
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
    fun provideQuotesApi(): QuotesApi {
        return Retrofit.Builder()
            .baseUrl(QUOTES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuotesApi::class.java)

    }
}