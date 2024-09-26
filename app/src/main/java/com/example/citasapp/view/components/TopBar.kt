package com.example.citasapp.view.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    text:String,
    scrollBehavior: TopAppBarScrollBehavior,
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text)
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "" // Add a valid content description
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "" // Add a valid content description
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}