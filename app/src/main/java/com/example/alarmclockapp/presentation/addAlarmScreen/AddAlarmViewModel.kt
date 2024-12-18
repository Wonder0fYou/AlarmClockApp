package com.example.alarmclockapp.presentation.addAlarmScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockapp.domain.AlarmClockItem
import com.example.alarmclockapp.domain.AlarmUseCase
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddAlarmViewModel @Inject constructor(
    private val alarmUseCase: AlarmUseCase
): ViewModel() {

    private val _addAlarmState = MutableStateFlow(AlarmAddState())
    val addAlarmState = _addAlarmState.asStateFlow()

    companion object {
        private val _alarmAddedEvent = MutableSharedFlow<Unit>()
        val alarmAddedEvent = _alarmAddedEvent.asSharedFlow()
    }

    fun onAction(action: AlarmAddAction) {
        when(action) {
            //Parameters AlarmClockItem
            is AlarmAddAction.InputMinutesFromStartOfDay -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        minutesFromStartOfDay = action.minutesFromStartOfDay
                    )
                }
            }
            is AlarmAddAction.ChangeDayOfWeek -> {
                val updatedDays = _addAlarmState.value.dayOfTheWeek.toMutableSet()
                if (action.isSelected) {
                    updatedDays.add(action.dayOfWeek)
                } else {
                    updatedDays.remove(action.dayOfWeek)
                }
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        dayOfTheWeek = updatedDays
                    )
                }
            }
            is AlarmAddAction.InputDescription -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        description = action.description
                    )
                }
            }
            is AlarmAddAction.PathSong -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        song = action.song
                    )
                }
            }
            //ClockInput
            is AlarmAddAction.ChangeOpenBottomSheetMelody -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        openBottomSheetMelody = action.openBottomSheetMelody
                    )
                }
            }
            is AlarmAddAction.ChangeOpenBottomSheetReplay -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        openBottomSheetReplay = action.openBottomSheetReplay
                    )
                }
            }
            is AlarmAddAction.ChangeSwitchVibration -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        switchVibration = action.switchVibration
                    )
                }
            }
            is AlarmAddAction.ChangeSwitchDeleteAfterUse -> {
                _addAlarmState.update {
                    addAlarmState.value.copy(
                        switchDeleteAfterUse = action.switchDeleteAfterUse
                    )
                }
            }
            is AlarmAddAction.ChangeOpenDialogDescription -> {
                _addAlarmState.update {
                    if (!action.openDialogDescription) {
                        addAlarmState.value.copy(
                            openDialogDescription = false,
                            description = ""
                        )
                    } else {
                        addAlarmState.value.copy(
                            openDialogDescription = true
                        )
                    }
                }
            }

            AlarmAddAction.AddAlarm -> {
                addAlarm()
            }
        }
    }

    private fun addAlarm() {
        val alarmItem = AlarmClockItem(
            description = addAlarmState.value.description.trim(),
            isEnabled = addAlarmState.value.isEnabled,
            minutesFromStartOfDay = addAlarmState.value.minutesFromStartOfDay,
            vibration = addAlarmState.value.vibration,
            dayOfTheWeek = addAlarmState.value.dayOfTheWeek
        )
        viewModelScope.launch {
            alarmUseCase.createAlarm(alarmItem)
            _alarmAddedEvent.emit(Unit)
        }
    }
}