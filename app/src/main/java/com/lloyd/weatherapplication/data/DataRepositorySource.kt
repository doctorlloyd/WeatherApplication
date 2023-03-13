package com.lloyd.weatherapplication.data

import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestWeatherForLocation(): Flow<Resource<LocationWeather>>
}
