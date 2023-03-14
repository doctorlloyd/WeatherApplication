package com.lloyd.weatherapplication.data.network.api

import com.lloyd.weatherapplication.API_KEY
import com.lloyd.weatherapplication.data.database.LocationWeatherEntity
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather?q=Pretoria,Gauteng&appid=$API_KEY")
    suspend fun fetchWeather(): Response<LocationWeatherEntity>
}