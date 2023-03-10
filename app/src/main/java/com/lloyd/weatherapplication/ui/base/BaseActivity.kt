package com.lloyd.weatherapplication.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.lloyd.weatherapplication.data.models.LocationWeather


abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitViewBinding()
            ObserveViewModel()
        }

    }

    @Composable
    abstract fun ObserveViewModel()
    @Composable
    abstract fun InitViewBinding()


    abstract fun showLoadingView()
    abstract fun showDataView(b: Boolean)
    abstract fun bindWeatherData(locationWeather: LocationWeather)
}
