package com.example.alarmclockapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.alarmclockapp.domain.DayOfWeek

@Entity(tableName = "alarms")
data class AlarmClockItemEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val alarmId: Int = 0,
    var description: String?,
    var isEnabled: Boolean,
    var minutesFromStartOfDay: Int,
    var vibration: Boolean,
    val dayOfTheWeek: Set<DayOfWeek>
)
