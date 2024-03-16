package com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Product
import com.example.androidjetpackcomposepracticeprojects.store.domain.model.Rating
import com.example.androidjetpackcomposepracticeprojects.store.domain.repository.ProductDetailsRepository
import com.example.androidjetpackcomposepracticeprojects.store.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreProductDetailsViewModel @Inject constructor(
    private val productDetailsRepository: ProductDetailsRepository
) : ViewModel() {
    private val _state =
        MutableStateFlow(ProductDetailsScreenState())
    val state = _state.asStateFlow()

    fun getProductDetails(productId: String) {

        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            Log.d("check in VM", "")

            productDetailsRepository.getProductDetails(productId = productId)
                .onRight { productDetails ->
                    _state.update {
                        it.copy(
                            productDetails = productDetails
                        )
                    }
                }
                .onLeft { error ->
                    _state.update {
                        it.copy(
                            error = error.error.message
                        )
                    }
                    sendEvent(event = Event.Toast(error.error.message))
                }
            Log.d("check in VM", "${state.value.productDetails?.category}")

            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}

data class ProductDetailsScreenState(
    val isLoading: Boolean = false,
    val productDetails: Product =
        Product(
                id = 0,
                title = "null",
                description = "null",
                price = 00.00,
                category = "null",
                image = "null",
                rating = Rating(
                    rate = 0.0,
                    count = 0
                )
            )
        ,
    val error: String? = null
)
