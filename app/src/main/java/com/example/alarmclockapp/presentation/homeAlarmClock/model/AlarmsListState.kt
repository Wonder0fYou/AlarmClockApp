package com.example.alarmclockapp.presentation.homeAlarmClock.model

import com.example.alarmclockapp.domain.AlarmClockItem

data class AlarmsListState(
    val listItems: List<AlarmClockItem> = emptyList()
)
