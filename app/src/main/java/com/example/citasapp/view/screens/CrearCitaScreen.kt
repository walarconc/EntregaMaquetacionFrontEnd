@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalMaterial3Api::class
)

package com.example.citasapp.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrearCitaScreen(
    onClickBack: () -> Unit,
//    onClickCancel: () -> Unit,
//    onClickCreate: () -> Unit,
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = { TopAppCrearCita(scrollBehavior, onClickBack) },
        modifier = Modifier
            .fillMaxSize(),
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)){
            CrearCitaContent()
        }

    }
}

@Composable
fun CrearCitaContent(){

    FlowRow(
        modifier = Modifier.padding(8.dp),
        Arrangement.SpaceBetween,
        Arrangement.SpaceEvenly,
    ){
        Button(
            onClick = {},
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "" // Add a valid content description
            )
            Spacer(Modifier.width(2.dp))
            Text("Cancelar")
        }
        Button(
            onClick = {},
        ) {
            Icon(
                Icons.Outlined.AddCircle,
                contentDescription = "" // Add a valid content description
            )
            Spacer(Modifier.width(2.dp))
            Text("Crear")
        }
    }

}


@Composable
fun TopAppCrearCita(
    scrollBehavior: TopAppBarScrollBehavior,
    onClick: () -> Unit
){
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