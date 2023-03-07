package com.lloyd.weatherapplication.data.remote.service

import com.lloyd.weatherapplication.data.models.LocationWeather
import com.lloyd.weatherapplication.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {
    @GET("weather?q=Pretoria,Gauteng&appid=$API_KEY")
    suspend fun fetchWeather(): Response<LocationWeather>

    @GET("weather?q=Pretoria,Gauteng&appid=$API_KEY")
    suspend fun getWeather(): Response<LocationWeather>
}