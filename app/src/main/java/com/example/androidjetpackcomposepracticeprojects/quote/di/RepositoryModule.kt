package com.example.androidjetpackcomposepracticeprojects.quote.di

import com.example.androidjetpackcomposepracticeprojects.quote.data.repository.QuotesRepositoryImpl
import com.example.androidjetpackcomposepracticeprojects.quote.domain.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductRepository(impl: QuotesRepositoryImpl): QuotesRepository
}