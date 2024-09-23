package com.example.citasapp.view.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.citasapp.view.navigation.GraphHome
import com.example.citasapp.view.navigation.HomeNavigation
import com.example.citasapp.view.navigation.currentRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

){
    val navHomeController = rememberNavController()
    val currentRoute = currentRoute(navHomeController)
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
//            TopBarHome(scrollBehavior = scrollBehavior)
        },
        bottomBar = {
            BottomBar(
                navController = navHomeController,
                currentRoute
            )
        }
    ){
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            HomeNavigation(
                navController = navHomeController
            )
        }
    }

}


@Composable
fun BottomBar (navController: NavHostController,
               currentRoute: String){
    BottomAppBar{
        NavigationBar{
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.Today,
                        contentDescription = "" // Add a valid content description
                    )
                },
                label = {
                    Text("Citas")
                },
                selected = currentRoute == GraphHome.CITAS,
                onClick = {
                    if (currentRoute != GraphHome.CITAS) {
                        navController.navigate( GraphHome.CITAS)
                    }
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Outlined.AddCircle,
                        contentDescription = "" // Add a valid content description
                    )
                },
                label = {
                    Text("Nueva cita")
                },
                selected = currentRoute == GraphHome.NUEVA_CITA,
                onClick = {
                    if (currentRoute != GraphHome.NUEVA_CITA) {
                        navController.navigate( GraphHome.NUEVA_CITA)
                    }
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = "" // Add a valid content description
                    )
                },
                label = {
                    Text("Perfil")
                },
                selected = false,
                onClick = {}
            )
        }
    }
}