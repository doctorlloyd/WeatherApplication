package com.lloyd.weatherapplication.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lloyd.weatherapplication.data.network.domain.Coordinates
import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import com.lloyd.weatherapplication.data.network.domain.Main
import com.lloyd.weatherapplication.data.network.domain.Weather

@Entity(tableName = "location")
data class LocationWeatherEntity(
    @PrimaryKey
    @ColumnInfo(name = "location_id")
    val id: Int?,
    val name: String?,
    val weather: List<Weather>?= listOf(),
    val coordinates: Coordinates?,
    val main: Main?
)

fun LocationWeatherEntity.asDomainModel(): LocationWeather {
    return LocationWeather(
        coordinates = coordinates,
        weather = weather,
        main = main,
        id = id,
        name = name
    )
}