package com.example.androidjetpackcomposepracticeprojects.store.presentation.product_screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.androidjetpackcomposepracticeprojects.R
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.QuotesScreenState
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.QuotesViewModel
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components.CategoryButtons
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.product_screen.components.QuotesCard
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.util.components.QuotesLoading
import com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.util.components.QuotesTopAppBar
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ubuntu

@Composable
internal fun QuotesScreen(
    viewModel: QuotesViewModel = hiltViewModel(), navController: NavHostController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    QuotesContent(state = state, navController = navController)
}

@Composable
fun QuotesContent(
    state: QuotesScreenState, navController: NavHostController
) {
    if (state.isLoading) {
        QuotesLoading(true)
    } else {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                QuotesTopAppBar(
                    title = {
                        Text(
                            "Quotes",
                            fontFamily = ubuntu,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    appBarLeadingIcon = painterResource(R.drawable.menu),
                    onClick = {

                    },
                    action = {

                    }
                )
            },

            ) { padding ->
            Column {
                Row(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CategoryButtons(
                        onClick = {},
                        text = "All",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Power",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Life",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Inspire",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Technology",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Goals",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Famous",
                        modifier = Modifier
                    )
                    CategoryButtons(
                        onClick = {},
                        text = "Random",
                        modifier = Modifier
                    )
                }
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.padding(),
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalItemSpacing = 5.dp
                ) {
                    items(state.quotes) { quotes ->
                        QuotesCard(quotes = quotes)
                    }
                }
            }
        }
    }

}