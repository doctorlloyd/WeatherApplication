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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
    @Composable
    abstract fun ObserveViewModel()
    @Composable
    protected abstract fun InitViewBinding()


    abstract fun showLoadingView()
    abstract fun showDataView(b: Boolean)
    abstract fun bindListData(locationWeather: LocationWeather)
}
