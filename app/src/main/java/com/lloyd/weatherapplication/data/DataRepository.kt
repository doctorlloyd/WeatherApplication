package com.lloyd.weatherapplication.data

import com.lloyd.weatherapplication.data.models.LocationWeather
import com.lloyd.weatherapplication.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext) :
    DataRepositorySource {

    override suspend fun requestWeather(): Flow<Resource<LocationWeather>> {
        return flow {
            emit(remoteRepository.requestWeather())
        }.flowOn(ioDispatcher)
    }
}
