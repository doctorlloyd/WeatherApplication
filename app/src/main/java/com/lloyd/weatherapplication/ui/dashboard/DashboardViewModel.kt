package com.lloyd.weatherapplication.ui.dashboard

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lloyd.weatherapplication.data.DataRepositorySource
import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.models.LocationWeather
import com.lloyd.weatherapplication.data.models.Weather
import com.lloyd.weatherapplication.ui.base.BaseViewModel
import com.lloyd.weatherapplication.utils.SingleEvent
import com.lloyd.weatherapplication.utils.wrapEspressoIdlingResource
import kotlinx.coroutines.launch
import javax.inject.Inject

open class DashboardViewModel @Inject constructor(private val dataRepository: DataRepositorySource) : BaseViewModel(){

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val weatherLiveDataPrivate = MutableLiveData<Resource<LocationWeather>>()
    val weatherLiveData: LiveData<Resource<LocationWeather>> get() = weatherLiveDataPrivate


    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openWeatherDetailsPrivate = MutableLiveData<SingleEvent<Weather>>()
    val openWeatherDetails: MutableLiveData<SingleEvent<Weather>> get() = openWeatherDetailsPrivate

    /**
     * Error handling as UI
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar: LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate


    fun getWeather() {
        viewModelScope.launch {
            weatherLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepository.requestWeatherByLocationName().collect {
                    weatherLiveDataPrivate.value = it
                }
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

    fun openWeatherDetails(weather: Weather) {
        openWeatherDetailsPrivate.value = SingleEvent(weather)
    }
}