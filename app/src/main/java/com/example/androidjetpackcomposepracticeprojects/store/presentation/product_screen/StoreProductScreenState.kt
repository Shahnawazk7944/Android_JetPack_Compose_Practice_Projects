package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product


data class ProductScreenState(
    val isLoading : Boolean = false,
    val product: List<Product> = emptyList(),
    val error: String? = null
)