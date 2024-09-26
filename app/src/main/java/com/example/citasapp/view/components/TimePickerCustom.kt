@file:OptIn(ExperimentalLayoutApi::class)

package com.example.citasapp.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerCustom(
    onCancelSelection: () -> Unit,
    onSelectedTime: (timeSelected: String) -> Unit
) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )
    Popup(
        onDismissRequest = onCancelSelection,
        alignment = Alignment.TopStart,
        properties = PopupProperties(dismissOnClickOutside = true)
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp)
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TimePicker(
                state = timePickerState,
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onCancelSelection,
                    enabled = true,
                ) {
                    Text("Cancelar")
                }
                TextButton(
                    onClick = {

                        val cal = Calendar.getInstance()
                        cal.set(Calendar.HOUR_OF_DAY, timePickerState.hour)
                        cal.set(Calendar.MINUTE, timePickerState.minute)
                        cal.isLenient = false
                        onSelectedTime(
                            SimpleDateFormat(
                                "hh:mm a",
                                Locale.getDefault()
                            ).format(cal.time)
                        )
                    },
                    enabled = true
                ) {
                    Text("OK")
                }
            }
        }
    }

}