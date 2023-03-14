package com.lloyd.weatherapplication.repository

import com.lloyd.weatherapplication.data.database.AppDatabase
import com.lloyd.weatherapplication.data.database.LocationWeatherEntity
import com.lloyd.weatherapplication.data.network.api.WeatherApi
import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class DetailedWeatherRepositorySource @Inject constructor(
    private val weatherApi: WeatherApi,
    private val appDatabase: AppDatabase
) {
    var locationWeather: Flow<List<LocationWeatherEntity>> =
        appDatabase.room.getLocationWeather().map { it }

    suspend fun getLocationWeather() {
        try {
            val locationWeatherApi = weatherApi.fetchWeather()
            locationWeatherApi.body()?.let { appDatabase.room.insertLocationWeather(it) }
        } catch (
            e: java.lang.Exception
        ) {
            Timber.i(e)
        }
    }
}