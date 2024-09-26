@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class
)

package com.example.citasapp.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun CrearCitaScreen(
    onClickBack: () -> Unit,
    onClickCrearCita: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = { TopAppCrearCita(scrollBehavior, onClickBack) },
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            CrearCitaFormulario(onCliclCancelar = onClickBack, onClickAgregar = onClickCrearCita)
        }

    }
}

@Composable
fun DatePickerField() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
    ) {
        val focusManager = LocalFocusManager.current
        TextField(
            value = selectedDate,
            supportingText = { Text("MM/DD/YYYY") },
            onValueChange = { },
            label = { Text("Fecha") },
            modifier = Modifier.onFocusEvent { focusState ->
                if (focusState.isFocused) {
                    showDatePicker = true
                    focusManager.clearFocus()
                }
            }
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart,
                properties = PopupProperties(dismissOnClickOutside = true)
            ) {
                FlowColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false,
                        title = { Text("Selecciona una fecha") },
                        dateFormatter = DatePickerDefaults.dateFormatter(selectedDateSkeleton = "MM/dd/yyyy"),
                    )
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(
                            onClick = {
                                selectedDate?.let {
                                    datePickerState.selectedDateMillis = null
                                }
                            },
                            enabled = true
                        ) {
                            Text("Limpiar")
                        }
                        FlowRow() {
                            TextButton(
                                onClick = {
                                    showDatePicker = false
                                    selectedDate?.let {
                                        datePickerState.selectedDateMillis = null
                                    }
                                },
                                enabled = true,
                            ) {
                                Text("Cancelar")
                            }
                            TextButton(
                                onClick = { showDatePicker = false },
                                enabled = selectedDate.isNotEmpty(),

                                ) {
                                Text("OK")
                            }
                        }

                    }


                }
            }
        }
    }
}

@Composable
fun HourTimePickerField() {
    var showHourPicker by remember { mutableStateOf(false) }
    val currentTime = Calendar.getInstance()
    var selectedTime: TimePickerState? by remember { mutableStateOf(null) }

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )
    Box(
    ) {
        val focusManager = LocalFocusManager.current
        TextField(
            value = selectedTime.toString(),
            supportingText = { Text("Hora de la cita") },
            onValueChange = {  },
            label = { Text("Hora") },
            modifier = Modifier.onFocusEvent { focusState ->
                if (focusState.isFocused) {
                    showHourPicker = true
                    focusManager.clearFocus()
                }
            }
        )

        if (showHourPicker) {
            Popup(
                onDismissRequest = { showHourPicker = false },
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
                                onClick = {
                                    timePickerState
                                    showHourPicker = false
//                                    selectedDate = ""
                                },
                                enabled = true,
                            ) {
                                Text("Cancelar")
                            }
                            TextButton(
                                onClick = { showHourPicker = false },
                                enabled = timePickerState.toString().isNotEmpty(),
                                ) {
                                Text("OK")
                            }
                        }

                    }


                }
            }
        }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}


@Composable
fun inputFields() {
    val especialidad = remember { mutableStateOf("") }
    val hora = remember { mutableStateOf("") }
    val medico = remember { mutableStateOf("") }
    val notas = remember { mutableStateOf("") }

    TextField(
        value = especialidad.value,
        supportingText = { Text("Nombre de la cita") },
        onValueChange = { especialidad.value = it },
        label = { Text("Especialidad") },
    )

    DatePickerField()
    HourTimePickerField()

    TextField(
        value = medico.value,
        supportingText = { Text("Nombre del medico") },
        onValueChange = { medico.value = it },
        label = { Text("Medico") },

        )
    TextField(
        value = notas.value,
        supportingText = { Text("Notas para la cita.") },
        onValueChange = { notas.value = it },
        label = { Text("Notas") },
        modifier = Modifier.height(150.dp)
    )

}

@Composable
fun BotonesCrearCita(onCliclCancelar: () -> Unit, onClickAgregar: () -> Unit) {
    Button(
        onClick = onClickAgregar,
    ) {
        Icon(
            Icons.Outlined.AddCircle,
            contentDescription = "" // Add a valid content description
        )
        Spacer(Modifier.width(2.dp))
        Text("Agregar")
    }
    Button(
        onClick = onCliclCancelar,
    ) {
        Icon(
            Icons.Outlined.Cancel,
            contentDescription = "" // Add a valid content description
        )
        Spacer(Modifier.width(2.dp))
        Text("Cancelar")
    }
}

@Composable
fun CrearCitaFormulario(onCliclCancelar: () -> Unit, onClickAgregar: () -> Unit) {

    FlowColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        inputFields()
        FlowRow() {
            BotonesCrearCita(
                onCliclCancelar = onCliclCancelar,
                onClickAgregar = onClickAgregar
            )
        }

    }

}


@Composable
fun TopAppCrearCita(
    scrollBehavior: TopAppBarScrollBehavior,
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text("Nueva cita")
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "" // Add a valid content description
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "" // Add a valid content description
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}