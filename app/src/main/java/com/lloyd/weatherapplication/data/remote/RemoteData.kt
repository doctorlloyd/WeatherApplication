package com.lloyd.weatherapplication.data.remote

import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.error.NETWORK_ERROR
import com.lloyd.weatherapplication.data.error.NO_INTERNET_CONNECTION
import com.lloyd.weatherapplication.data.network.api.WeatherApi
import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import com.lloyd.weatherapplication.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {
    override suspend fun requestWeather(): Resource<LocationWeather> {
        val weatherService = serviceGenerator.createService(WeatherApi::class.java)
        return when (val response = processCall(weatherService::fetchWeather)) {
            is LocationWeather -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun requestWeeklyWeather(): Resource<List<LocationWeather>> {
        TODO("Not yet implemented")
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
