package com.example.carnetmascotas.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController, carnetList: MutableList<Carnet>, editIndex: Int?) {
    val carnetToEdit = editIndex?.let { carnetList.getOrNull(it) }

    var nombre by remember { mutableStateOf(carnetToEdit?.nombre ?: "") }
    var raza by remember { mutableStateOf(carnetToEdit?.raza ?: "") }
    var tamano by remember { mutableStateOf(carnetToEdit?.tamano ?: "") }
    var edad by remember { mutableStateOf(carnetToEdit?.edad ?: "") }
    var fotoUrl by remember { mutableStateOf(carnetToEdit?.fotoUrl ?: "") }

    val camposLlenos = nombre.isNotBlank() && raza.isNotBlank() && tamano.isNotBlank() && edad.isNotBlank() && fotoUrl.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (editIndex != null) "✏️ Editar Carnet de Mascota" else "🐾 Registro de Mascota",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("🐶 Nombre") })
                OutlinedTextField(value = raza, onValueChange = { raza = it }, label = { Text("🐕 Raza") })
                OutlinedTextField(value = tamano, onValueChange = { tamano = it }, label = { Text("📏 Tamaño") })
                OutlinedTextField(value = edad, onValueChange = { edad = it }, label = { Text("🎂 Edad") })
                OutlinedTextField(value = fotoUrl, onValueChange = { fotoUrl = it }, label = { Text("🖼️ Foto URL") })

                Button(
                    onClick = {
                        val nuevoCarnet = Carnet(nombre, raza, tamano, edad, fotoUrl)

                        if (editIndex != null && editIndex >= 0 && editIndex < carnetList.size) {
                            carnetList[editIndex] = nuevoCarnet
                        } else {
                            carnetList.add(nuevoCarnet)
                        }

                        navController.navigate("screenB") {
                            popUpTo("screenA") { inclusive = true }
                        }
                    },
                    enabled = camposLlenos,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(55.dp)
                ) {
                    Text(
                        if (editIndex != null) "✅ Actualizar Mascota" else "➕ Registrar Mascota",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

