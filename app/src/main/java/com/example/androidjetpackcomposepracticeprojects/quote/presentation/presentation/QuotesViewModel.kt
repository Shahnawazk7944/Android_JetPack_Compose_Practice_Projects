package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcomposepracticeprojects.quote.domain.repository.QuotesRepository
import com.example.androidjetpackcomposepracticeprojects.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val quotesRepository: QuotesRepository
) : ViewModel() {
    private val _state =
        MutableStateFlow(QuotesScreenState())
    val state = _state.asStateFlow()

    init {
        getQuotes()
    }

    fun getQuotes() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            quotesRepository.getQuotes()
                .onRight { quotes ->
                    _state.update {
                        it.copy(
                            quotes = quotes
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
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }

}