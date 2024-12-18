package com.example.alarmclockapp.presentation.addAlarmScreen.model

import com.example.alarmclockapp.domain.DayOfWeek

sealed class AlarmAddAction {

    //Parameters AlarmClockItem
    data class ChangeDayOfWeek(
        val dayOfWeek: DayOfWeek,
        val isSelected: Boolean
    ) : AlarmAddAction()
    data class InputDescription(
        val description: String
    ): AlarmAddAction()
    data class InputMinutesFromStartOfDay(
        val minutesFromStartOfDay: Int
    ): AlarmAddAction()
    data class PathSong(
        val song: String
    ): AlarmAddAction()

    //ClockInput
    data class ChangeOpenDialogDescription(
        val openDialogDescription: Boolean,
        val description: String = ""
    ): AlarmAddAction()
    data class ChangeOpenBottomSheetMelody(
        val openBottomSheetMelody: Boolean
    ): AlarmAddAction()
    data class ChangeSwitchDeleteAfterUse(
        val switchDeleteAfterUse: Boolean
    ): AlarmAddAction()
    data class ChangeSwitchVibration(
        val switchVibration: Boolean
    ): AlarmAddAction()
    data class ChangeOpenBottomSheetReplay(
        val openBottomSheetReplay: Boolean
    ): AlarmAddAction()

    object AddAlarm: AlarmAddAction()
}