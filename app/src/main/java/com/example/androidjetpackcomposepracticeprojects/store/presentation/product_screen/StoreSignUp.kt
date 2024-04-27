package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.store.NavGraphs.AuthScreen
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.PrimaryButton
import com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components.StoreTopAppBar
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBackground
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBlack
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryGreen
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FSecondaryBackgroundWhite
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins

@Composable
fun StoreSignUp(
    authNavController: NavHostController,
) {
    StoreSignUpContent(authNavController = authNavController)
}


@Composable
fun StoreSignUpContent(
    authNavController: NavHostController,
) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val icon = if (passwordVisible) {
        painterResource(id = R.drawable.visible)
    } else {
        painterResource(id = R.drawable.invisible)
    }
    Scaffold(
        containerColor = FPrimaryBackground,
        topBar = {
            StoreTopAppBar(
                onClick = { },
                title = {},
                action = {},
                appBarLeadingIcon = painterResource(R.drawable.back))
        },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it).padding(10.dp).padding(horizontal = 15.dp),
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Create Account",
                fontFamily = poppins,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = FPrimaryBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 0.dp, start = 10.dp)
            )
            Text(
                "Let's Create Account Together",
                fontFamily = poppins,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 40.dp, start = 10.dp)
            )
            Text(
                "Full Name",
                fontFamily = poppins,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = FPrimaryBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 0.dp, start = 5.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                textStyle = TextStyle(
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    //color = AppTheme.colors.secondary
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Enter your Name",
                        fontFamily = poppins,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        //color = AppTheme.colors.onError
                    )
                },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = FPrimaryGreen,
                    unfocusedTextColor = FPrimaryBlack,
                    focusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = FPrimaryGreen,
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray ,
                    focusedLeadingIconColor = FPrimaryGreen,
                    unfocusedLeadingIconColor = Color.Gray,
                ),
//                leadingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.user),
//                        contentDescription = "email icon",
//                        modifier = Modifier.size(25.dp)
//                    )
//                },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Email",
                fontFamily = poppins,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = FPrimaryBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 0.dp, start = 5.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                textStyle = TextStyle(
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    //color = AppTheme.colors.secondary
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Enter your Email",
                        fontFamily = poppins,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        //color = AppTheme.colors.onError
                    )
                },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = FPrimaryGreen,
                    unfocusedTextColor = FPrimaryBlack,
                    focusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = FPrimaryGreen,
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray ,
                    focusedLeadingIconColor = FPrimaryGreen,
                    unfocusedLeadingIconColor = Color.Gray,
                ),
//                leadingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.email),
//                        contentDescription = "email icon",
//                        modifier = Modifier.size(25.dp)
//                    )
//                },
                modifier = Modifier.fillMaxWidth(),
            )


            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Password",
                fontFamily = poppins,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = FPrimaryBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 0.dp, start = 5.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                textStyle = TextStyle(
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    //color = AppTheme.colors.secondary
                ),

                placeholder = {
                    Text(
                        text = "Enter your Password",
                        fontFamily = poppins,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        //color = AppTheme.colors.onError
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                singleLine = true,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = FPrimaryGreen,
                    unfocusedTextColor = FPrimaryBlack,
                    focusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedContainerColor = FSecondaryBackgroundWhite,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = FPrimaryGreen,
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray ,
                    focusedLeadingIconColor = FPrimaryGreen,
                    unfocusedLeadingIconColor = Color.Gray,
                    focusedTrailingIconColor = FPrimaryGreen,
                    unfocusedTrailingIconColor = Color.Gray
                ),
//                leadingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.password),
//                        contentDescription = "email icon",
//                        modifier = Modifier.size(25.dp)
//                    )
//                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = "email icon",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
            )



            PrimaryButton(
                onClick = { authNavController.navigate(AuthScreen.StoreHomeScreen.route) },
                eventText = "Click to Home Screen",
                leadingIconComposable = {},
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}