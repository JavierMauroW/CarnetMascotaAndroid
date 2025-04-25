package com.example.carnetmascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.rememberNavController
import com.example.carnetmascotas.Screen.Carnet
import com.example.carnetmascotas.Screen.Navigation
import com.example.carnetmascotas.ui.theme.CarnetMascotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarnetMascotasTheme {
                val carnetList = mutableStateListOf<Carnet>()
                val navController = rememberNavController()
                Navigation(navController = navController, carnetList = carnetList)
            }
        }
    }
}