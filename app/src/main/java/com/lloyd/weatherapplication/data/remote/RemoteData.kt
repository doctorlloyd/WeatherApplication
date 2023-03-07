package com.lloyd.weatherapplication.data.remote


import com.lloyd.weather.utils.NetworkConnectivity
import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.error.NO_INTERNET_CONNECTION
import com.lloyd.weatherapplication.data.models.LocationWeather
import com.lloyd.weatherapplication.data.remote.service.WeatherService
import com.lloyd.weatherapplication.utils.AppConstants
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {
    override suspend fun requestWeather(): Resource<LocationWeather> {
        val weatherService = serviceGenerator.createService(WeatherService::class.java)
        return when (val response = processCall(weatherService::fetchWeather)) {
            is LocationWeather -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
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
            AppConstants.NETWORK_ERROR
        }
    }
}
