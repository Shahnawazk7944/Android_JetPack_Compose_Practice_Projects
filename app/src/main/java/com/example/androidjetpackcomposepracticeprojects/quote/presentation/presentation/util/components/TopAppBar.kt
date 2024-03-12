package com.example.androidjetpackcomposepracticeprojects.quote.presentation.presentation.util.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesTopAppBar(
    onClick: () -> Unit,
    title: @Composable () -> Unit,
    action: @Composable RowScope.() -> Unit,
    appBarLeadingIcon:Painter
) {
    TopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = appBarLeadingIcon,
                    contentDescription = "back Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(18.dp),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        actions = action
    )
}
