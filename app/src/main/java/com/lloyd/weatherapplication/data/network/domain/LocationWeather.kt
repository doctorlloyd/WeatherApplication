package com.lloyd.weatherapplication.data.network.domain

data class LocationWeather(
    val id: Int?,
    val name: String?,
    val weather: List<Weather>?,
    val coordinates: Coordinates?,
    val main: Main?
)