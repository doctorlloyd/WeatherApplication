package com.lloyd.weatherapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lloyd.weatherapplication.data.network.domain.Weather

@Entity
data class WeatherEntity constructor(
    @PrimaryKey
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

fun WeatherEntity.asDomainModel(): Weather {
    return Weather(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}