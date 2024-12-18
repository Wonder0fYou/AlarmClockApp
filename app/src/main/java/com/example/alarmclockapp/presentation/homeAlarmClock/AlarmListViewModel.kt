package com.example.alarmclockapp.presentation.homeAlarmClock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockapp.presentation.addAlarmScreen.AddAlarmViewModel
import com.example.alarmclockapp.presentation.homeAlarmClock.model.AlarmsListAction
import com.example.alarmclockapp.presentation.homeAlarmClock.model.AlarmsListState
import com.example.alarmclockapp.domain.AlarmClockItem
import com.example.alarmclockapp.domain.AlarmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmListViewModel @Inject constructor(
    private val alarmUseCase: AlarmUseCase
): ViewModel(){

    private val _alarmItems = MutableStateFlow(AlarmsListState())
    val alarmItems = _alarmItems.asStateFlow()

    init {
        loadAlarmItems()
        observeAlarmAddedEvent()
    }

    private fun loadAlarmItems() {
        viewModelScope.launch {
            alarmUseCase.getAllAlarms().collect {alarmList: List<AlarmClockItem> ->
                _alarmItems.update {
                    alarmItems.value.copy(
                        listItems = alarmList
                    )
                }
            }
        }
    }

    private fun observeAlarmAddedEvent() {
        viewModelScope.launch {
            AddAlarmViewModel.alarmAddedEvent.collect {
                loadAlarmItems()
            }
        }
    }

    fun onAction(action: AlarmsListAction) {
        when(action) {
            is AlarmsListAction.UpdateDayOfWeek -> {

            }

            AlarmsListAction.DeleteAlarm -> {
                deleteAlarm()
            }
            AlarmsListAction.UpdateAlarm -> {
                updateAlarm()
            }
        }
    }

    private fun deleteAlarm() {

    }

    private fun updateAlarm() {

    }
}