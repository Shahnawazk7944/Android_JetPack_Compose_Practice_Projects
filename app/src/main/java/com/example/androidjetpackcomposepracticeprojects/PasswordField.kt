package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordField() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val maxChar = 12

    val icon = if (passwordVisible) {
        painterResource(id = R.drawable.password_visible, )
    } else {
        painterResource(id = R.drawable.password_hidden)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
            if (it.length <= maxChar) {
                password = it
            }
        },
        placeholder = { Text(text = "Password") },
        label = { Text(text = "Password")},
        trailingIcon = {
            IconButton(onClick = {passwordVisible = !passwordVisible}) {
            Icon(painter = icon, contentDescription =null , modifier = Modifier.size(24.dp),tint = Color.Unspecified)
            }

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )

}