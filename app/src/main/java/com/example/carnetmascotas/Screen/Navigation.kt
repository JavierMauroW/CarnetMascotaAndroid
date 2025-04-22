package com.example.carnetmascotas.Screen





import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carnetmascotas.Screen.ScreenA
import com.example.carnetmascotas.Screen.ScreenB

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController)
        }

        // Define correctamente los argumentos esperados
        composable("screenB/{nombre}/{raza}/{tamano}/{fotoUrl}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val raza = backStackEntry.arguments?.getString("raza") ?: ""
            val tamano = backStackEntry.arguments?.getString("tamano") ?: ""
            val fotoUrl = backStackEntry.arguments?.getString("fotoUrl") ?: ""
            ScreenB(nombre, raza, tamano, fotoUrl)
        }
    }
}
