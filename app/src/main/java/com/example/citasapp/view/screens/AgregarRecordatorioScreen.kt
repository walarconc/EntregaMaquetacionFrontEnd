@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalLayoutApi::class, ExperimentalLayoutApi::class
)

package com.example.citasapp.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.citasapp.view.components.TopBar

@Composable
fun AgregarRecordatorioScreen(
    onClickBack: () -> Unit,
    onClickAgregarFrecuencia: () -> Unit,
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = { TopBar("Recordatorios: Medicina general", scrollBehavior, onClickBack) },
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AgregarRecordatorio(
                onClickAgregarFrecuencia = onClickAgregarFrecuencia,
                onClickBack = onClickBack
            )
        }

    }

}

@Composable
fun MultiSelectCalendar(
    onEnableSiguiente: (Boolean) -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePicker(
        state = datePickerState,
        title = { Text("Fechas para el recordatorio") },
        dateFormatter = DatePickerDefaults.dateFormatter(selectedDateSkeleton = "MM/dd/yyyy"),
    )
    LaunchedEffect(datePickerState.selectedDateMillis) {
        onEnableSiguiente(datePickerState.selectedDateMillis != null)
    }

}


@Composable
fun AgregarRecordatorio(
    onClickAgregarFrecuencia: () -> Unit,
    onClickBack: () -> Unit
) {

    val enableSiguiente = remember { mutableStateOf(false) }
    FlowColumn(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            "Seleccionar fechas para el recordatorio",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
        MultiSelectCalendar(
            onEnableSiguiente = { enableSiguiente.value = it }
        )
        FlowRow(
            modifier = Modifier
                .padding(25.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = onClickBack,
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.error,
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Icon(
                    Icons.Outlined.Cancel,
                    contentDescription = "" // Add a valid content description
                )
                Spacer(Modifier.width(2.dp))
                Text("Cancelar")
            }
            Button(
                onClick = onClickAgregarFrecuencia,
                enabled = enableSiguiente.value
            ) {
                Icon(
                    Icons.Outlined.Schedule,
                    contentDescription = "" // Add a valid content description
                )
                Spacer(Modifier.width(2.dp))
                Text("Frecuencia")
            }
        }
    }
}