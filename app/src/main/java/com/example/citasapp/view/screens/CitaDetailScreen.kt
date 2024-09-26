@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class
)
package com.example.citasapp.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitaDetailScreen(
    onClickGoToRecordatorios: () -> Unit,
    onClickBack: () -> Unit,
){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Detalle: Medicina general",
                        fontFamily = FontFamily.Default,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Box(modifier = Modifier.padding(end = 15.dp)) {
                        androidx.compose.material.Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Acciones para tarea",
                            tint = Color(0xFF3E4A40)
                        )
                    }
                }
            }
                //colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFF5FBF3))
            )
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )  {
            Box(modifier = Modifier.padding(bottom = 40.dp, top = 20.dp)) {
                var especialidad by remember {mutableStateOf("Medicina general")}
                Column{
                    TextField(
                        value = especialidad,
                        onValueChange = { especialidad = it },
                        readOnly = true,
                        label = { androidx.compose.material.Text("Especialidad") }
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 40.dp)) {
                var fecha by remember {mutableStateOf("08/17/2023")}
                Column{
                    TextField(
                        value = fecha,
                        onValueChange = { fecha = it },
                        readOnly = true,
                        label = { androidx.compose.material.Text("Fecha") }
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 40.dp)) {
                var hora by remember {mutableStateOf("07:00 AM")}
                Column{
                    TextField(
                        value = hora,
                        onValueChange = { hora = it },
                        readOnly = true,
                        label = { androidx.compose.material.Text("Hora") }
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 40.dp)) {
                var medico by remember {mutableStateOf("Pepito")}
                Column{
                    TextField(
                        value = medico,
                        onValueChange = { medico = it },
                        readOnly = true,
                        label = { androidx.compose.material.Text("Medico") }
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 40.dp)) {
                var notas by remember {mutableStateOf("Llevar resultados de examenes llevar acomopañante")}
                Column{
                    TextField(
                        value = notas,
                        onValueChange = { notas = it },
                        readOnly = true,
                        label = { androidx.compose.material.Text("Notas") },
                        modifier = Modifier.height(149.dp).width(280.dp),
                        maxLines = Int.MAX_VALUE,
                        singleLine = false,
                    )
                }
            }

            Box(modifier = Modifier.padding(start = 25.dp, end = 25.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(
                        onClick = onClickGoToRecordatorios,
                        modifier = Modifier.width(165.dp).height(55.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Outlined.Schedule,
                                contentDescription = "" // Add a valid content description
                            )
                            Spacer(Modifier.width(5.dp))
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Ver")
                                Text("recordatorios")
                            }
                        }
                    }

                    Button(
                        onClick = onClickGoToRecordatorios,
                        modifier = Modifier.width(165.dp).height(55.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Outlined.AddCircleOutline,
                                contentDescription = "" // Add a valid content description
                            )
                            Spacer(Modifier.width(5.dp))
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Agregar")
                                Text("recordatorios")
                            }
                        }
                    }
                }
            }
        }
    }

}