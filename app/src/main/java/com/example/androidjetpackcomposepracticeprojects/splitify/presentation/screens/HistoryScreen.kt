package com.example.androidjetpackcomposepracticeprojects.splitify.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.ui.theme.rubik
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SplitifyHistoyScreen(
    navController: NavHostController
) {
    var selectedTab by remember {
        mutableStateOf(0)
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
                appBarLeadingIcon = painterResource(R.drawable.back)
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            TabRow(selectedTabIndex = selectedTab, modifier = Modifier.padding(padding)) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = null) },
                    text = {
                        Text(
                            "Personal History",
                            fontFamily = ubuntu,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(imageVector = Icons.Outlined.Group, contentDescription = null) },
                    text = {
                        Text(
                            "Group History",
                            fontFamily = ubuntu,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (selectedTab == 0) {
                Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                    PersonalExpHistory(
                        expName = "Breakfast",
                        expAmount = "$ 24",
                        expDate = "20/08/2023"
                    )
                    PersonalExpHistory(
                        expName = "Dinner",
                        expAmount = "$ 24",
                        expDate = "24/02/2023"
                    )
                    PersonalExpHistory(
                        expName = "Snacks",
                        expAmount = "$ 60",
                        expDate = "06/01/2023"
                    )
                    PersonalExpHistory(
                        expName = "Vada",
                        expAmount = "$ 15",
                        expDate = "12/02/2023"
                    )
                    PersonalExpHistory(
                        expName = "Walks",
                        expAmount = "$ 45",
                        expDate = "14/07/2023"
                    )
                    PersonalExpHistory(
                        expName = "Recharge",
                        expAmount = "$ 1140",
                        expDate = "23/07/2023"
                    )
                    PersonalExpHistory(
                        expName = "Outings",
                        expAmount = "$ 80",
                        expDate = "24/09/2023"
                    )
                    PersonalExpHistory(
                        expName = "Meetups",
                        expAmount = "$ 230",
                        expDate = "20/01/2023"
                    )
                    PersonalExpHistory(
                        expName = "Randoms",
                        expAmount = "$ 720",
                        expDate = "29/06/2023"
                    )
                    PersonalExpHistory(
                        expName = "Clothes",
                        expAmount = "$ 564",
                        expDate = "16/07/2023"
                    )
                    PersonalExpHistory(
                        expName = "Shoes",
                        expAmount = "$ 54",
                        expDate = "23/02/2023"
                    )
                    PersonalExpHistory(
                        expName = "Belts",
                        expAmount = "$ 05",
                        expDate = "20/05/2023"
                    )


                }

            }
            if (selectedTab == 1) {
                Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

                    GroupExpHistory(
                        expName = "Gym Fee",
                        expAmount = "$ 12500" ,
                        expDate = "03/01/2024",
                        paidBy = "Jemi"
                    )
                    GroupExpHistory(
                        expName = "Belts",
                        expAmount = "$ 05",
                        expDate = "20/05/2023",
                        paidBy = "Frenaka"
                    )
                    GroupExpHistory(
                        expName = "Shoes",
                        expAmount = "$ 54",
                        expDate = "23/02/2023",
                        paidBy = "Yemzu"
                    )
                    GroupExpHistory(
                        expName = "Clothes",
                        expAmount = "$ 564",
                        expDate = "16/07/2023",
                        paidBy = "Aja ya"
                    )
                    GroupExpHistory(
                        expName = "Meetups",
                        expAmount = "$ 230",
                        expDate = "20/01/2023",
                        paidBy = "Whoisi"
                    )
                    GroupExpHistory(
                        expName = "Walks",
                        expAmount = "$ 45",
                        expDate = "14/07/2023",
                        paidBy = "Amiko"
                    )
                    GroupExpHistory(
                        expName = "Vada",
                        expAmount = "$ 15",
                        expDate = "12/02/2023",
                        paidBy = "Kasib"
                    )
                    GroupExpHistory(
                        expName = "Breakfast",
                        expAmount = "$ 24",
                        expDate = "20/08/2023",
                        paidBy = "Orama"
                    )
                    GroupExpHistory(
                        expName = "Enjoy",
                        expAmount = "$ 125" ,
                        expDate = "03/01/2024",
                        paidBy = "Yeska"
                    )
                    GroupExpHistory(
                        expName = "Randoms",
                        expAmount = "$ 720",
                        expDate = "29/06/2023",
                        paidBy = "Amiko"
                    )
                    GroupExpHistory(
                        expName = "Outings",
                        expAmount = "$ 80",
                        expDate = "24/09/2023",
                        paidBy = "Jesma"
                    )
                    GroupExpHistory(
                        expName = "Movies",
                        expAmount = "$ 800" ,
                        expDate = "15/09/2023",
                        paidBy = "Zekaru"
                    )


                }

            }

        }
    }
}

@Composable
fun PersonalExpHistory(
    expName: String,
    expAmount: String,
    expDate: String
) {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF42224A)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .height(80.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = expName,
                fontFamily = rubik,
                fontSize = 26.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 15.dp, top = 10.dp)
            )
            Column {
                Text(
                    text = expAmount,
                    fontFamily = rubik,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = expDate,
                    fontFamily = rubik,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun GroupExpHistory(
    expName: String,
    expAmount: String,
    expDate: String,
    paidBy: String
) {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF42224A)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .height(80.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Text(
                    text = expName,
                    fontFamily = rubik,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                    modifier = Modifier
                )
                Text(
                    text = "Paid By : $paidBy",
                    fontFamily = rubik,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                )
            }

            Column {
                Text(
                    text = expAmount,
                    fontFamily = rubik,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = expDate,
                    fontFamily = rubik,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            }
        }
    }
}