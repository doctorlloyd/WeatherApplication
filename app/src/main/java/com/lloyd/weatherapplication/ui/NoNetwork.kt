package com.lloyd.weatherapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloyd.weatherapplication.NO_INTERNET_CONNECTION


@Composable
fun NoNetwork() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                imageVector = Icons.Default.NetworkCheck,
                tint = MaterialTheme.colors.primary,
                contentDescription = null
            )
            Text(
                text = NO_INTERNET_CONNECTION,
                color = MaterialTheme.colors.background
            )
        }
    }
}