package com.example.androidjetpackcomposepracticeprojects.splitify.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.ui.theme.poppins
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SplitifyHomeScreen(
    navController: NavHostController
) {
    var addPersonalExp by remember {
        mutableStateOf(false)
    }
    var addGroupalExp by remember {
        mutableStateOf(false)
    }
    var personlExpName by remember {
        mutableStateOf("")
    }
    var personlExpAmount by remember {
        mutableStateOf("")
    }
    var groupExpName by remember {
        mutableStateOf("")
    }
    var groupExpAmount by remember {
        mutableStateOf("")
    }
    var groupExpPaidBy by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(
                onClick = { },
                title = {
                    Text(
                        "Expense Tracker",
                        fontFamily = ubuntu,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                action = {},
                appBarLeadingIcon = painterResource(R.drawable.menu)
            )
        },

        ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp)
            ) {
                Column {
                    Text(
                        text = "Daily",
                        fontFamily = rubik,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                    )
                    Text(
                        text = "Expenses",
                        fontFamily = rubik,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF42224A)
                ),
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .height(300.dp)

            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Total Expenses",
                        fontFamily = rubik,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray,
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                    )
                    Text(
                        text = "$ 4827",
                        fontFamily = rubik,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            AddButton(
                onClick = { addPersonalExp = true },
                eventText = "Add Personal Expenses",
                icon = R.drawable.add_user,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(10.dp))
            AddButton(
                onClick = { addGroupalExp = true },
                eventText = "Add Group Expenses",
                icon = R.drawable.add_group,
                modifier = Modifier
            )


            if (addPersonalExp) {
                AlertDialog(
                    icon = {
                        Icon(
                            painterResource(R.drawable.add_user),
                            contentDescription = "Example Icon",
                            tint = Color(0xFFFFE403),
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    title = {
                        Text(text = "Add Personal Expenses")
                    },
                    text = {
                        Column {
                            OutlinedTextField(
                                value = personlExpName,
                                onValueChange = {
                                    personlExpName = it
                                },
                                textStyle = TextStyle(
                                    fontFamily = ubuntu,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    //color = AppTheme.colors.secondary
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                ),
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Expanses Name",
                                        fontFamily = ubuntu,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        //color = AppTheme.colors.onError
                                    )
                                },
                                shape = RoundedCornerShape(15.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.primary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedPlaceholderColor = Color.White,
                                    unfocusedPlaceholderColor = Color.LightGray,
                                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_user),
                                        contentDescription = "email icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                            )


                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = personlExpAmount,
                                onValueChange = {
                                    personlExpAmount = it
                                },
                                textStyle = TextStyle(
                                    fontFamily = ubuntu,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    //color = AppTheme.colors.secondary
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                ),
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Expanses Amount",
                                        fontFamily = ubuntu,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        //color = AppTheme.colors.onError
                                    )
                                },
                                shape = RoundedCornerShape(15.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.primary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedPlaceholderColor = Color.White,
                                    unfocusedPlaceholderColor = Color.LightGray,
                                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_user),
                                        contentDescription = "email icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    },
                    onDismissRequest = {
                        addPersonalExp = false
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                addPersonalExp = false
                            }
                        ) {
                            Text("Add")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                addPersonalExp = false
                            }
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }

            if (addGroupalExp) {
                AlertDialog(
                    icon = {
                        Icon(
                            painterResource(R.drawable.add_group),
                            contentDescription = "Example Icon",
                            tint = Color(0xFFFFE403),
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    title = {
                        Text(text = "Add Group Expenses")
                    },
                    text = {
                        //Spacer(modifier = Modifier.height(60.dp))
                        Column {
                            OutlinedTextField(
                                value = groupExpName,
                                onValueChange = {
                                    groupExpName = it
                                },
                                textStyle = TextStyle(
                                    fontFamily = ubuntu,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    //color = AppTheme.colors.secondary
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                ),
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Expanses Name",
                                        fontFamily = ubuntu,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        //color = AppTheme.colors.onError
                                    )
                                },
                                shape = RoundedCornerShape(15.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.primary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedPlaceholderColor = Color.White,
                                    unfocusedPlaceholderColor = Color.LightGray,
                                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_user),
                                        contentDescription = "email icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                            )


                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = groupExpAmount,
                                onValueChange = {
                                    groupExpAmount = it
                                },
                                textStyle = TextStyle(
                                    fontFamily = ubuntu,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    //color = AppTheme.colors.secondary
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                ),
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Expanses Amount",
                                        fontFamily = ubuntu,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        //color = AppTheme.colors.onError
                                    )
                                },
                                shape = RoundedCornerShape(15.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.primary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedPlaceholderColor = Color.White,
                                    unfocusedPlaceholderColor = Color.LightGray,
                                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_user),
                                        contentDescription = "email icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = groupExpPaidBy,
                                onValueChange = {
                                    groupExpPaidBy = it
                                },
                                textStyle = TextStyle(
                                    fontFamily = ubuntu,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    //color = AppTheme.colors.secondary
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                ),
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = "Paid by...",
                                        fontFamily = ubuntu,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        //color = AppTheme.colors.onError
                                    )
                                },
                                shape = RoundedCornerShape(15.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.primary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedPlaceholderColor = Color.White,
                                    unfocusedPlaceholderColor = Color.LightGray,
                                    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_user),
                                        contentDescription = "email icon",
                                        modifier = Modifier.size(25.dp)
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                            )

                        }
                    },
                    onDismissRequest = {
                        addGroupalExp = false
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                addGroupalExp = false
                            }
                        ) {
                            Text("Add")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                addGroupalExp = false

                            }
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }

        }
    }
}

@Composable
fun AddButton(
    onClick: () -> Unit,
    eventText: String,
    icon: Int,
    iconColor: Color = Color(0xFFFFE403),
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp),
        //.clip(RoundedCornerShape(50.dp))
        shape = RoundedCornerShape(15.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 0.dp
        ),
        border = BorderStroke(1.dp, color = Color.LightGray),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            //contentColor = SecondaryFontColor
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "null",
                tint = iconColor, modifier = Modifier
                    .size(30.dp)
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                eventText,
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.weight(5f)
            )
        }
    }
}