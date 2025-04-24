package com.example.carnetmascotas.Screen

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("") }
    var fotoUrl by remember { mutableStateOf("") }

    val camposCompletos = nombre.isNotBlank() && raza.isNotBlank() && tamano.isNotBlank() && fotoUrl.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Mascota",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
                OutlinedTextField(value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
                OutlinedTextField(value = tamano, onValueChange = { tamano = it }, label = { Text("Tamaño") })
                OutlinedTextField(value = fotoUrl, onValueChange = { fotoUrl = it }, label = { Text("Foto URL") })

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val encodedNombre = Uri.encode(nombre)
                        val encodedRaza = Uri.encode(raza)
                        val encodedTamano = Uri.encode(tamano)
                        val encodedUrl = Uri.encode(fotoUrl)

                        navController.navigate("screenB/$encodedNombre/$encodedRaza/$encodedTamano/$encodedUrl")
                    },
                    enabled = camposCompletos,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Registrar Mascota")
                }

                if (!camposCompletos) {
                    Text(
                        text = "Por favor, completa todos los campos",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
