package com.lloyd.weatherapplication.data.database

import androidx.room.*
import com.lloyd.weatherapplication.data.network.domain.LocationWeather
import kotlinx.coroutines.flow.Flow

@Dao
interface Room {
    @Query("select * from weather WHERE weather_id LIKE :id")
    fun getWeather(id: String): Flow<List<WeatherEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weatherEntityList: List<WeatherEntity>)

    @Query("select * from location")
    fun getLocationWeather(): Flow<List<LocationWeatherEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationWeather(locationWeather: LocationWeatherEntity)

}

@Database(entities = [WeatherEntity::class, LocationWeatherEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val room: Room
}