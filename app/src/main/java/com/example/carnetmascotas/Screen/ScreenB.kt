package com.example.carnetmascotas.Screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.navigation.NavController

@Composable
fun ScreenB(carnetList: MutableList<Carnet>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Carnets Registrados",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 26.sp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(carnetList) { index, carnet ->
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = carnet.fotoUrl,
                            contentDescription = "Foto mascota",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Nombre: ${carnet.nombre}")
                        Text("Raza: ${carnet.raza}")
                        Text("Tamaño: ${carnet.tamano}")
                        Text("Edad: ${carnet.edad}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Button(onClick = {
                                navController.navigate("screenA/$index")
                            }) {
                                Text("Editar")
                            }

                            Button(
                                onClick = {
                                    carnetList.removeAt(index)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                            ) {
                                Text("Eliminar", color = MaterialTheme.colorScheme.onError)
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("screenA") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Registrar nueva mascota")
        }
    }
}
