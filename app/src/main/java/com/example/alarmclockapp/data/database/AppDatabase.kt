package com.example.alarmclockapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alarmclockapp.data.database.converter.Converters
import com.example.alarmclockapp.data.database.dao.AlarmDao
import com.example.alarmclockapp.data.database.entity.AlarmClockItemEntity

/**
 * The Room database class for the application.
 * @property AlarmClockItemEntity The Data Access Object (DAO) for accessing [AlarmClockItemEntity] in the database.
 */
@Database(
    entities = [
        AlarmClockItemEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
}