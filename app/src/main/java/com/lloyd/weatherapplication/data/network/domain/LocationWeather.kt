package com.lloyd.weatherapplication.data.network.domain

data class LocationWeather(
    val id: Int? = null,
    val name: String? = "",
    val weather: List<Weather>? = null,
    val coordinates: Coordinates? = null,
    val main: Main? = null
)