package com.example.citasapp.view.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.citasapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onClick: () -> Unit) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Icono",
                modifier = Modifier
                    .width(85.dp)
                    .height(124.dp)
            )
            Box(modifier = Modifier.padding(bottom = 28.dp, top = 28.dp)) {
                Text(
                    text = "LOGIN",
                    fontFamily = FontFamily.Default,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Box(modifier = Modifier.padding(bottom = 59.dp)) {
                var name by remember {
                    mutableStateOf("")
                }

                Column {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Usuario") },
                        modifier = Modifier
                            .background(Color(0xFFDEE4DC)),
                    )
                    Text(
                        text = "Tu usuario",
                        color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 59.dp)) {
                var password by remember {
                    mutableStateOf("")
                }

                Column{

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña") }
                    )
                    Text(
                        text = "Tu contraseña",
                        color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }

            Box(modifier = Modifier.padding(bottom = 59.dp)) {
                Button(onClick = { onClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF006D3D)
                    ),
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)

                ) {
                    Text(text = "Ingresar", color = Color(0xFFFFFFFF))
                }
            }

            Box(modifier = Modifier.padding(bottom = 59.dp)) {
                Button(onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    shape = ButtonDefaults.shape,
                    modifier = Modifier
                        .width(309.dp)
                        .height(40.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDADCE0),
                            shape = ButtonDefaults.shape
                        )
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "Icono",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Usar Goolge",
                            )
                        }
                    }

                }
            }

            Box(modifier = Modifier.padding(bottom = 59.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Recuperar",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF171D18),
                        )
                        Text(
                            text = "contraseña",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF171D18),
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Registrarse",
                            fontFamily = FontFamily.Default,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF171D18),
                        )
                    }

                }
            }
        }
    }
}