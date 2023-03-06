package com.lloyd.weatherapplication.utils


const val NO_INTERNET_CONNECTION = "No network Connection!!"
const val SERVER_SIDE_ERROR ="Server side error"
const val API_CALL_LIMIT = "API calls exceeded"

enum class AppConstants(val type:Int){
    NULL_INDEX(-1),
    NETWORK_ERROR(-2)
}