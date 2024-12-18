package com.example.alarmclockapp.data.di

import com.example.alarmclockapp.data.database.dao.AlarmDao
import com.example.alarmclockapp.data.repository.AlarmClockRepositoryImpl
import com.example.alarmclockapp.domain.AlarmClockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideAlarmClockRepository(
        alarmDao: AlarmDao,
    ): AlarmClockRepository {
        return AlarmClockRepositoryImpl(alarmDao)
    }
}