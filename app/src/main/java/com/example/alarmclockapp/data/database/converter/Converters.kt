package com.example.alarmclockapp.data.database.converter

import androidx.room.TypeConverter
import com.example.alarmclockapp.domain.DayOfWeek

class Converters {

    @TypeConverter
    fun fromDayOfWeek(dayOfWeek: Set<DayOfWeek>): String {
        return dayOfWeek.joinToString(",") { it.name }
    }

    @TypeConverter
    fun toDayOfWeek(dayOfWeek: String): Set<DayOfWeek> {
        return dayOfWeek.split(",").map { DayOfWeek.valueOf(it) }.toSet()
    }
}