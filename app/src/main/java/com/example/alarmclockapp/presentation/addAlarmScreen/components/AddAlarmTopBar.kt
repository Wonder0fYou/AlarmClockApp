package com.example.alarmclockapp.presentation.addAlarmScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.alarmclockapp.R
import com.example.alarmclockapp.presentation.addAlarmScreen.model.AlarmAddAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlarmTopBar(
    onSaveClick: () -> Unit,
    onAction: (AlarmAddAction) -> Unit,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(
            text = stringResource(id = R.string.new_alarm),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        )},
        navigationIcon = {
            IconButton(onClick = {onBackClick()}) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions = {
            IconButton(onClick = {
                onAction(AlarmAddAction.AddAlarm)
                onSaveClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "AddAlarm",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}