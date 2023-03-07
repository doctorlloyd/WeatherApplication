package com.lloyd.weatherapplication.data.remote

import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.models.LocationWeather


internal interface RemoteDataSource {
    suspend fun requestWeather(): Resource<LocationWeather>
}
