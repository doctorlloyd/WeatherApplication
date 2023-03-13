package com.lloyd.weatherapplication.data.network.domain

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)