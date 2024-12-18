package com.example.alarmclockapp.presentation.addAlarmScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.alarmclockapp.presentation.addAlarmScreen.components.AddAlarmTopBar
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddState
import com.example.alarmclockapp.presentation.addAlarmScreen.timeinput.ClockInput

@Composable
fun AddAlarmScreen(
    onSaveClick: () -> Unit,
    onAction: (AlarmAddAction) -> Unit,
    onBackClick: () -> Unit,
    addAlarmState: AlarmAddState
) {
    Scaffold (
        topBar = {
            AddAlarmTopBar(
                onSaveClick = {onSaveClick()},
                onAction = onAction,
                onBackClick = {onBackClick()},
            )
        }
    ){ paddingValues ->
        ClockInput(
            paddingValues = paddingValues,
            onAction = onAction,
            addAlarmState = addAlarmState
        )
    }
}