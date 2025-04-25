package com.example.carnetmascotas.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, carnetList: MutableList<Carnet>) {
    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController, carnetList, null)
        }
        composable("screenA/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull()
            ScreenA(navController, carnetList, index)
        }
        composable("screenB") {
            ScreenB(carnetList = carnetList, navController = navController)
        }
    }
}
