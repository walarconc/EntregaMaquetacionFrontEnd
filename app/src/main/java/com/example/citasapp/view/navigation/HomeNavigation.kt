package com.example.citasapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.citasapp.view.screens.CitasListScreen
import com.example.citasapp.view.screens.CrearCitaScreen

@Composable
fun HomeNavigation(

    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = GraphHome.CITAS,
    ) {
        composable(
            route = GraphHome.CITAS,
        ) {
            CitasListScreen(

            )
        }
        composable(route = GraphHome.NUEVA_CITA) {
            CrearCitaScreen(
                onClickBack = {
                    navController.popBackStack()
                }
            )
        }
    }

}

object GraphHome {
    const val CITAS = "citas"
    const val NUEVA_CITA = "nueva_cita"

}
