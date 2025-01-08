package com.erick.polimuseovr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erick.polimuseovr.ui.theme.PoliMuseoVRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliMuseoVRTheme {
                SplashScreen {
                    // Aquí puedes navegar a otra actividad o pantalla
                    // Por simplicidad, reemplazaremos el contenido
                    setContent {
                        PoliMuseoVRTheme {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onContinue: () -> Unit) {
    // Contenedor principal
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Imagen del búho
            Image(
                painter = painterResource(id = R.drawable.owl_image), // Usa el recurso drawable
                contentDescription = "Imagen del búho",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título de la aplicación
            Text(
                text = "¡Bienvenido a PoliMuseoVR!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción breve
            Text(
                text = "Explora la historia y el arte de una manera única.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de continuar
            Button(onClick = onContinue) {
                Text(text = "Continuar")
            }
        }
    }
}

@Composable
fun HomeScreen() {
    // Pantalla de inicio simple
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Esta es la pantalla principal.", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    PoliMuseoVRTheme {
        SplashScreen(onContinue = {})
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PoliMuseoVRTheme {
        HomeScreen()
    }
}
