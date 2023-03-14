package com.lloyd.weatherapplication.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lloyd.weatherapplication.ui.NoNetwork

@Composable
fun DashboardActivity(onUserClick: (String) -> Unit) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val uiState = viewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            items(uiState.list) { item ->
            }

        }
    }
}
