package com.example.alarmclockapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alarmclockapp.presentation.addAlarmScreen.AddAlarmScreen
import com.example.alarmclockapp.presentation.addAlarmScreen.AddAlarmViewModel
import com.example.alarmclockapp.presentation.homeAlarmClock.AlarmClockScreen
import com.example.alarmclockapp.presentation.homeAlarmClock.AlarmListViewModel

@Composable
fun AlarmClockApp() {
    val navController = rememberNavController()
    val alarmListViewModel = hiltViewModel<AlarmListViewModel>()
    val addAlarmViewModel = hiltViewModel<AddAlarmViewModel>()
    val alarmList by alarmListViewModel.alarmItems.collectAsState()
    val addAlarmState by addAlarmViewModel.addAlarmState.collectAsState()

    NavHost(navController = navController, startDestination = Screen.AlarmClock.route) {

        composable(route = Screen.AlarmClock.route) {
            AlarmClockScreen(
                onAddAlarmClick = { navController.navigate(Screen.AddAlarmClock.route) },
                alarmsList = alarmList
            )
        }

        composable(route = Screen.AddAlarmClock.route) {
            AddAlarmScreen(
                onSaveClick = { navController.popBackStack() },
                onAction = addAlarmViewModel::onAction,
                onBackClick = { navController.popBackStack() },
                addAlarmState = addAlarmState
            )
        }

    }
}