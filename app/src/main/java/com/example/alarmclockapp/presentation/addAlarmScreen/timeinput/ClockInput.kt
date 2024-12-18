package com.example.alarmclockapp.presentation.addAlarmScreen.timeinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddState
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClockInput(
    paddingValues: PaddingValues = PaddingValues(16.dp),
    onAction: (AlarmAddAction) -> Unit,
    addAlarmState: AlarmAddState
) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true
    )
    Column (
        modifier = Modifier
            .padding(paddingValues)
            .imePadding()
            .fillMaxWidth(),
    ) {
        Surface (
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.surface
        ) {
            TimeInput(
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.primary,
                    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
        val selectedHour = timePickerState.hour
        val selectedMinute = timePickerState.minute
        val time = selectedHour * 60 + selectedMinute
        onAction(AlarmAddAction.InputMinutesFromStartOfDay(time))

        Melody(
            onMelodyClick = {
                onAction(AlarmAddAction.ChangeOpenBottomSheetMelody(!addAlarmState.openBottomSheetMelody))
            },
            openBottomSheetMelody = addAlarmState.openBottomSheetMelody,
            onAction = onAction
        )

        Replay(
            onReplayClick = {
                onAction(AlarmAddAction.ChangeOpenBottomSheetReplay(!addAlarmState.openBottomSheetReplay))
            },
            openBottomSheetReplay = addAlarmState.openBottomSheetReplay,
            onAction = onAction,
            selectedDays = addAlarmState.dayOfTheWeek
        )

        Vibration(
            onVibrateClick = { onAction(AlarmAddAction.ChangeSwitchVibration(!addAlarmState.switchVibration))},
            switchVibration = addAlarmState.switchVibration,
            onAction = onAction
        )

        DeleteAfterUse(
            onDeleteAfterUseClick = {
                onAction(AlarmAddAction.ChangeSwitchDeleteAfterUse(!addAlarmState.switchDeleteAfterUse))
            },
            switchDeleteAfterUse = addAlarmState.switchDeleteAfterUse,
            onAction = onAction
        )

        Description(
            onDescriptionClick = {
                onAction(AlarmAddAction.ChangeOpenDialogDescription(!addAlarmState.openDialogDescription))
            },
            openDialogDescription = addAlarmState.openDialogDescription,
            onAction = onAction,
            addAlarmState = addAlarmState
        )
    }
}