package com.example.alarmclockapp.presentation.homeAlarmClock.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmclockapp.presentation.homeAlarmClock.model.AlarmsListState
import com.example.alarmclockapp.R
import com.example.alarmclockapp.domain.DayOfWeek
import com.example.alarmclockapp.presentation.utils.toFormattedTime

@Composable
fun     AlarmContent(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    alarms: AlarmsListState,
) {
    Column (
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
        ){
            items(alarms.listItems) { alarm ->
                val switchIsEnabled = rememberSaveable {
                    mutableStateOf(alarm.isEnabled)
                }
                Card(
                    onClick = {  },
                    modifier = Modifier
                        .height(120.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = alarm.minutesFromStartOfDay.toFormattedTime(),
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    color = MaterialTheme.colorScheme.onSurface
                                ),
                                modifier = Modifier.weight(1f),
                            )
                            Switch(
                                checked = switchIsEnabled.value,
                                onCheckedChange = {
                                    switchIsEnabled.value = it
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                                    uncheckedThumbColor = MaterialTheme.colorScheme.onSurface
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            DayOfWeek.entries.forEach { day ->
                                val isActive = day in alarm.dayOfTheWeek
                                val textColor = if (isActive) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable {

                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = stringResource(
                                            id = when (day) {
                                                DayOfWeek.MONDAY -> R.string.mon
                                                DayOfWeek.TUESDAY -> R.string.tue
                                                DayOfWeek.WEDNESDAY -> R.string.wed
                                                DayOfWeek.THURSDAY -> R.string.thu
                                                DayOfWeek.FRIDAY -> R.string.fri
                                                DayOfWeek.SATURDAY -> R.string.sat
                                                DayOfWeek.SUNDAY -> R.string.sun
                                                else -> R.string.mon
                                            }
                                        ),
                                        fontSize = 12.sp,
                                        color = textColor,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}