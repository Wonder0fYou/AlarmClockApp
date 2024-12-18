package com.example.alarmclockapp.presentation.addAlarmScreen.model

import com.example.alarmclockapp.domain.DayOfWeek

data class AlarmAddState(
    val description: String = "",
    val isEnabled: Boolean = true,
    val minutesFromStartOfDay: Int = 0,
    val vibration: Boolean = false,
    val deleteAfterUse: Boolean = false,
    val song: String = "",
    val dayOfTheWeek: Set<DayOfWeek> = setOf(DayOfWeek.MONDAY),
    //Clock Input
    val openDialogDescription: Boolean = false,
    val openBottomSheetMelody: Boolean = false,
    val switchDeleteAfterUse: Boolean = false,
    val switchVibration: Boolean = false,
    val openBottomSheetReplay: Boolean = false,
)