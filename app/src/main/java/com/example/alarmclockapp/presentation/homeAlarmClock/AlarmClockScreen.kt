package com.example.alarmclockapp.presentation.homeAlarmClock

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.alarmclockapp.presentation.homeAlarmClock.components.AlarmContent
import com.example.alarmclockapp.presentation.homeAlarmClock.components.AlarmFloatingActionButton
import com.example.alarmclockapp.presentation.homeAlarmClock.components.TopAlarm
import com.example.alarmclockapp.presentation.homeAlarmClock.model.AlarmsListState

@Composable
fun AlarmClockScreen (
    onAddAlarmClick: () -> Unit,
    alarmsList: AlarmsListState
) {
    Scaffold (
        topBar = {
            TopAlarm(
                alarms = alarmsList
            )
        },
        floatingActionButton = {
            AlarmFloatingActionButton (
                onAddAlarmClick = onAddAlarmClick
            )
        }
    ) { paddingValues ->  
        AlarmContent(
            paddingValues = paddingValues,
            alarms = alarmsList,
        )
    }
}