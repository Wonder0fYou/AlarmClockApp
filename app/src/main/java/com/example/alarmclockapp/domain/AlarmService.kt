package com.example.alarmclockapp.domain

interface AlarmService {
    fun scheduleAlarmCLock(alarmItem: AlarmClockItem)
    fun cancelAlarmClock(alarmItem: AlarmClockItem)
}