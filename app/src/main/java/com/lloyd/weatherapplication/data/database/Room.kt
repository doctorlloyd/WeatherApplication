package com.lloyd.weatherapplication.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface Room {
    @Query("select * from WeatherEntity WHERE location LIKE :location")
    fun getWeather(location: String): Flow<List<WeatherEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weatherEntityList: List<WeatherEntity>)

    @Query("select * from LocationWeatherEntity")
    fun getLocationWeather(): Flow<List<LocationWeatherEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationWeather(locationWeatherEntity: LocationWeatherEntity)

}

@Database(entities = [WeatherEntity::class, LocationWeatherEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val room: Room
}