package com.example.alarmclockapp.presentation.addAlarmScreen.timeinput

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.alarmclockapp.R
import com.example.alarmclockapp.domain.DayOfWeek
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Replay (
    onReplayClick: () -> Unit,
    openBottomSheetReplay: Boolean,
    onAction: (AlarmAddAction) -> Unit,
    selectedDays: Set<DayOfWeek>,
) {
    val listOfWeek = listOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )
    val sheetState = rememberModalBottomSheetState()
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RectangleShape,
        modifier = Modifier
            .clickable {
                onReplayClick()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.replay),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Choose music",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
    if (openBottomSheetReplay) {
        ModalBottomSheet(
            onDismissRequest = {onAction(AlarmAddAction.ChangeOpenBottomSheetReplay(false))},
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            content = {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        items(listOfWeek) { day->
                            val dayOfWeekEnum = stringToDayOfWeek(day)
                            val isSelected = selectedDays.contains(dayOfWeekEnum)
                            Card (
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        updateSelectedDay(dayOfWeekEnum, !isSelected, onAction)
                                    }
                            ) {
                                Row {
                                    Text(
                                        text = stringResource(
                                            id = when (day) {
                                                "Monday" -> R.string.monday
                                                "Tuesday" -> R.string.tuesday
                                                "Wednesday" -> R.string.wednesday
                                                "Thursday" -> R.string.thursday
                                                "Friday" -> R.string.friday
                                                "Saturday" -> R.string.saturday
                                                "Sunday" -> R.string.sunday
                                                else -> R.string.monday
                                            }
                                        ),
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant),
                                        modifier = Modifier
                                            .padding(10.dp)
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Checkbox(
                                        checked = isSelected,
                                        onCheckedChange = {
                                            updateSelectedDay(dayOfWeekEnum, it, onAction)
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkmarkColor = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

private fun stringToDayOfWeek(day: String): DayOfWeek {
    return when (day) {
        "Monday" -> DayOfWeek.MONDAY
        "Tuesday" -> DayOfWeek.TUESDAY
        "Wednesday" -> DayOfWeek.WEDNESDAY
        "Thursday" -> DayOfWeek.THURSDAY
        "Friday" -> DayOfWeek.FRIDAY
        "Saturday" -> DayOfWeek.SATURDAY
        "Sunday" -> DayOfWeek.SUNDAY
        else -> DayOfWeek.MONDAY
    }
}

private fun updateSelectedDay(
    dayOfWeek: DayOfWeek,
    isSelected: Boolean,
    onAction: (AlarmAddAction) -> Unit
) {
    onAction(AlarmAddAction.ChangeDayOfWeek(dayOfWeek, isSelected))
}