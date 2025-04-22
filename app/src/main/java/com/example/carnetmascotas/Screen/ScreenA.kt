package com.example.carnetmascotas.Screen



import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("") }
    var fotoUrl by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
        OutlinedTextField(value = tamano, onValueChange = { tamano = it }, label = { Text("Tamaño") })
        OutlinedTextField(value = fotoUrl, onValueChange = { fotoUrl = it }, label = { Text("Foto URL") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val encodedUrl = Uri.encode(fotoUrl)
            navController.navigate("screenB/$nombre/$raza/$tamano/$encodedUrl")
        }) {
            Text("Registrar")
        }
    }
}
