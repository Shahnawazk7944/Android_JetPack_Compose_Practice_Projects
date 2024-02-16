package com.example.androidjetpackcomposepracticeprojects.store.di

import com.example.androidjetpackcomposepracticeprojects.store.data.repository.ProductsRepositoryImpl
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductsRepository
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
    abstract fun bindProductRepository(impl: ProductsRepositoryImpl):ProductsRepository
}