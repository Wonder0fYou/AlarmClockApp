package com.example.alarmclockapp.presentation.homeAlarmClock.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.alarmclockapp.R
import com.example.alarmclockapp.presentation.homeAlarmClock.model.AlarmsListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAlarm (
    alarms: AlarmsListState
) {
    val topName: String = stringResource(id = if (alarms.listItems.size == 1) R.string.alarm else R.string.alarms)
    TopAppBar(
        title = {
            Text(
                text = topName,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}