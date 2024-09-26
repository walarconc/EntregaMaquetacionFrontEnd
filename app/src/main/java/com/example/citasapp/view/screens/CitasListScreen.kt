package com.example.citasapp.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class Item(val titulo: String, val descripcion: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitasListScreen( onClickCitaDetail: (citaid: String) -> Unit,
                     onClickAddCita: () -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Tus citas",
                        fontFamily = FontFamily.Default,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Box(modifier = Modifier.padding(end = 15.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Acciones para tarea",
                            tint = Color(0xFF3E4A40)
                        )
                    }
                }
            }
                //colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFF5FBF3))

                  )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onClickAddCita()},
                containerColor = Color(0xFF006D3D),
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(Icons.Outlined.AddCircleOutline, "Floating action button.",
                    tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(modifier = Modifier.padding(bottom = 5.dp, top = 30.dp, start = 10.dp)) {
                Text(
                    text = "Próximas",
                    fontFamily = FontFamily.Default,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Box() {
                val items = listOf(
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100.")
                )

                Column {
                    LazyColumn {
                        items(items) { item ->
                            ListItemRow(item.titulo,item.descripcion,
                                modifier = Modifier.background(
                                    color = Color(0xFFF5FBF3)
                                )){
                                println("Clic en: $item")
                                onClickCitaDetail("1")
                            }
                            Divider()
                        }
                    }
                }
            }

            Box(modifier = Modifier.padding(bottom = 5.dp, top = 84.dp, start = 10.dp)) {
                Text(
                    text = "Pasadas",
                    fontFamily = FontFamily.Default,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Box() {
                val items = listOf(
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100."),
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100."),
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100."),
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100."),
                    Item("Medicina General", "El  23 de agosto a las 3pm en La Calle 100.")
                )

                Column {
                    LazyColumn {
                        items(items) { item ->
                            ListItemRow(item.titulo,item.descripcion,
                                modifier = Modifier.background(
                                    color = Color(0xFFF5FBF3)
                                )){
                                println("Clic en: $item")
                                onClickCitaDetail("1")
                            }
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListItemRow(titulo: String, descripcion: String, modifier: Modifier = Modifier
                , onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(88.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart,


        ) {
        var taskMenuOpen by remember { mutableStateOf(false) }
        var action by remember { mutableStateOf("Ninguna") }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column{
                Text(text = titulo, style = MaterialTheme.typography.subtitle1)
                Text(text = descripcion, style = MaterialTheme.typography.caption)
            }
            IconButton(
                onClick = { taskMenuOpen = true },
                modifier = Modifier
                    .size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Acciones para tarea"
                )
                TaskMenu(
                    expanded = taskMenuOpen,
                    onItemClick = { action = it },
                    onDismiss = {
                        taskMenuOpen = false
                    }
                )
            }
        }
    }
}


@Composable
fun TaskMenu(
    expanded: Boolean,
    onItemClick: (String) -> Unit,
    onDismiss: () -> Unit
) {

    data class Item(val titulo: String, val icon: ImageVector)
    val options = listOf(Item("Eliminar", Icons.Outlined.Delete),
        Item("Editar", Icons.Outlined.Create))

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss,
        modifier = Modifier
            .background(Color(0xFFE9F0E7))
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onItemClick(option.titulo)
                    onDismiss()
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = option.icon,
                        contentDescription = "Acciones para tarea"
                    )
                    Text(text = option.titulo)
                }
            }
        }
    }
}