package com.example.carnetmascotas.Screen




import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ScreenB(nombre: String, raza: String, tamano: String, fotoUrl: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Nombre: $nombre")
        Text("Raza: $raza")
        Text("Tamaño: $tamano")

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = rememberImagePainter(data = fotoUrl),
            contentDescription = "Foto de la mascota",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}
