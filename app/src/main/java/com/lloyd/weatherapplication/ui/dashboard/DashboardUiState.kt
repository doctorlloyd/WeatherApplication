package com.lloyd.weatherapplication.ui.dashboard

import com.lloyd.weatherapplication.data.network.domain.LocationWeather

data class DashboardUiState(
    val locationWeather: LocationWeather = LocationWeather(), val offline: Boolean = false
)