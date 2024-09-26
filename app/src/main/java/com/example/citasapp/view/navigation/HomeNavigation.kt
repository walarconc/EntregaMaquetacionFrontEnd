package com.example.citasapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.citasapp.view.screens.AgregarFrecuenciasScreen
import com.example.citasapp.view.screens.AgregarRecordatorioScreen
import com.example.citasapp.view.screens.CitaDetailScreen
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
                onClickCitaDetail = { navController.navigate(GraphHome.CITAS_DETAIL) },
                onClickAddCita = { navController.navigate(GraphHome.NUEVA_CITA)}
            )
        }
        composable(route = GraphHome.NUEVA_CITA) {
            CrearCitaScreen(
                onClickBack = { navController.popBackStack() },
                onClickCrearCita ={ navController.navigate(GraphHome.CITAS_DETAIL)}
            )
        }

            composable(route=GraphHome.CITAS_DETAIL) {
                CitaDetailScreen(
                    onClickGoToRecordatorios = {
                        navController.navigate(GraphHome.RECORDATORIOS_CITA)
                    },
                    onClickBack = {
                        navController.popBackStack()
                    }
                )
            }

        composable(route=GraphHome.RECORDATORIOS_CITA) {
            AgregarRecordatorioScreen(
                onClickAgregarFrecuencia = {
                    navController.navigate(GraphHome.FRECUENCIA_RECORDATORIO)
                },
                onClickBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route=GraphHome.FRECUENCIA_RECORDATORIO) {
            AgregarFrecuenciasScreen(
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
    const val CITAS_DETAIL = "cita_detail"
    const val RECORDATORIOS_CITA  = "recordatorios_cita"
    const val FRECUENCIA_RECORDATORIO = "frecuencia_recordatorio"
}
