package com.lloyd.weatherapplication.data.remote

import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.network.domain.LocationWeather

internal interface RemoteDataSource {
    suspend fun requestWeather(): Resource<LocationWeather>
    suspend fun requestWeeklyWeather(): Resource<List<LocationWeather>>

}
