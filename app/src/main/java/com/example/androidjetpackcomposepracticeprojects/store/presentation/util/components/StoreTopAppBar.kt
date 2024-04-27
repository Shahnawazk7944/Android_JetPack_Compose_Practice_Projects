package com.example.androidjetpackcomposepracticeprojects.store.presentation.util.components

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
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBackground
import com.example.androidjetpackcomposepracticeprojects.ui.theme.FPrimaryBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreTopAppBar(
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
                    tint = FPrimaryBlack,
                    modifier = Modifier.size(25.dp),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = FPrimaryBackground
        ),
        actions = action
    )
}
