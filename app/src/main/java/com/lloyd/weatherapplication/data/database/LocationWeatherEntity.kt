package com.lloyd.weatherapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lloyd.weatherapplication.data.network.domain.*

@Entity
data class LocationWeatherEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val weather: List<Weather>,
    val coordinates: Coordinates,
    val main: Main
)

fun LocationWeatherEntity.asDomainModel(): LocationWeather {
    return LocationWeather(
        coordinates = coordinates,
        weather = weather,
        main = main,
        id= id,
        name= name
    )
}