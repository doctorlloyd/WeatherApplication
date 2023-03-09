package com.lloyd.weatherapplication.ui.dashboard.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DashboardSubBody() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "0000",
                Modifier
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
                style = typography.h1,
            )
            Row {
                Text(
                    text = "Status", Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    style = typography.h5,
                )
                Text(
                    text = "Check", Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    style = typography.h5,
                )
            }
        }
    }
}

@Composable
fun DashboardBody() {

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.wrapContentSize()
    ) {
        Column(Modifier.safeContentPadding()) {
            Text(
                text = "Location Name",
                Modifier
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
                style = typography.h4,
            )
        }
    }
}

@Composable
fun DashboardAppBar() {
    TODO("Not yet implemented")
}