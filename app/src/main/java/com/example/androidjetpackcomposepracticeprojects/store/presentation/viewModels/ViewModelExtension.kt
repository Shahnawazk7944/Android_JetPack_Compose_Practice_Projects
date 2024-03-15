package com.example.androidjetpackcomposepracticeprojects.store.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcomposepracticeprojects.store.util.EventBus
import kotlinx.coroutines.launch

fun  ViewModel.sendEvent(event: Any){
    viewModelScope.launch{
        EventBus.sendEvent(event)
    }
}