package com.lloyd.weatherapplication.utils


const val NO_INTERNET_CONNECTION = "No network Connection!!"
const val SERVER_SIDE_ERROR ="Server side error"
const val API_CALL_LIMIT = "API calls exceeded"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val WEATHER_ITEM_KEY = "WEATHER_ITEM_KEY"
const val API_KEY = "a0275f623914e5be09d2659de218d877"

enum class AppConstants(val type:Int){
    NULL_INDEX(-1),
    NETWORK_ERROR(-2)
}