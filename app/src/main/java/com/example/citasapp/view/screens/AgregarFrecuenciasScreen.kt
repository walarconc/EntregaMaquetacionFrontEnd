@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package com.example.citasapp.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.citasapp.view.components.TimePickerCustom
import com.example.citasapp.view.components.TopBar
import kotlin.time.Duration

@Composable
fun AgregarFrecuenciasScreen(
    onClickBack: () -> Unit,
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
            FlowColumn(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Frecuencias",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                ListaFrecuencias()
            }

        }
    }
}


@Composable
fun FrecuenciaItem(
    index: Int,
    frecuencia: String,
    triggerDeleteFrecuencia: (fr: Int) -> Unit = {},
    triggerCreateFrecuencia: (fr: String) -> Unit = {}
) {
    val adding = index < 0
    var showMenu by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    ListItem(
        modifier = Modifier.fillMaxWidth(),
        headlineContent = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = frecuencia,
                onValueChange = { },
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Outlined.Schedule,
                            contentDescription = "Localized description",
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = {
                        if (adding) {
                            showTimePicker = true
                        } else {
                            showMenu = true
                        }
                    }) {
                        Icon(
                            if (adding) Icons.Outlined.AddCircle else Icons.Outlined.MoreVert,
                            contentDescription = "Localized description",
                        )
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                { Text("Eliminar") },
                                onClick = {
                                    triggerDeleteFrecuencia(index)
                                    showMenu = false
                                }
                            )
                        }
                        if (showTimePicker) {
                            TimePickerCustom(
                                onCancelSelection = { showTimePicker = false },
                                onSelectedTime = {
                                    triggerCreateFrecuencia(it)
                                    showTimePicker = false
                                }
                            )
                        }
                    }
                },
                readOnly = true
            )
        }
    )

}

@Composable
fun ListaFrecuencias() {
    var frecuencias by remember { mutableStateOf(arrayListOf("7:00 AM", "10:00 PM", "11:40 AM")) }

    FlowColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        frecuencias.forEachIndexed { index, frecuencia ->
            FrecuenciaItem(index, frecuencia = frecuencia, triggerDeleteFrecuencia = { indexIn ->
                frecuencias =
                    frecuencias.filterIndexed { index, _ -> index != indexIn } as ArrayList<String>
            })
        }
        FrecuenciaItem(-1, frecuencia = "__:__ __", triggerCreateFrecuencia = {
            frecuencias = arrayListOf(*frecuencias.toTypedArray(), it)
        })
    }
}

