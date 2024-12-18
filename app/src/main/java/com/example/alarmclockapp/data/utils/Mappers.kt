package com.example.alarmclockapp.data.utils

import com.example.alarmclockapp.data.database.entity.AlarmClockItemEntity
import com.example.alarmclockapp.domain.AlarmClockItem

fun AlarmClockItem.toEntity(): AlarmClockItemEntity {
    return AlarmClockItemEntity(
        alarmId = alarmId,
        isEnabled = isEnabled,
        minutesFromStartOfDay = minutesFromStartOfDay,
        vibration = vibration,
        description = description,
        dayOfTheWeek = dayOfTheWeek
    )
}

fun AlarmClockItemEntity.toDomain(): AlarmClockItem {
    return AlarmClockItem(
        alarmId = alarmId,
        isEnabled = isEnabled,
        minutesFromStartOfDay = minutesFromStartOfDay,
        vibration = vibration,
        description = description,
        dayOfTheWeek = dayOfTheWeek
    )
}