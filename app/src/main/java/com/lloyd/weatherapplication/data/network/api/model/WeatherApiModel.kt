package com.lloyd.weatherapplication.data.network.api.model

import com.lloyd.weatherapplication.data.database.LocationWeatherEntity
import com.lloyd.weatherapplication.data.database.WeatherEntity
import com.lloyd.weatherapplication.data.network.domain.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherApiModel(
    @Json(name = "coord") val coordinates: Coordinates,
    @Json(name = "weather") val weather: List<Weather>,
    @Json(name = "base") val base: String,
    @Json(name = "main") val main: Main,
    @Json(name = "visibility") val visibility: Int,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "clouds") val clouds: Clouds,
    @Json(name = "dt") val dt: Int,
    @Json(name = "sys") val sys: Sys,
    @Json(name = "timezone") val timezone: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "cod") val cod:Int
)

fun List<Weather>.asDatabaseModel(): List<WeatherEntity> {
    return map {
        WeatherEntity(
            id = it.id,
            main = it.main,
            description = it.description,
            icon = it.icon
        )
    }
}

fun WeatherApiModel.asDatabaseModel(): LocationWeatherEntity {
    return LocationWeatherEntity(
        id = id,
        name = name,
        weather = weather,
        coordinates = coordinates,
        main = main
    )

}