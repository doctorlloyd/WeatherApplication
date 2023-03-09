package com.lloyd.weatherapplication.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.LiveData
import com.lloyd.weatherapplication.data.Resource
import com.lloyd.weatherapplication.data.models.LocationWeather
import com.lloyd.weatherapplication.ui.base.BaseActivity
import com.lloyd.weatherapplication.utils.SingleEvent
import com.lloyd.weatherapplication.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@AndroidEntryPoint
open class DashboardActivity : BaseActivity() {
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    override fun showDataView(b: Boolean) {
        if(b){
            //Todo show information
        }
    }

    override fun showLoadingView() {
        //Todo show loader
    }

    override fun bindListData(locationWeather: LocationWeather) {
        //Todo show UI and populated data
    }

    private fun handleWeatherList(status: Resource<LocationWeather>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListData(locationWeather = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { dashboardViewModel.showToastMessage(it) }
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun ObserveSnackBarMessages(event: LiveData<SingleEvent<Any>>) {

        val scaffoldState: ScaffoldState = rememberScaffoldState()
        val coroutineScope: CoroutineScope = rememberCoroutineScope()

        Scaffold(scaffoldState = scaffoldState) {
            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "This is your message",
                        actionLabel = event.toString()
                    )
                }
            }) {
                //TODO action needed when snackBar button is clicked
                Text(text = "Click me!")
            }
        }
    }

    @Composable
    private fun ObserveToast(event: LiveData<SingleEvent<Any>>) {

    }

    @Composable
    override fun ObserveViewModel() {
        observe(dashboardViewModel.weatherLiveData, ::handleWeatherList)
//        observeEvent(dashboardViewModel.openWeatherDetails, ::navigateToDetailsScreen)
        ObserveSnackBarMessages(dashboardViewModel.showSnackBar)
        ObserveToast(dashboardViewModel.showToast)
    }

    @Composable
    override fun InitViewBinding() {
        TODO("Not yet implemented")
    }
}