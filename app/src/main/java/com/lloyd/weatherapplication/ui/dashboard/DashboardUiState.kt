package com.lloyd.weatherapplication.ui.dashboard

import com.lloyd.weatherapplication.data.database.LocationWeatherEntity

data class DashboardUiState(
    val list: List<LocationWeatherEntity> = listOf(), val offline: Boolean = false
)