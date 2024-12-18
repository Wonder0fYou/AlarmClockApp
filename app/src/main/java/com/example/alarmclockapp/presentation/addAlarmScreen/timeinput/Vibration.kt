package com.example.alarmclockapp.presentation.addAlarmScreen.timeinput

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.alarmclockapp.R
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction

@Composable
fun Vibration (
    onVibrateClick: () -> Unit,
    switchVibration: Boolean,
    onAction: (AlarmAddAction) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RectangleShape,
        modifier = Modifier
            .clickable {
                onVibrateClick()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.vibrate_at_a_signal),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = switchVibration,
                onCheckedChange = {
                    onAction(AlarmAddAction.ChangeSwitchVibration(it))
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}