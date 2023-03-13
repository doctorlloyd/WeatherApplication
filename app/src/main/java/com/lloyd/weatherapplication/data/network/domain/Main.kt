package com.lloyd.weatherapplication.data.network.domain

data class Main(
    val temperature: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val ground_level: Int
)