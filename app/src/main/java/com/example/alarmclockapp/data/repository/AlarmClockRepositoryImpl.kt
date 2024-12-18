package com.example.alarmclockapp.data.repository

import com.example.alarmclockapp.data.database.dao.AlarmDao
import com.example.alarmclockapp.data.utils.toDomain
import com.example.alarmclockapp.data.utils.toEntity
import com.example.alarmclockapp.domain.AlarmClockItem
import com.example.alarmclockapp.domain.AlarmClockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlarmClockRepositoryImpl @Inject constructor(
    private val alarmDao: AlarmDao,
): AlarmClockRepository {

    override fun getAllAlarms(): Flow<List<AlarmClockItem>> {
        return alarmDao.getAllAlarms().map { list ->
            list.map { alarmEntity ->
                alarmEntity.toDomain()
            }
        }
    }

    override suspend fun getAlarm(alarmId: Int): AlarmClockItem {
        val alarmEntity = alarmDao.getAlarmById(alarmId)
        return alarmEntity.toDomain()
    }

    override suspend fun deleteAlarm(alarmId: Int) {
        alarmDao.deleteAlarm(alarmId)
    }

    override suspend fun insertAlarm(alarmClock: AlarmClockItem) {
        val alarmEntity = alarmClock.toEntity()
        alarmDao.insertAlarm(alarmEntity)
    }

    override suspend fun updateAlarm(alarmClock: AlarmClockItem) {
        val alarmEntity = alarmClock.toEntity()
        alarmDao.updateAlarm(alarmEntity)
    }
}