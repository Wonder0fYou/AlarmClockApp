package com.example.alarmclockapp.presentation.homeAlarmClock.model

import com.example.alarmclockapp.domain.DayOfWeek

sealed class AlarmsListAction {
    data class UpdateDayOfWeek(
        var dayOfWeek: DayOfWeek
    ): AlarmsListAction()

    object UpdateAlarm: AlarmsListAction()
    object DeleteAlarm: AlarmsListAction()
}