package com.example.alarmclockapp.presentation

sealed class Screen (
    val route: String
) {
    data object AlarmClock: Screen(
        route = "alarmClockScreen"
    )
    data object AddAlarmClock: Screen(
        route = "addAlarmClockScreen"
    )
}