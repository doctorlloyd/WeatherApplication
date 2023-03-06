package com.lloyd.weatherapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lloyd.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApplicationTheme {
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .clickable(onClick = {
                            Toast
                                .makeText(baseContext, "You clicked me", Toast.LENGTH_SHORT)
                                .show()
                        })
                        .clip(shape = RoundedCornerShape(16.dp)),
                ) {
                    body()
                    subBody()
                }
            }
        }
    }


    @Composable
    private fun subBody() {
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
    private fun body() {

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
    private fun appBar() {
        TODO("Not yet implemented")
    }
}