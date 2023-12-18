package com.example.androidjetpackcomposepracticeprojects

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = text, onValueChange = { newText -> text = newText },
            label = {
                Text(text = "Email")
            },
           // singleLine = true

            leadingIcon = {
                IconButton(
                    onClick = {}) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {Log.d("seee", "Email Submitted")}) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Email Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    Log.d("Email","The Email Submitted is ${text}")
                }
            )
        )
    }
}