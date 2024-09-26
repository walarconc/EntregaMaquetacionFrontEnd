package com.example.citasapp.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CitasListScreen(
    onClickCitaDetail: (citaid: String) -> Unit,
    onClickAddCita: () -> Unit,
){
    Text("Listar citas")
    Button(
        onClick = {onClickCitaDetail("1")},
    ) {
        Spacer(Modifier.width(2.dp))
        Text("Ir a detalle de cita")
    }
    Button(
        onClick = {onClickAddCita()},
    ) {
        Spacer(Modifier.width(2.dp))
        Text("Crear cita")
    }
}