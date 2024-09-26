package com.example.citasapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.citasapp.view.screens.LoginScreen
import androidx.navigation.compose.composable
import com.example.citasapp.view.screens.home.HomeScreen


@Composable
fun RootNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Graph.LOGIN
    ){
        composable(route = Graph.LOGIN){
            LoginScreen(
                onClick = { navController.navigate(Graph.HOME) }
            )
        }
        composable(route = Graph.HOME) {
            HomeScreen(

            )
        }

    }

}

object Graph {
    const val LOGIN = "login"
    const val HOME = "home_graph"


}

