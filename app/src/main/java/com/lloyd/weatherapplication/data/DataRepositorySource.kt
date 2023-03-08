package com.lloyd.weatherapplication.data

import com.lloyd.weatherapplication.data.models.LocationWeather
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestWeatherByLocationName(): Flow<Resource<LocationWeather>>
}
