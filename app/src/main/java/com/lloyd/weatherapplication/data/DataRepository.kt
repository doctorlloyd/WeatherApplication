package com.lloyd.weatherapplication.data

import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import com.lloyd.weatherapplication.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext) :
    DataRepositorySource {

    override suspend fun requestWeatherForLocation(): Flow<Resource<LocationWeather>> {
        return flow {
            emit(remoteRepository.requestWeather())
        }.flowOn(ioDispatcher)
    }
}
