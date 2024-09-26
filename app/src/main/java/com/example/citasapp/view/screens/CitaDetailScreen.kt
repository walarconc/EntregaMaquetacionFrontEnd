package com.example.citasapp.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CitaDetailScreen(
    onClickGoToRecordatorios: () -> Unit,
    onClickBack: () -> Unit,
){
    Text("Detalle cita" )
    Button(
        onClick = onClickGoToRecordatorios,
    ) {
        Icon(
            Icons.Outlined.AddCircle,
            contentDescription = "" // Add a valid content description
        )
        Spacer(Modifier.width(2.dp))
        Text("Agregar recordaotiro")
    }

}