package com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels

import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product


data class ProductScreenState(
    val isLoading : Boolean = false,
    val selectedCategory: String = "jewelery",
    val product: List<Product> = emptyList(),
    val error: String? = null
)

