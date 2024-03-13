package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcomposepracticeprojects.util.EventBus
import kotlinx.coroutines.launch

fun  ViewModel.sendEvent(event: Any){
    viewModelScope.launch{
        EventBus.sendEvent(event)
    }
}