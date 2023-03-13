package com.lloyd.weatherapplication.ui.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lloyd.weatherapplication.repository.DetailedWeatherRepositorySource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val weatherRepositorySource: DetailedWeatherRepositorySource
) : ViewModel() {
    var uiState by mutableStateOf(DashboardUiState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO){

        }
    }
}