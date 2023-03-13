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

fun List<WeatherEntity>.asDomainModel(): List<Weather> {
    return map{
        Weather(
            id = it.id,
            main = it.main,
            description = it.description,
            icon = it.icon
        )
    }
}