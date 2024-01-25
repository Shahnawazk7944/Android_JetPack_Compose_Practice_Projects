package com.example.androidjetpackcomposepracticeprojects.presentation.models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModal : ViewModel() {
    private var _text = MutableStateFlow("")
    var newText = _text.asStateFlow()
    fun changeText(text: String) {
        _text.value = text

    }
}