package com.example.alarmclockapp.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlarmUseCase @Inject constructor(
    private val alarmClockRepository: AlarmClockRepository,
    private val alarmService: AlarmService
) {
    suspend fun createAlarm(alarmItem: AlarmClockItem) {
        val newAlarmClock: AlarmClockItem = alarmItem
        alarmClockRepository.insertAlarm(newAlarmClock)
        alarmService.scheduleAlarmCLock(newAlarmClock)
    }

    suspend fun deactivateAlarm(id: Int) {
        val alarmItem = alarmClockRepository.getAlarm(id)
        val updateAlarm = alarmItem.copy(isEnabled = false)
        alarmClockRepository.updateAlarm(updateAlarm)
        alarmService.cancelAlarmClock(updateAlarm)
    }

    suspend fun activateAlarm(id: Int) {
        val alarmItem = alarmClockRepository.getAlarm(id)
        val updateAlarm = alarmItem.copy(isEnabled = true)
        alarmClockRepository.updateAlarm(updateAlarm)
        alarmService.scheduleAlarmCLock(updateAlarm)
    }

    suspend fun deleteAlarm(id: Int) {
        val deleteAlarm = alarmClockRepository.getAlarm(id)
        alarmClockRepository.deleteAlarm(id)
        alarmService.cancelAlarmClock(deleteAlarm)
    }

    fun getAllAlarms(): Flow<List<AlarmClockItem>> {
        return alarmClockRepository.getAllAlarms()
    }
}